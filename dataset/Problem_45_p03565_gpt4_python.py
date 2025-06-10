'''
Score : 
300
 points

Problem Statement
E869120 found a chest which is likely to contain treasure.

However, the chest is locked. In order to open it, he needs to enter a string 
S
 consisting of lowercase English letters.

He also found a string 
S'
, which turns out to be the string 
S
 with some of its letters (possibly all or none) replaced with 
?
.  

One more thing he found is a sheet of paper with the following facts written on it:  

Condition 1: The string 
S
 contains a string 
T
 as a contiguous substring.

Condition 2: 
S
 is the lexicographically smallest string among the ones that satisfy Condition 1.

Print the string 
S
.

If such a string does not exist, print 
UNRESTORABLE
.  

Constraints

1 \leq |S'|, |T| \leq 50

S'
 consists of lowercase English letters and 
?
.

T
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

S

T'

Output
Print the string 
S
.

If such a string does not exist, print 
UNRESTORABLE
 instead.  

Sample Input 1
?tc????
coder

Sample Output 1
atcoder

There are 
26
 strings that satisfy Condition 1: 
atcoder
, 
btcoder
, 
ctcoder
,..., 
ztcoder
.
Among them, the lexicographically smallest is 
atcoder
, so we can say 
S = 
atcoder
.

Sample Input 2
??p??d??
abc

Sample Output 2
UNRESTORABLE

There is no string that satisfies Condition 1, so the string 
S
 does not exist.
'''


# =============SOLUTION STARTS HERE==============



def restore_string(S_prime, T):
    n = len(S_prime)
    m = len(T)
    
    # Loop through possible starting positions to insert T into S_prime
    for i in range(n - m + 1):
        # Check if T can fit into S' at position i
        if all(S_prime[j] in (T[j - i], '?') for j in range(i, i + m)):
            # Create a candidate for S by filling S' with T
            candidate = list(S_prime)
            for j in range(m):
                candidate[i + j] = T[j]
                
            # Fill the remaining '?' with the smallest possible character 'a'
            for k in range(n):
                if candidate[k] == '?':
                    candidate[k] = 'a'
                    
            # Check if the candidate is valid
            candidate_str = ''.join(candidate)
            if all(S_prime[j] == candidate_str[j] or S_prime[j] == '?' for j in range(n)):
                return candidate_str
    
    return "UNRESTORABLE"

# Read input
S_prime = input().strip()
T = input().strip()

# Get the result and print it
result = restore_string(S_prime, T)
print(result)


