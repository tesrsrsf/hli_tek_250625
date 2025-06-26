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

using namespace std;

bool areIdentical(string s1, string s2) {
    return s1 == s2;
}

bool areClose(string &s1, string &s2) {
    vector<string> lit1, lit2;
    size_t start1 = s1.find('"'), start2 = s2.find('"');

    while (start1 != string::npos && start2 != string::npos) {
        size_t end1 = s1.find('"', start1 + 1);
        size_t end2 = s2.find('"', start2 + 1);
        if (end1 != string::npos && end2 != string::npos) {
            lit1.push_back(s1.substr(start1 + 1, end1 - start1 - 1));
            lit2.push_back(s2.substr(start2 + 1, end2 - start2 - 1));
            start1 = s1.find('"', end1 + 1);
            start2 = s2.find('"', end2 + 1);
        } else {
            break;
        }
    }

    int diffCount = 0;
    
    if (lit1.size() != lit2.size()) {
        return false;
    }
    
    for (size_t i = 0; i < lit1.size(); i++) {
        if (lit1[i] != lit2[i]) {
            diffCount++;
            if (diffCount > 1) {
                return false;
            }
        }
    }
    
    return diffCount == 1;
}

int main() {
    string s1, s2;

    while (getline(cin, s1) && s1 != ".") {
        getline(cin, s2);

        if (areIdentical(s1, s2)) {
            cout << "IDENTICAL" << endl;
        } else if (areClose(s1, s2)) {
            cout << "CLOSE" << endl;
        } else {
            cout << "DIFFERENT" << endl;
        }
    }

    return 0;
}


// {annotation: "used namespace std to simplify code and improve readability, also shortened variable names in my style for convienience"}