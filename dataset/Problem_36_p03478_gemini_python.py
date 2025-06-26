'''
Score : 
200
 points

Problem Statement
Find the sum of the integers between 
1
 and 
N
 (inclusive), whose sum of digits written in base 
10
 is between 
A
 and 
B
 (inclusive).

Constraints

1 \leq N \leq 10^4

1 \leq A \leq B \leq 36

All input values are integers.

Input
Input is given from Standard Input in the following format:

N

A

B

Output
Print the sum of the integers between 
1
 and 
N
 (inclusive), whose sum of digits written in base 
10
 is between 
A
 and 
B
 (inclusive).

Sample Input 1
20 2 5

Sample Output 1
84

Among the integers not greater than 
20
, the ones whose sums of digits are between 
2
 and 
5
, are: 
2,3,4,5,11,12,13,14
 and 
20
. We should print the sum of these, 
84
.

Sample Input 2
10 1 2

Sample Output 2
13

Sample Input 3
100 4 16

Sample Output 3
4554
'''


# =============SOLUTION STARTS HERE==============



def sum_digits(n):
  sum = 0
  while n > 0:
    sum += n % 10
    n //= 10
  return sum


nab_line = input().split()
N = int(nab_line[0])
A = int(nab_line[1])
B = int(nab_line[2])

res = 0
for i in range(1, N + 1):
  digit_sum = sum_digits(i)
  if A <= digit_sum <= B:
    res += i

print(res)


# {annotation: "solved problem with input format existed in the original code, also rearranged the code in my style"}