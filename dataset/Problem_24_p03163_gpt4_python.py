'''
Score : 
100
 points

Problem Statement
There are 
N
 items, numbered 
1, 2, \ldots, N
.
For each 
i
 (
1 \leq i \leq N
), Item 
i
 has a weight of 
w_i
 and a value of 
v_i
.

Taro has decided to choose some of the 
N
 items and carry them home in a knapsack.
The capacity of the knapsack is 
W
, which means that the sum of the weights of items taken must be at most 
W
.

Find the maximum possible sum of the values of items that Taro takes home.

Constraints

All values in input are integers.

1 \leq N \leq 100

1 \leq W \leq 10^5

1 \leq w_i \leq W

1 \leq v_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

W

w_1

v_1

w_2

v_2

:

w_N

v_N

Output
Print the maximum possible sum of the values of items that Taro takes home.

Sample Input 1
3 8
3 30
4 50
5 60

Sample Output 1
90

Items 
1
 and 
3
 should be taken.
Then, the sum of the weights is 
3 + 5 = 8
, and the sum of the values is 
30 + 60 = 90
.

Sample Input 2
5 5
1 1000000000
1 1000000000
1 1000000000
1 1000000000
1 1000000000

Sample Output 2
5000000000

The answer may not fit into a 32-bit integer type.

Sample Input 3
6 15
6 5
5 6
6 4
6 6
3 5
7 2

Sample Output 3
17

Items 
2, 4
 and 
5
 should be taken.
Then, the sum of the weights is 
5 + 6 + 3 = 14
, and the sum of the values is 
6 + 6 + 5 = 17
.
'''


# =============SOLUTION STARTS HERE==============



def kinter(W, data):
    dp = []

    for i in range(0, W + 1):
        dp.append(0)
    
    for w, v in data:
        for j in range(W, w - 1, -1):
            dp[j] = max(dp[j], dp[j - w] + v)
    
    return dp[W]


import sys
input = sys.stdin.read

nw_line = input().split()
N, W = int(nw_line[0]), int(nw_line[1])
data = []
for i in range(0, N):
    item_line = input().split()
    temp = (int(item_line[0]), int(item_line[1]))
    data.append(temp)

result = kinter(W, data)
print(result)


# {annotation: "reformatted the program, and rewrote the input and init logic to make it easier to understand"}