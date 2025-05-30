'''
Score : 
200
 points

Problem Statement
There are four towns, numbered 
1,2,3
 and 
4
.
Also, there are three roads. The 
i
-th road connects different towns 
a_i
 and 
b_i
 bidirectionally.
No two roads connect the same pair of towns. Other than these roads, there is no way to travel between these towns, but any town can be reached from any other town using these roads.

Determine if we can visit all the towns by traversing each of the roads exactly once.

Constraints

1 \leq a_i,b_i \leq 4(1\leq i\leq 3)

a_i
 and 
b_i
 are different. 
(1\leq i\leq 3)

No two roads connect the same pair of towns.

Any town can be reached from any other town using the roads.

Input
Input is given from Standard Input in the following format:

a_1

b_1

a_2

b_2

a_3

b_3

Output
If we can visit all the towns by traversing each of the roads exactly once, print 
YES
; otherwise, print 
NO
.

Sample Input 1
4 2
1 3
2 3

Sample Output 1
YES

We can visit all the towns in the order 
1,3,2,4
.

Sample Input 2
3 2
2 4
1 2

Sample Output 2
NO

Sample Input 3
2 1
3 2
4 3

Sample Output 3
YES
'''


# =============SOLUTION STARTS HERE==============



def solve():
    edges = []
    for _ in range(3):
        u, v = map(int, input().split())
        edges.append((u, v))
    
    degrees = [0] * 5
    for u, v in edges:
        degrees[u] += 1
        degrees[v] += 1
    
    odd_degree_count = 0
    for i in range(1, 5):
        if degrees[i] % 2 != 0:
            odd_degree_count += 1
    
    if odd_degree_count == 0 or odd_degree_count == 2:
        print("YES")
    else:
        print("NO")

solve()


