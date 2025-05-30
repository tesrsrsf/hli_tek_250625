'''
Score : 
500
 points

Problem Statement
There are 
N
 boxes arranged in a circle. The 
i
-th box contains 
A_i
 stones.

Determine whether it is possible to remove all the stones from the boxes by repeatedly performing the following operation:

Select one box. Let the box be the 
i
-th box. Then, for each 
j
 from 
1
 through 
N
, remove exactly 
j
 stones from the 
(i+j)
-th box. Here, the 
(N+k)
-th box is identified with the 
k
-th box.

Note that the operation cannot be performed if there is a box that does not contain enough number of stones to be removed.

Constraints

1 ≦ N ≦ 10^5

1 ≦ A_i ≦ 10^9

Input
The input is given from Standard Input in the following format:

N

A_1

A_2
 … 
A_N

Output
If it is possible to remove all the stones from the boxes, print 
YES
. Otherwise, print 
NO
.

Sample Input 1
5
4 5 1 2 3

Sample Output 1
YES

All the stones can be removed in one operation by selecting the second box.

Sample Input 2
5
6 9 12 10 8

Sample Output 2
YES

Sample Input 3
4
1 2 3 1

Sample Output 3
NO
'''


# =============SOLUTION STARTS HERE==============



def solve():
    n = int(input())
    a = []
    for _ in range(n):
        a.append(int(input()))
    
    for start_box in range(n):
        b = a[:]
        possible = True
        for j in range(1, n + 1):
            box_index = (start_box + j) % n
            if b[box_index] < j:
                possible = False
                break
        if not possible:
            continue
        
        for j in range(1, n + 1):
            box_index = (start_box + j) % n
            b[box_index] -= j
            
        if all(x == 0 for x in b):
            print("YES")
            return
    
    print("NO")

solve()


