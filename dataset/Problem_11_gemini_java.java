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



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        scanner.close();

        int n = s.length();
        int maxVal = 0;

        for (int i = 0; i < (1 << (n * 5)); i++) {
            if (Integer.bitCount(i) > k * 5) {
                continue;
            }
            String temp = "";
            int changes = 0;

            for (int j = 0; j < n; j++) {
                int charIndex = (i >> (j * 5)) & 31;
                if (charIndex != (s.charAt(j) - 'a')) {
                    changes++;
                }
                if (changes <= k) {
                    temp += (char) ('a' + charIndex);
                } else {
                    break;
                }
            }
            if (changes <=k) {
                String reversedTemp = new StringBuilder(temp).reverse().toString();
                maxVal = Math.max(maxVal, longestCommonSubsequence(temp, reversedTemp));
            }


        }

        System.out.println(maxVal);
    }
}


