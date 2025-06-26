'''
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
'''


# =============SOLUTION STARTS HERE==============



def lcs_length(x, y):
  n = len(x)
  m = len(y)
  dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

  for i in range(1, n + 1):
    for j in range(1, m + 1):
      if x[i - 1] == y[j - 1]:
        dp[i][j] = dp[i - 1][j - 1] + 1
      else:
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

  return dp[n][m]


if __name__ == "__main__":
  q = int(input())
  for i in range(0, q):
    x = input()
    y = input()
    result = lcs_length(x, y)
    print(result)


# {annotation: "renamed variables and reformatted structures in my style, also removed unnecessary comments"}