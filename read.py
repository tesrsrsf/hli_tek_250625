import jsonlines

models = ['gpt4_python', 'gemini_python', 'gpt4_java', 'gemini_java', 'gpt4_cpp', 'gemini_cpp']
folder = 'dataset\\'

filename_id = 1
with open("final_annotation_dataset_part2.jsonl", "r+", encoding="utf-8") as f:
    for line in jsonlines.Reader(f):
        #print(line)
        filename = str(filename_id)
        if filename_id <= 9:
            filename = "0" + str(filename_id)

        problem = line["problem"]
        for model in models:
            solution = line[model]
            language = ''

            note_1 = ''
            note_2 = ''
            note_3 = ''

            if model in ['gpt4_cpp', 'gemini_cpp']:
                language = 'cpp'
                note_1 = '/*\n'
                note_2 = '\n*/'
                note_3 = '\n\n\n// =============SOLUTION STARTS HERE==============\n\n\n'
            elif model in ['gpt4_java', 'gemini_java']:
                language = 'java'
                note_1 = '/*\n'
                note_2 = '\n*/'
                note_3 = '\n\n\n// =============SOLUTION STARTS HERE==============\n\n\n'
            elif model in ['gpt4_python', 'gemini_python']:
                language = 'py'
                note_1 = '\'\'\'\n'
                note_2 = '\n\'\'\''
                note_3 = '\n\n\n# =============SOLUTION STARTS HERE==============\n\n\n'


            file_writer = open(f"dataset/Problem_{filename}_{model}.{language}", "w", encoding="utf-8")
            output = note_1 + problem + note_2 + note_3 + solution + "\n"
            file_writer.write(output + "\n")
            file_writer.close()

        filename_id += 1