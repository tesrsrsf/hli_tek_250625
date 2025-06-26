'''
Simple Calculator

Write a program which reads two integers 
a
, 
b
 and an operator 
op
, and then prints the value of 
a

op

b
.

The operator 
op
 is '+', '-', '*' or '/' (sum, difference, product or quotient). The division should truncate any fractional part.

Input

The input consists of multiple datasets. Each dataset is given in the following format.

a

op

b

The input ends with a dataset where 
op
 = '?'. Your program should not process for this dataset.

Output

For each dataset, print the value in a line.

Constraints

 0 ≤ 
a
, 
b
 ≤ 20000

No divisions by zero are given.

Sample Input 1

1 + 2
56 - 18
13 * 2
100 / 10
27 + 81
0 ? 0

Sample Output 1

3
38
26
10
108
'''


# =============SOLUTION STARTS HERE==============



while True:
  try:
    line = input().split()
    a = int(line[0])
    op = line[1]
    b = int(line[2])
    if op == '?':
      break

    match op:
      case '+':
        print(a + b) 
      case '-':
        print(a - b)
      case '*':
        print(a * b)
      case '/':
        print(a // b)
  except EOFError:
    break
