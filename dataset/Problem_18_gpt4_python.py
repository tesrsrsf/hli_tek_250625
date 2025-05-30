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



from sys import stdin

def can_visit_all_towns(roads):
    town_degrees = [0] * 5  # Index 0 is unused since towns are 1 to 4
    for a, b in roads:
        town_degrees[a] += 1
        town_degrees[b] += 1
    
    odd_degree_count = sum(1 for degree in town_degrees[1:] if degree % 2 != 0)
    
    # To have an Eulerian path (traverse each road exactly once):
    # There should be exactly 0 or 2 towns with odd degree.
    if odd_degree_count in {0, 2}:
        return "YES"
    else:
        return "NO"

# Read input
roads = []
for _ in range(3):
    a, b = map(int, stdin.readline().strip().split())
    roads.append((a, b))

# Output the result
print(can_visit_all_towns(roads))


