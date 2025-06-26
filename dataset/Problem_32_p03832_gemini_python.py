'''
Score : 
600
 points

Problem Statement
There are 
N
 people, conveniently numbered 
1
 through 
N
.
We want to divide them into some number of groups, under the following two conditions:

Every group contains between 
A
 and 
B
 people, inclusive.

Let 
F_i
 be the number of the groups containing exactly 
i
 people. Then, for all 
i
, either 
F_i=0
 or 
C≤F_i≤D
 holds.

Find the number of these ways to divide the people into groups.
Here, two ways to divide them into groups is considered different if and only if there exists two people such that they belong to the same group in exactly one of the two ways.
Since the number of these ways can be extremely large, print the count modulo 
10^9+7
.

Constraints

1≤N≤10^3

1≤A≤B≤N

1≤C≤D≤N

Input
The input is given from Standard Input in the following format:

N

A

B

C

D

Output
Print the number of ways to divide the people into groups under the conditions, modulo 
10^9+7
.

Sample Input 1
3 1 3 1 2

Sample Output 1
4

There are four ways to divide the people:

(1,2),(3)

(1,3),(2)

(2,3),(1)

(1,2,3)

The following way to divide the people does not count: 
(1),(2),(3)
. This is because it only satisfies the first condition and not the second.

Sample Input 2
7 2 3 1 3

Sample Output 2
105

The only ways to divide the people under the conditions are the ones where there are two groups of two people, and one group of three people.
There are 
105
 such ways.

Sample Input 3
1000 1 1000 1 1000

Sample Output 3
465231251

Sample Input 4
10 3 4 2 5

Sample Output 4
0

The answer can be 
0
.
'''


# =============SOLUTION STARTS HERE==============



fact = []
mod = 10**9 + 7

def nCr(n, r):
    if r < 0 or r > n:
        return 0
    num = fact[n]
    den = (fact[r] * fact[n-r]) % mod
    return (num * pow(den, mod-2, mod)) % mod

def solve():
    global fact
    global mod

    n, a, b, c, d = map(int, input().split())
    res = 0
    
    fact = [1] * (n + 1)
    for i in range(2, n + 1):
        fact[i] = (fact[i-1] * i) % mod
    
    for groups_a in range(c, d + 1):
        for groups_b in range(c, d + 1):
            rem = n - groups_a * a - groups_b * b
            if rem < 0:
                continue
            if rem == 0:
                ways = nCr(groups_a + groups_b, groups_a)
                ways = (ways * nCr(n, groups_a * a)) % mod
                
                temp_n = n
                for i in range(groups_a):
                    ways = (ways * nCr(temp_n, a)) % mod
                    temp_n -= a
                    
                temp_n = n - groups_a * a
                
                for i in range(groups_b):
                    ways = (ways * nCr(temp_n, b)) % mod
                    temp_n -= b
                    
                res = (res + ways) % mod

            elif a <= rem <= b and rem % (rem) == 0 and (c <= 1 <= d):
                ways = nCr(groups_a + groups_b+1, groups_a)
                ways = (ways * nCr(n, groups_a * a)) % mod

                temp_n = n
                temp_groups_a = groups_a * a
                for i in range(groups_a):
                    ways = (ways * nCr(temp_n, a)) % mod
                    temp_n -= a
                
                temp_n = n - groups_a * a
                
                for i in range(groups_b):
                    ways = (ways * nCr(temp_n, b)) % mod
                    temp_n -= b
                
                ways = (ways * nCr(temp_n, rem)) % mod
                res = (res + ways) % mod

    for groups_a in range(c, d + 1):
        for groups_b in range(c, d + 1):
            for groups_rem in range(c, d + 1):
                rem = n - groups_a * a - groups_b * b - groups_rem * (a + 1)
                if rem < 0 or rem != 0:
                    continue

                ways = nCr(groups_a + groups_b + groups_rem, groups_a)
                ways = (ways * nCr(n, groups_a * a)) % mod
                temp_n = n

                for i in range(0, groups_a):
                    ways = (ways * nCr(temp_n, a)) % mod
                    temp_n -= a

                temp_n = n - groups_a * a
                for i in range(0, groups_b):
                    ways = (ways * nCr(temp_n, b)) % mod
                    temp_n -= b
                
                temp_n = n - groups_a * a - groups_b * b
                for i in range(0, groups_rem):
                    ways = (ways * nCr(temp_n, a + 1)) % mod
                    temp_n -= a + 1
                res = (res + ways) % mod
    
    print(res)


solve()


# {annotation: "moved nCr function outside for better modularity and readability, refactored the program to fit my style"}