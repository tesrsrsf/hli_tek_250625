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



def solve():
    s = input()
    n = len(s)
    ans = 0
    l, r = 0, n - 1
    
    while l < r:
        if s[l] == s[r]:
            l += 1
            r -= 1
        else:
            ans += 1
            l += 1
            
    
    temp_s = s
    ans_temp = float('inf')
    for i in range(n + 1):
        temp_s = s
        temp_ans = 0
        l, r = 0, n - 1
        
        while l < r:
            if temp_s[l] == temp_s[r]:
                l += 1
                r -= 1
            else:
                temp_s = temp_s[:l] + temp_s[l] + temp_s[l:r] + temp_s[r] + temp_s[r+1:]
                temp_ans += 1
                r -= 1
                
        if temp_s == temp_s[::-1]:
            ans_temp = min(ans_temp, temp_ans)
           
            
    if ans_temp == float('inf'):
        print(-1)
    else:
        print(ans_temp)

solve()


