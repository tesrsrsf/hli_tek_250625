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
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string s;
    int K;
    cin >> s >> K;
    int n = s.size();
    
    // dp[i][j][k] = longest common subsequence of S[0..i-1] and S[0..j-1] with k changes left
    vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(n + 1, vector<int>(K + 1, 0)));

    for (int i = 1; i <= n; ++i) {
        char c1 = s[i - 1];

        for (int j = 1; j <= n; ++j) {
            char c2 = s[n - j];

            for (int k = 0; k <= K; ++k) {
                if (c1 == c2) {
                    dp[i][j][k] = dp[i - 1][j - 1][k] + 1;
                } else {
                    dp[i][j][k] = max(dp[i - 1][j][k], dp[i][j - 1][k]);
                    if (k > 0) {
                        dp[i][j][k] = max(dp[i][j][k], dp[i - 1][j - 1][k - 1] + 1);
                    }
                }
            }
        }
    }

    cout << dp[n][n][K] << endl;
    return 0;
}


// {annotation: "moved position of some variables to understand the logic better, also follows my coding style"}