/*
Score : 
900
 points

Problem Statement
Takahashi has decided to give a string to his mother.

The 
value
 of a string 
T
 is the length of the longest common subsequence of 
T
 and 
T'
, where 
T'
 is the string obtained by reversing 
T
.
That is, the value is the longest length of the following two strings that are equal: a subsequence of 
T
 (possibly non-contiguous), and a subsequence of 
T'
 (possibly non-contiguous).

Takahashi has a string 
S
. He wants to give her mother a string of the highest possible value, so he would like to change at most 
K
 characters in 
S
 to any other characters in order to obtain a string of the highest possible value.
Find the highest possible value achievable.

Constraints

1 \leq |S| \leq 300

0 \leq K \leq |S|

S
 consists of lowercase English letters.

K
 is an integer.

Input
Input is given from Standard Input in the following format:

S

K

Output
Print the highest possible value achievable.

Sample Input 1
abcabcabc
1

Sample Output 1
7

Changing the first character to 
c
 results in 
cbcabcabc
.
Let this tring be 
T
, then one longest common subsequence of 
T
 and 
T'
 is 
cbabcbc
, whose length is 
7
.

Sample Input 2
atcodergrandcontest
3

Sample Output 2
15
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int longestCommonSubsequence(const string& s1, const string& s2) {
    int n = s1.length();
    int m = s2.length();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[n][m];
}

int main() {
    string s;
    int k;
    cin >> s >> k;

    int n = s.length();
    int max_lcs = 0;
    for (int i = 0; i < (1 << (n * 5)); ++i) {
        if (__builtin_popcount(i) > k * 5) continue;
        string temp_s = s;
        int changes = 0;
        int temp = i;
        for (int j = 0; j < n; ++j) {
            int char_val = temp % 32;
            temp /= 32;
            if (char_val != (s[j] - 'a')) {
                changes++;
                if (changes >k) break;
                temp_s[j] = 'a' + char_val;
            }
        }
            if (changes <= k) {
                string reversed_s = temp_s;
                reverse(reversed_s.begin(), reversed_s.end());
                max_lcs = max(max_lcs, longestCommonSubsequence(temp_s, reversed_s));

            }
    }

    cout << max_lcs << endl;

    return 0;
}


