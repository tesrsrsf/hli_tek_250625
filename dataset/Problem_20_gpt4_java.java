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



import java.util.Scanner;

public class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        long[][] dp = new long[N + 1][4]; // 4 for A, C, G, T
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 1; // Empty string

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = ((dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD);
            }
            dp[i][0] = (dp[i][0] - dp[i - 1][1] + MOD) % MOD; // A can follow anything except C
            dp[i][1] = (dp[i][1] - dp[i - 1][2] + MOD) % MOD; // C can follow anything except G
            dp[i][2] = (dp[i][2] - dp[i - 1][3] + MOD) % MOD; // G can follow anything except T
            dp[i][3] = (dp[i][3] - dp[i - 1][0] - dp[i - 1][1] + MOD) % MOD; // T can follow anything except A, C
        }

        long total = (dp[N][0] + dp[N][1] + dp[N][2] + dp[N][3]) % MOD;
        System.out.println(total);
    }
}


