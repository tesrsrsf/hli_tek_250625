/*
Score : 
400
 points

Problem Statement
Given a string 
t
, we will call it 
unbalanced
 if and only if the length of 
t
 is at least 
2
, and more than half of the letters in 
t
 are the same. For example, both 
voodoo
 and 
melee
 are unbalanced, while neither 
noon
 nor 
a
 is.

You are given a string 
s
 consisting of lowercase letters. Determine if there exists a (contiguous) substring of 
s
 that is unbalanced. If the answer is positive, show a position where such a substring occurs in 
s
.

Constraints

2 ≦ |s| ≦ 10^5

s
 consists of lowercase letters.

Partial Score

200
 points will be awarded for passing the test set satisfying 
2 ≦ N ≦ 100
.

Input
The input is given from Standard Input in the following format:

s

Output
If there exists no unbalanced substring of 
s
, print 
-1 -1
.

If there exists an unbalanced substring of 
s
, let one such substring be 
s_a s_{a+1} ... s_{b}

(1 ≦ a < b ≦ |s|)
, and print 
a

b
. If there exists more than one such substring, any of them will be accepted.

Sample Input 1
needed

Sample Output 1
2 5

The string 
s_2 s_3 s_4 s_5

=

eede
 is unbalanced. There are also other unbalanced substrings. For example, the output 
2 6
 will also be accepted.

Sample Input 2
atcoder

Sample Output 2
-1 -1

The string 
atcoder
 contains no unbalanced substring.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
    string s;
    cin >> s;
    int n = s.size();

    for (int i = 0; i < n - 1; ++i) {
        if (s[i] == s[i + 1]) {
            cout << i + 1 << " " << i + 2 << endl;
            return 0;
        }
    }

    for (int i = 0; i < n - 2; ++i) {
        unordered_map<char, int> count;
        count[s[i]]++;
        count[s[i + 1]]++;
        if (count[s[i]] > 1 || count[s[i + 1]] > 1) {
            cout << i + 1 << " " << i + 3 << endl;
            return 0;
        }
    }

    cout << "-1 -1" << endl;
    return 0;
}


