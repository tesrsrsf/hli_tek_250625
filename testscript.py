import subprocess
import os
import sys
from time import sleep


TESTCASE_FILE = 'tcinput.txt'

def detect_language(filename):
    if filename.endswith('.cpp'):
        return 'cpp'
    elif filename.endswith('.java'):
        return 'java'
    elif filename.endswith('.py'):
        return 'python'
    else:
        return None


def run_cpp(filepath, input_data):
    exe_path = 'run.exe'
    compile_result = subprocess.run(['g++', filepath, '-o', exe_path], capture_output=True, text=True)
    if compile_result.returncode != 0:
        print("Compilation failed:")
        print(compile_result.stderr)
        return
    try:
        run_result = subprocess.run([exe_path], input=input_data, capture_output=True, text=True, timeout=10)
        return f"Result of C++:\n{run_result.stdout}\n"
    finally:
        if os.path.exists(exe_path):
            os.remove(exe_path)


def run_java(filepath, input_data):
    classname = os.path.splitext(os.path.basename(filepath))[0]
    compile_result = subprocess.run(['javac', filepath], capture_output=True, text=True)
    if compile_result.returncode != 0:
        print("Compilation failed:")
        print(compile_result.stderr)
        return
    try:
        run_result = subprocess.run(['java', '-cp', os.path.dirname(filepath), classname],
                                    input=input_data, capture_output=True, text=True, timeout=10)
        return f"Result of Java:\n{run_result.stdout}\n"
    finally:
        class_file = os.path.join(os.path.dirname(filepath), classname + '.class')
        if os.path.exists(class_file):
            os.remove(class_file)


def run_python(filepath, input_data):
    try:
        run_result = subprocess.run(['python3', filepath], input=input_data, capture_output=True, text=True, timeout=5)
        return f"Result of Python:\n{run_result.stdout}\n"
    except subprocess.TimeoutExpired:
        return "Result of Python:\nError: Execution timed out after 5 seconds.\n"


def store_res_to_file(ress):
    filenames = {"cpp": "cpp_res.txt", "java": "java_res.txt", "python": "python_res.txt"}
    for res in ress:
        with open(f"{filenames[res]}", 'w') as filewriter:
            filewriter.write(ress[res])

    


def main():
    result = {}

    with open(TESTCASE_FILE, 'r', encoding='utf-8') as f:
        lines = [line.rstrip('\n') for line in f if line.strip()]
        if not lines:
            print(f"{TESTCASE_FILE} is empty")
            return
        filename = lines[0]
        test_input = '\n'.join(lines[1:]) + '\n'

    print(f"Running test case for {filename} with input:\n{test_input}")

    filepath = os.path.join('dataset', filename)

    #language = detect_language(filename)
    result['cpp'] = run_cpp(f"{filepath}_cpp.cpp", test_input)
    print("cpp finished")
    sleep(2)

    result['java'] = run_java(f"{filepath}_java.java", test_input)
    print("java finished")
    sleep(2)

    result['python'] = run_python(f"{filepath}_python.py", test_input)
    print("python finished")

    store_res_to_file(result)


if __name__ == '__main__':
    main()
