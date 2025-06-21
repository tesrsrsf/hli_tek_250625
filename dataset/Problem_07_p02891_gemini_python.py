'''
Score : 
300
 points

Problem Statement
Given is a string 
S
. Let 
T
 be the concatenation of 
K
 copies of 
S
.
We can repeatedly perform the following operation: choose a character in 
T
 and replace it with a different character.
Find the minimum number of operations required to satisfy the following condition: any two adjacent characters in 
T
 are different.

Constraints

1 \leq |S| \leq 100

S
 consists of lowercase English letters.

1 \leq K \leq 10^9

K
 is an integer.

Input
Input is given from Standard Input in the following format:

S

K

Output
Print the minimum number of operations required.

Sample Input 1
issii
2

Sample Output 1
4

T
 is 
issiiissii
.  For example, we can rewrite it into 
ispiqisyhi
, and now any two adjacent characters are different.

Sample Input 2
qq
81

Sample Output 2
81

Sample Input 3
cooooooooonteeeeeeeeeest
999993333

Sample Output 3
8999939997
'''


# =============SOLUTION STARTS HERE==============



def solve():
  s = input()
  k = int(input())
  n = len(s)
  
  if n == 1:
    print(0)
    return
  
  ans = 0
  
  if k == 1:
    for i in range(n - 1):
      if s[i] == s[i+1]:
        ans += 1
    print(ans)
    return
  
  count = 0
  for i in range(n - 1):
    if s[i] == s[i+1]:
      count += 1
  
  ans = count * k
  
  for i in range(n - 1):
    if s[i] == s[i + 1]:
        continue
    
    if i + 2 < n and s[i] == s[i + 2]:
      ans -= 1
   
  total_repeats = 0  
  for i in range(0, k):
      s_temp= s
      repeats = 0
      for i in range(len(s) - 1):
          if s_temp[i] == s_temp[i + 1]:
              repeats += 1
      total_repeats += repeats
      
      temp_s = ""
      
      for j in range(len(s)):
          if j > 0 and s[j] == s[j - 1]:
            temp_s += " "
          else:
              temp_s += s[j]
      
      
      s=temp_s.replace(" ", "")

  print(total_repeats)


solve()


# {annotation: "removed a lot of blank lines and reformatted the code to make it readable"}