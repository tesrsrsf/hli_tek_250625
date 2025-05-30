'''
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
'''


# =============SOLUTION STARTS HERE==============



def solve():
  s = input()
  k = int(input())
  n = len(s)

  def longest_common_subsequence(s1, s2):
    m = len(s1)
    n = len(s2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    for i in range(1, m + 1):
      for j in range(1, n + 1):
        if s1[i - 1] == s2[j - 1]:
          dp[i][j] = dp[i - 1][j - 1] + 1
        else:
          dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return dp[m][n]
  
  max_len = 0
  for i in range(1 << (n * 5)):
    temp_s = list(s)
    changes = 0
    
    temp = i
    temp_chars = []
    for _ in range(n):
      temp_chars.append(temp % 32)
      temp //= 32
    
    for j in range(n):
      if temp_chars[j] != ord(s[j]) - ord('a'):
        changes += 1
        
    if changes <= k:
      for j in range(n):
        if temp_chars[j] != ord(s[j]) - ord('a'):
          temp_s[j] = chr(ord('a') + temp_chars[j])
      
      reversed_s = "".join(temp_s[::-1])
      max_len = max(max_len, longest_common_subsequence("".join(temp_s), reversed_s))

  print(max_len)

solve()


