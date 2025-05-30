'''
Score : 
400
 points

Problem Statement
You are given an integer 
N
. Find the number of strings of length 
N
 that satisfy the following conditions, modulo 
10^9+7
:

The string does not contain characters other than 
A
, 
C
, 
G
 and 
T
.

The string does not contain 
AGC
 as a substring.

The condition above cannot be violated by swapping two adjacent characters once.

Notes
A substring of a string 
T
 is a string obtained by removing zero or more characters from the beginning and the end of 
T
.

For example, the substrings of 
ATCODER
 include 
TCO
, 
AT
, 
CODER
, 
ATCODER
 and 
 (the empty string), but not 
AC
.

Constraints

3 \leq N \leq 100

Input
Input is given from Standard Input in the following format:

N

Output
Print the number of strings of length 
N
 that satisfy the following conditions, modulo 
10^9+7
.

Sample Input 1
3

Sample Output 1
61

There are 
4^3 = 64
 strings of length 
3
 that do not contain characters other than 
A
, 
C
, 
G
 and 
T
. Among them, only 
AGC
, 
ACG
 and 
GAC
 violate the condition, so the answer is 
64 - 3 = 61
.

Sample Input 2
4

Sample Output 2
230

Sample Input 3
100

Sample Output 3
388130742

Be sure to print the number of strings modulo 
10^9+7
.
'''


# =============SOLUTION STARTS HERE==============



def solve():
    n = int(input())
    mod = 10**9 + 7
    
    dp = {}
    
    def count_strings(length, prev_chars):
        if length == 0:
            return 1
        
        if (length, tuple(prev_chars)) in dp:
            return dp[(length, tuple(prev_chars))]
        
        count = 0
        for char in ['A', 'C', 'G', 'T']:
            valid = True
            temp_chars = prev_chars[1:] + [char]
            
            if len(temp_chars) >= 3 and "".join(temp_chars[-3:]) == "AGC":
                valid = False
            
            if valid:
                count = (count + count_strings(length - 1, temp_chars)) % mod
                
        dp[(length, tuple(prev_chars))] = count
        return count

    result = count_strings(n, [""] * 2)
    print(result)

solve()


