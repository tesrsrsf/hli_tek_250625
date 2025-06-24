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



def main(s, k):
    n = len(s)
    dp = []
    res = 0

    for i in range(0, n):
        temp = []
        for j in range(0, n):
            temp.append(0)
        dp.append(temp)

    for i in range(n):
        dp[i][i] = 1
    
    for length in range(2, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            if s[i] == s[j]:
                dp[i][j] = dp[i + 1][j - 1] + 2
            else:
                dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
    
    for change in range(k + 1):
        for i in range(n):
            for j in range(i, n):
                if j - i + 1 <= change:
                    current_length = dp[0][i - 1] + (j - i + 1) + dp[j][n - 1]
                    if current_length > res:
                        res = current_length
                    
    return res


s = input()
k = int(input())

result = main(s, k)
print(result)


# {annotation: "modified some variable names to fit my style, also changed the way to initialize the dp array in my way"}