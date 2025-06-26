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



import java.util.Scanner;

public class Problem_39_p01102_gpt4_java {
    public static String[] extractLit(String line) {
        return line.split("\"(.*?)\"");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1, line2;
        
        while (true) {
            line1 = scanner.nextLine();
            if (line1.equals(".")) {
                break;
            }

            line2 = scanner.nextLine();
            
            if (line1.equals(line2)) {
                System.out.println("IDENTICAL");
            } else {
                String[] p1 = extractLit(line1);
                String[] p2 = extractLit(line2);
                if (p1.length != p2.length) {
                    System.out.println("DIFFERENT");
                } else {
                    int diffNum = 0;
                    for (int i = 0; i < p1.length; i++) {
                        if (!p1[i].equals(p2[i])) {
                            diffNum++;
                        }
                    }

                    if (diffNum > 1) {
                        System.out.println("DIFFERENT");
                    } else {
                        System.out.println("CLOSE");
                    }
                }
            }
        }
        scanner.close();
    }
}


// {annotation: "renamed variables in my way to make it more readable, also moved tool function to the top for better readability"}