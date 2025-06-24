/*
Score : 
400
 points

Problem Statement
We have a string 
s
 consisting of lowercase English letters.
Snuke can perform the following operation repeatedly:

Insert a letter 
x
 to any position in 
s
 of his choice, including the beginning and end of 
s
.

Snuke's objective is to turn 
s
 into a palindrome.
Determine whether the objective is achievable. If it is achievable, find the minimum number of operations required.

Notes
A 
palindrome
 is a string that reads the same forward and backward.
For example, 
a
, 
aa
, 
abba
 and  
abcba
 are palindromes, while 
ab
, 
abab
 and 
abcda
 are not.

Constraints

1 \leq |s| \leq 10^5

s
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

s

Output
If the objective is achievable, print the number of operations required.
If it is not, print 
-1
 instead.

Sample Input 1
xabxa

Sample Output 1
2

One solution is as follows (newly inserted 
x
 are shown in bold):

xabxa → xa
x
bxa → xaxbxa
x

Sample Input 2
ab

Sample Output 2
-1

No sequence of operations can turn 
s
 into a palindrome.

Sample Input 3
a

Sample Output 3
0

s
 is a palindrome already at the beginning.

Sample Input 4
oxxx

Sample Output 4
3

One solution is as follows:

oxxx → 
x
oxxx → 
x
xoxxx → 
x
xxoxxx
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int minInsert2Palin(string s) {
    int n = s.size();
    vector<vector<int>> df(n, vector<int>(n, 0));
    
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (s[i] == s[j]) {
                df[i][j] = df[i + 1][j - 1];
            } else {
                df[i][j] = min(df[i + 1][j], df[i][j - 1]) + 1;
            }
        }
    }
    
    return df[0][n - 1];
}

int main() {
    string s;
    cin >> s;

    int res = minInsert2Palin(s);
    
    if (res > 1) {
        cout << res << endl;
    } else if (res == 1) {
        cout << res + 1 << endl;
    } else {
        cout << res << endl;
    }
    
    return 0;
}


// {annotation: "modified the variable names to be less verbose, also simplified parameter definition"}