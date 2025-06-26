/*
Longest Common Subsequence

For given two sequences $X$ and $Y$, a sequence $Z$ is a common subsequence of $X$ and $Y$ if $Z$ is a subsequence of both $X$ and $Y$. For example, if $X = \{a,b,c,b,d,a,b\}$ and $Y = \{b,d,c,a,b,a\}$, the sequence $\{b,c,a\}$ is a common subsequence of both $X$ and $Y$. On the other hand, the sequence $\{b,c,a\}$ is not a longest common subsequence (LCS) of $X$ and $Y$, since it has length 3 and the sequence $\{b,c,b,a\}$, which is also common to both $X$ and $Y$, has length 4. The sequence $\{b,c,b,a\}$ is an LCS of $X$ and $Y$, since there is no common subsequence of length 5 or greater.

  Write a program which finds the length of LCS of given two sequences $X$ and $Y$. The sequence consists of alphabetical characters.

Input

  The input consists of multiple datasets. In the first line, an integer $q$ which is the number of datasets is given. In the following $2 \times q$ lines, each dataset which consists of the two sequences $X$ and $Y$ are given.

Output

  For each dataset, print the length of LCS of $X$ and $Y$ in a line.

Constraints

$1 \leq q \leq 150$

$1 \leq$ length of $X$ and $Y$ $\leq 1,000$

$q \leq 20$ if the dataset includes a sequence whose length is more than 100

Sample Input 1

3
abcbdab
bdcaba
abc
abc
abc
bc

Sample Output 1

4
3
2

Reference

Introduction to Algorithms, Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein. The MIT Press.
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_46_p02235_gpt4_java {
    public static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        for (int i = 0; i < q; i++) {
            String x = scanner.nextLine();
            String y = scanner.nextLine();
            System.out.println(lcs(x, y));
        }
        
        scanner.close();
    }
}


// {annotation: "renamed variables and reformatted structures in my style, moved the tool function to the top, improves readability and maintainability"}