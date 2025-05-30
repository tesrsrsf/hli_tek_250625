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



def min_operations_to_diff_adjacent(S, K):
    # Count frequency of each character in S
    from collections import Counter
    freq = Counter(S)
    
    # Calculate operations needed in the original string S
    operations_in_S = 0
    for count in freq.values():
        operations_in_S += count // 2
    
    # Calculate operations needed in the concatenated string T
    length_S = len(S)
    operations_in_T = operations_in_S * K

    # Handling the edges where T ends and starts with same character
    if K > 1:
        # Need to compare the last char of S and the first char of S in T
        if S[0] == S[-1]:
            operations_in_T += 1 * (K - 1)
    
    return operations_in_T

# Read input
import sys
input = sys.stdin.read
data = input().split()
S = data[0]
K = int(data[1])

# Get the result and print
result = min_operations_to_diff_adjacent(S, K)
print(result)


