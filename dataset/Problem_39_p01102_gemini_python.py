'''
Almost Identical Programs

The programming contest named

Concours de Programmation Comtemporaine Interuniversitaire
 (CPCI)
has a judging system similar to that of ICPC;
contestants have to submit correct outputs for two different inputs
to be accepted as a correct solution.

Each of the submissions should include the program that generated
the output.  A pair of submissions is judged to be a correct
solution when, in addition to the correctness of the outputs, they
include an identical program.

Many contestants, however, do not stop including a different version
of their programs in their second submissions, after modifying a
single string literal in their programs representing 
the input file name, attempting to process different input.

The organizers of CPCI are exploring the possibility of showing a
special error message for such 
close
 submissions, 
indicating contestants what's wrong with such submissions.

Your task is to detect such close submissions.

Input

The input consists of at most 100 datasets, each in the following format.

s
1

s
2

Each of 
s
1
 and 
s
2
 is
a string written in a line, with the length between 1 and 200, inclusive.
They are the first and the second submitted programs respectively.

A program consists of lowercase letters (
a
, 
b
, ..., 
z
), uppercase letters (
A
, 
B
, ..., 
Z
),
digits (
0
, 
1
, ..., 
9
), double quotes (
"
), and semicolons (
;
).
When double quotes occur in a program, there are always even number of them.

The end of the input is indicated by a line containing one '
.
' (period).

Output

For each dataset, print the judge result in a line.

If the given two programs are identical, print 
IDENTICAL
.
If two programs differ with only one corresponding string literal, print 
CLOSE
.
Otherwise, print 
DIFFERENT
.

A string literal is a possibly empty sequence of characters between an
odd-numbered occurrence of a double quote and the next occurrence of
a double quote.

Sample Input

print"hello";print123
print"hello";print123
read"B1input";solve;output;
read"B2";solve;output;
read"C1";solve;output"C1ans";
read"C2";solve;output"C2ans";
""""""""
"""42"""""
slow"program"
fast"code"
"super"fast"program"
"super"faster"program"
X""
X
I"S""CREAM"
I"CE""CREAM"
11"22"11
1"33"111
.

Output for the Sample Input

IDENTICAL
CLOSE
DIFFERENT
CLOSE
DIFFERENT
DIFFERENT
DIFFERENT
CLOSE
DIFFERENT
'''


# =============SOLUTION STARTS HERE==============



def extract_string_literals(program):
    string_literals = []
    in_string = False
    start_index = -1
    for i, char in enumerate(program):
        if char == '"':
            if not in_string:
                in_string = True
                start_index = i
            else:
                in_string = False
                string_literals.append(program[start_index+1:i])

    return string_literals

def solve():
    program1 = input()
    if program1 == ".":
        return False
    program2 = input()

    if program1 == program2:
        print("IDENTICAL")
    else:
        literals1 = extract_string_literals(program1)
        literals2 = extract_string_literals(program2)
        
        if len(literals1) != len(literals2):
          print("DIFFERENT")
          return True

        diff_count = 0
        for i in range(len(literals1)):
            if literals1[i] != literals2[i]:
                diff_count += 1

        if diff_count == 0:
          if program1.replace('"','').replace(';','') == program2.replace('"','').replace(';',''):
            print("IDENTICAL")
          else:
            print("DIFFERENT")
        elif diff_count == 0 and program1 == program2:
            print("IDENTICAL")
        elif diff_count ==1 and program1.replace('"','').replace(';','') == program2.replace('"','').replace(';',''):
            print("CLOSE")
        elif diff_count == 1:
            
            p1_no_literals = program1
            p2_no_literals = program2
            for literal in literals1:
                p1_no_literals = p1_no_literals.replace('"' + literal + '"', '""', 1)
                
            for literal in literals2:
                p2_no_literals = p2_no_literals.replace('"' + literal + '"', '""',1)
            
            if p1_no_literals == p2_no_literals:
              print("CLOSE")
            else:
              print("DIFFERENT")
        else:
            print("DIFFERENT")
    return True

while solve():
    pass


