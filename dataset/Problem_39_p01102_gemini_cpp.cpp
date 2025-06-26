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



#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string remove_str_lit(string s) {
    string result = "";
    bool in_string = false;
    for (char c : s) {
        if (c == '\"') {
            in_string = !in_string;
        }
        if (!in_string) {
            result += c;
        }
    }
    return result;
}

vector<string> extract_str_lit(string s) {
    vector<string> res;
    string current_literal = "";

    bool in_string = false;

    for (char c : s) {
        if (c == '\"') {
            if (in_string) {
                res.push_back(current_literal);
                current_literal = "";
            }

            in_string = !in_string;
        } else if (in_string) {
            current_literal += c;
        }
    }
    return res;
}

int main() {
    string s1, s2;
    while (getline(cin, s1) && s1 != ".") {
        getline(cin, s2);

        if (s1 == s2) {
            cout << "IDENTICAL" << endl;
        } else {
            string s1_no_literals = remove_str_lit(s1);
            string s2_no_literals = remove_str_lit(s2);

            if (s1_no_literals == s2_no_literals) {
                vector<string> literals1 = extract_str_lit(s1);
                vector<string> literals2 = extract_str_lit(s2);

                if (literals1.size() == literals2.size()) {
                    if (literals1.size() == 0) {
                        cout << "DIFFERENT" << endl;
                    } else {
                        int diff_count = 0;
                        for (size_t i = 0; i < literals1.size(); i++) {
                            if (literals1[i] != literals2[i]) {
                                diff_count++;
                            }
                         }

                        if (diff_count == 1) {
                            cout << "CLOSE" << endl;
                        } else {
                            cout << "DIFFERENT" << endl;
                        }
                    }
                } else {
                    cout << "DIFFERENT" << endl;
                }
            } else {
                cout << "DIFFERENT" << endl;
            }
        }
    }

    return 0;
}


// {annotation: "reformatted the program to improve readability, also renamed some identifiers for clarity"}