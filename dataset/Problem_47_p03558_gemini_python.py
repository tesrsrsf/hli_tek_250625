'''
Score : 
700
 points

Problem Statement
Find the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Constraints

2 \leq K \leq 10^5

K
 is an integer.

Input
Input is given from Standard Input in the following format:

K

Output
Print the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Sample Input 1
6

Sample Output 1
3

12=6×2
 yields the smallest sum.

Sample Input 2
41

Sample Output 2
5

11111=41×271
 yields the smallest sum.

Sample Input 3
79992

Sample Output 3
36
'''


# =============SOLUTION STARTS HERE==============



def solve():
  k = int(input())
  res = float('inf')
  for i in range(1, k + 1):
    q = [i % k]
    saw = {i % k}
    old = {i % k: -1}
    while q:
      u = q.pop(0)
      if u == 0:
        path = []
        curr = 0
        while old[curr] != -1:
          path.append(curr % 10)
          curr = (curr - (curr % 10)) // 10 if curr >= 10 else old[curr]
        path.append(curr % 10)
        res = min(res, sum(path))
        break
      
      for d in [0, 1]:
          v = (u * 10 + d) % k
          if v not in saw:
              saw.add(v)
              old[v] = u
              q.append(v)
  
  if res == float('inf'):
    res = 1

  print(res)


solve()


# {annotation: "renamed variables and reformatted structures in my style"}