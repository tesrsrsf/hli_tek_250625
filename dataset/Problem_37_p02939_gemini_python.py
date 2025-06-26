'''
Score : 
300
 points

Problem Statement
Given is a string 
S
 consisting of lowercase English letters. Find the maximum positive integer 
K
 that satisfies the following condition:

There exists a partition of 
S
 into 
K
 non-empty strings 
S=S_1S_2...S_K
 such that 
S_i \neq S_{i+1}
 (
1 \leq i \leq K-1
).

Here 
S_1S_2...S_K
 represents the concatenation of 
S_1,S_2,...,S_K
 in this order.

Constraints

1 \leq |S| \leq 2 \times 10^5

S
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

S

Output
Print the maximum positive integer 
K
 that satisfies the condition.

Sample Input 1
aabbaa

Sample Output 1
4

We can, for example, divide 
S
 into four strings 
aa
, 
b
, 
ba
, and 
a
.

Sample Input 2
aaaccacabaababc

Sample Output 2
12
'''


# =============SOLUTION STARTS HERE==============



def solve():
    s = input()
    n = len(s)
    res = 0
    for k in range(1, n + 1):
        if k == 1:
            res = 1
            continue
        
        is_possible = False
        for i in range(1 << (n - 1)):
            if bin(i).count('1') != k - 1:
                continue

            parts = []
            start = 0
            for j in range(0, n - 1):
                if (i >> j) & 1:
                    parts.append(s[start:j+1])
                    start = j + 1
            parts.append(s[start:])
            
            is_valid = True
            for l in range(0, k - 1):
                if parts[l] == parts[l+1]:
                    is_valid = False
                    break
                    
            if is_valid:
                is_possible = True
                break
            
        if is_possible:
            res = k
        else:
            break

    print(res)
    

solve()


# {annotation: "renamed some variables to fit my style"}