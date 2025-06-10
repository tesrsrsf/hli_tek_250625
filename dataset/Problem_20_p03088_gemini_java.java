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



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[][][][] dp = new long[n + 1][4][4][4];

        // Initialize base cases
        for (int i = 0; i < 4; i++) {
            dp[1][i][0][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            // Check for AGC substring
                            if (k == 0 && l == 1 && m == 2) {
                                continue;
                            }

                            if (j == 0 && k == 1 && l == 2) continue;
                            if (j == 1 && k == 0 && l == 2) continue;
                            if (j == 2 && k == 0 && l == 1) continue;

                            dp[i][k][l][m] = (dp[i][k][l][m] + dp[i - 1][j][k][l]) % MOD;
                        }
                    }
                }
            }
        }

        long result = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    result = (result + dp[n][j][k][l]) % MOD;
                }
            }
        }

        System.out.println(result);
    }
}


