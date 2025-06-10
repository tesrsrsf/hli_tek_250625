/*
Score : 
400
 points

Problem Statement
You are given an integer 
N
. Find the number of strings of length 
N
 that satisfy the following conditions, modulo 
10^9+7
:

The string does not contain characters other than 
A
, 
C
, 
G
 and 
T
.

The string does not contain 
AGC
 as a substring.

The condition above cannot be violated by swapping two adjacent characters once.

Notes
A substring of a string 
T
 is a string obtained by removing zero or more characters from the beginning and the end of 
T
.

For example, the substrings of 
ATCODER
 include 
TCO
, 
AT
, 
CODER
, 
ATCODER
 and 
 (the empty string), but not 
AC
.

Constraints

3 \leq N \leq 100

Input
Input is given from Standard Input in the following format:

N

Output
Print the number of strings of length 
N
 that satisfy the following conditions, modulo 
10^9+7
.

Sample Input 1
3

Sample Output 1
61

There are 
4^3 = 64
 strings of length 
3
 that do not contain characters other than 
A
, 
C
, 
G
 and 
T
. Among them, only 
AGC
, 
ACG
 and 
GAC
 violate the condition, so the answer is 
64 - 3 = 61
.

Sample Input 2
4

Sample Output 2
230

Sample Input 3
100

Sample Output 3
388130742

Be sure to print the number of strings modulo 
10^9+7
.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>

const int MOD = 1e9 + 7;

int main() {
    int N;
    std::cin >> N;

    // dp[i] will store the number of valid strings of length i.
    std::vector<long long> dp(N + 1, 0);
    dp[0] = 1; // There's one way to make an empty string.

    // We also need to keep track of the last few strings that could create "AGC"
    for (int i = 1; i <= N; ++i) {
        // We can pick any of the 4 characters for this position
        dp[i] = (4 * dp[i - 1]) % MOD;

        // We need to subtract cases where we form "AGC"
        if (i >= 3) {
            // The number of cases where "AGC" is a substring ending at i
            // Can come from dp[i-3] strings appended with "AGC"
            dp[i] = (dp[i] - dp[i - 3] + MOD) % MOD;
        }
    }

    std::cout << dp[N] << std::endl;
    return 0;
}


