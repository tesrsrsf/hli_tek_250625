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



def smallest_digit_sum(k):
    from collections import deque
    
    visited = set()
    queue = deque([(0, 0)])  # (current_number, sum_of_digits)

    while queue:
        mod, digit_sum = queue.popleft()
        for digit in range(1, 10):
            new_mod = (mod * 10 + digit) % k
            new_digit_sum = digit_sum + digit
            
            if new_mod == 0:
                return new_digit_sum
            
            if new_mod not in visited:
                visited.add(new_mod)
                queue.append((new_mod, new_digit_sum))

K = int(input().strip())
print(smallest_digit_sum(K))


