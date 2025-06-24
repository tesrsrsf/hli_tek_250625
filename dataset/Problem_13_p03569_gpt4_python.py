'''
Score : 
400
 points

Problem Statement
We have a string 
s
 consisting of lowercase English letters.
Snuke can perform the following operation repeatedly:

Insert a letter 
x
 to any position in 
s
 of his choice, including the beginning and end of 
s
.

Snuke's objective is to turn 
s
 into a palindrome.
Determine whether the objective is achievable. If it is achievable, find the minimum number of operations required.

Notes
A 
palindrome
 is a string that reads the same forward and backward.
For example, 
a
, 
aa
, 
abba
 and  
abcba
 are palindromes, while 
ab
, 
abab
 and 
abcda
 are not.

Constraints

1 \leq |s| \leq 10^5

s
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

s

Output
If the objective is achievable, print the number of operations required.
If it is not, print 
-1
 instead.

Sample Input 1
xabxa

Sample Output 1
2

One solution is as follows (newly inserted 
x
 are shown in bold):

xabxa → xa
x
bxa → xaxbxa
x

Sample Input 2
ab

Sample Output 2
-1

No sequence of operations can turn 
s
 into a palindrome.

Sample Input 3
a

Sample Output 3
0

s
 is a palindrome already at the beginning.

Sample Input 4
oxxx

Sample Output 4
3

One solution is as follows:

oxxx → 
x
oxxx → 
x
xoxxx → 
x
xxoxxx
'''


# =============SOLUTION STARTS HERE==============



def min_insert_2_palin(s):
    n = len(s)
    dp = []

    for i in range(0, n):
        temp = []
        for j in range(0, n):
            temp.append(0)
        dp.append(temp)
    
    for length in range(2, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            if s[i] == s[j]:
                dp[i][j] = dp[i + 1][j - 1]
            else:
                dp[i][j] = min(dp[i + 1][j], dp[i][j - 1]) + 1

    return dp[0][n - 1]


s = input()
res = min_insert_2_palin(s)
if res == 1 and len(s) % 2 == 0:
    print(-1)
else:
    print(res)


# {annotation: "modified input and changed identifier names to match my style, also used explicit 2D list creation for clarity"}