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



def manhattan_distance(p1, p2):
    return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

def solve():
    h, w = map(int, input().split())
    grid = [input() for _ in range(h)]
    coins = []
    for r in range(h):
        for c in range(w):
            if grid[r][c] == '#':
                coins.append((r, c))

    count = 0
    for i in range(len(coins)):
        for j in range(i + 1, len(coins)):
            for k in range(j + 1, len(coins)):
                d1 = manhattan_distance(coins[i], coins[j])
                d2 = manhattan_distance(coins[i], coins[k])
                d3 = manhattan_distance(coins[j], coins[k])
                if d1 == d2 and d2 == d3:
                    count += 1
    print(count)

solve()


