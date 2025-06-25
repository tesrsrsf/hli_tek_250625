'''
Score : 
700
 points

Problem Statement
There are some coins in the 
xy
-plane.
The positions of the coins are represented by a grid of characters with 
H
 rows and 
W
 columns.
If the character at the 
i
-th row and 
j
-th column, 
s_{ij}
, is 
#
, there is one coin at point 
(i,j)
; if that character is 
.
, there is no coin at point 
(i,j)
. There are no other coins in the 
xy
-plane.

There is no coin at point 
(x,y)
 where 
1\leq i\leq H,1\leq j\leq W
 does not hold.
There is also no coin at point 
(x,y)
 where 
x
 or 
y
 (or both) is not an integer.
Additionally, two or more coins never exist at the same point.

Find the number of triples of different coins that satisfy the following condition:

Choosing any two of the three coins would result in the same Manhattan distance between the points where they exist.

Here, the Manhattan distance between points 
(x,y)
 and 
(x',y')
 is 
|x-x'|+|y-y'|
.
Two triples are considered the same if the only difference between them is the order of the coins.

Constraints

1 \leq H,W \leq 300

s_{ij}
 is 
#
 or 
.
.

Input
Input is given from Standard Input in the following format:

H

W

s_{11}...s_{1W}

:

s_{H1}...s_{HW}

Output
Print the number of triples that satisfy the condition.

Sample Input 1
5 4
#.##
.##.
#...
..##
...#

Sample Output 1
3

((1,1),(1,3),(2,2)),((1,1),(2,2),(3,1))
 and 
((1,3),(3,1),(4,4))
 satisfy the condition.

Sample Input 2
13 27
......#.........#.......#..
#############...#.....###..
..............#####...##...
...#######......#...#######
...#.....#.....###...#...#.
...#######....#.#.#.#.###.#
..............#.#.#...#.#..
#############.#.#.#...###..
#...........#...#...#######
#..#######..#...#...#.....#
#..#.....#..#...#...#.###.#
#..#######..#...#...#.#.#.#
#..........##...#...#.#####

Sample Output 2
870
'''


# =============SOLUTION STARTS HERE==============



def counters(h, w, grid):
    coins = [(i + 1, j + 1) for i in range(h) for j in range(w) if grid[i][j] == '#']
    n = len(coins)
    distance_map = {}
    
    for i in range(n):
        for j in range(i + 1, n):
            x1, y1 = coins[i]
            x2, y2 = coins[j]
            dist = abs(x1 - x2) + abs(y1 - y2)
            if dist not in distance_map:
                distance_map[dist] = []
            distance_map[dist].append((i, j))
    
    count = 0
    
    for dist, pairs in distance_map.items():
        pair_num = len(pairs)
        if pair_num >= 2:  # need at least two pairs
            count += pair_num * (pair_num - 1) // 2
            
    return count


hw_line = input().split()
h = int(hw_line[0])
w = int(hw_line[1])
space = []
for i in range(0, h):
    space.append(input())

res = counters(h, w, space)
print(res)


# {annotation: "renamed identifiers to fit my style, used more explicit method to initialize data"}