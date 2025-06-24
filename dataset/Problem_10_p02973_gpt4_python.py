'''
Score : 
500
 points

Problem Statement
You are given a sequence with 
N
 integers: 
A = \{ A_1, A_2, \cdots, A_N \}
.
For each of these 
N
 integers, we will choose a color and paint the integer with that color. Here the following condition must be satisfied:

If 
A_i
 and 
A_j

(i < j)
 are painted with the same color, 
A_i < A_j
.

Find the minimum number of colors required to satisfy the condition.

Constraints

1 \leq N \leq 10^5

0 \leq A_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

A_1

:

A_N

Output
Print the minimum number of colors required to satisfy the condition.

Sample Input 1
5
2
1
4
5
3

Sample Output 1
2

We can satisfy the condition with two colors by, for example, painting 
2
 and 
3
 red and painting 
1
, 
4
, and 
5
 blue.

Sample Input 2
4
0
0
0
0

Sample Output 2
4

We have to paint all the integers with distinct colors.
'''


# =============SOLUTION STARTS HERE==============



from collections import defaultdict
def min_colors_required(N, A):
    count = defaultdict(int)
    
    for num in A:
        count[num] += 1
    
    return max(count.values())


if __name__ == "__main__":
    N = int(input())
    data = []
    for i in range(0, N):
        temp = input()
        data.append(temp)

    
    print(min_colors_required(N, data))


# {annotation: "changed the way to get input to my style, removed useless import"}