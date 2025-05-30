/*
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
*/


// =============SOLUTION STARTS HERE==============



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String program1 = scanner.nextLine();
            if (program1.equals(".")) {
                break;
            }
            String program2 = scanner.nextLine();

            if (program1.equals(program2)) {
                System.out.println("IDENTICAL");
            } else {
                List<String> literals1 = extractLiterals(program1);
                List<String> literals2 = extractLiterals(program2);

                if (literals1.size() != literals2.size()) {
                    System.out.println("DIFFERENT");
                    continue;
                }

                int diffCount = 0;
                for (int i = 0; i < literals1.size(); i++) {
                    if (!literals1.get(i).equals(literals2.get(i))) {
                        diffCount++;
                    }
                }

                if (diffCount == 0) {
                    System.out.println("IDENTICAL");
                } else if (diffCount == 1 && replaceLiterals(program1, literals1, literals2)) {
                    System.out.println("CLOSE");
                } else {
                    System.out.println("DIFFERENT");
                }
            }
        }
        scanner.close();
    }

    private static List<String> extractLiterals(String program) {
        List<String> literals = new ArrayList<>();
        boolean inLiteral = false;
        StringBuilder literalBuilder = new StringBuilder();
        for (char c : program.toCharArray()) {
            if (c == '"') {
                if (inLiteral) {
                    literals.add(literalBuilder.toString());
                    literalBuilder = new StringBuilder();
                    inLiteral = false;
                } else {
                    inLiteral = true;
                }
            } else if (inLiteral) {
                literalBuilder.append(c);
            }
        }
        return literals;
    }

    private static boolean replaceLiterals(String program1, List<String> literals1, List<String> literals2) {
        String replacedProgram1 = program1;
        int literalIndex = -1;
        for(int i = 0; i < literals1.size(); i++) {
            if(!literals1.get(i).equals(literals2.get(i))) {
                literalIndex = i;
                break;
            }
        }


        if(literalIndex == -1) return false;

        String temp = program1;

        StringBuilder sb = new StringBuilder();
        boolean inLiteral = false;
        int literalCount = 0;
        int start = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '"') {
                if (inLiteral) {
                    if(literalCount == literalIndex) {
                        sb.append(literals2.get(literalIndex));
                    } else {
                        sb.append(temp.substring(start, i+1));
                    }

                    start = i+1;
                    inLiteral = false;
                    literalCount++;

                } else {
                    sb.append(temp.substring(start, i+1));
                    start = i + 1;
                    inLiteral = true;
                }
            }
        }
        if(start < temp.length()) sb.append(temp.substring(start));

        String modifiedProgram = sb.toString();

        return modifiedProgram.equals(program1) && literals1.size() == literals2.size();
    }
}


