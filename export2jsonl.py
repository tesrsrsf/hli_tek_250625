import jsonlines
import os
import re

input_file = "final_annotation_dataset_part2.jsonl"
output_file = "export.jsonl"
dataset_folder = "dataset"

models = ['gpt4_python', 'gemini_python', 'gpt4_java', 'gemini_java', 'gpt4_cpp', 'gemini_cpp']


def get_language_ext(model):
    if 'python' in model:
        return 'py'
    elif 'java' in model:
        return 'java'
    elif 'cpp' in model:
        return 'cpp'
    else:
        return None


def extract_solution_and_annotation(full_text, model):
    # STEP 1: 定位到 'SOLUTION STARTS HERE'
    split_marker = "SOLUTION STARTS HERE"
    if split_marker not in full_text:
        return full_text.strip(), None  # fallback

    after_marker = full_text.split(split_marker, 1)[1]

    # STEP 2: 跳过 marker 后的 3 行空行
    lines = after_marker.splitlines()
    code_lines = []
    empty_count = 0
    started = False

    for line in lines:
        if not started:
            if line.strip() == "":
                empty_count += 1
            else:
                empty_count = 0  # 非空行，重置
            if empty_count >= 3:
                started = True
            continue
        else:
            code_lines.append(line)

    # STEP 3: 查找 annotation 注释（根据语言）
    annotation = None
    annotation_pattern = None

    if 'python' in model:
        annotation_pattern = r"#\s*\{annotation:\s*\"(.*?)\"\s*\}"
    elif 'java' in model or 'cpp' in model:
        annotation_pattern = r"//\s*\{annotation:\s*\"(.*?)\"\s*\}"

    cleaned_lines = []
    for line in code_lines:
        if annotation_pattern and re.search(annotation_pattern, line):
            match = re.search(annotation_pattern, line)
            if match:
                annotation = match.group(1)
            continue  # 不写入该行
        cleaned_lines.append(line)

    final_code = "\n".join(cleaned_lines).strip()
    return final_code, annotation


with jsonlines.open(input_file, 'r') as reader, jsonlines.open(output_file, 'w') as writer:
    filename_id = 1

    for obj in reader:
        filename = f"{filename_id:02d}"
        question_id = obj["problem_id"]

        for model in models:
            ext = get_language_ext(model)
            file_path = os.path.join(dataset_folder, f"Problem_{filename}_{question_id}_{model}.{ext}")

            if os.path.exists(file_path):
                with open(file_path, 'r', encoding='utf-8') as code_file:
                    full_code = code_file.read()

                revised_code, annotation = extract_solution_and_annotation(full_code, model)
                obj[f"{model}_human_revised"] = revised_code
                if annotation:
                    obj[f"{model}_annotation"] = annotation

        writer.write(obj)
        filename_id += 1
