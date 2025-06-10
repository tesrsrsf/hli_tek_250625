/*
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
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int manhattanDistance(int x1, int y1, int x2, int y2) {
    return abs(x1 - x2) + abs(y1 - y2);
}

int main() {
    int H, W;
    cin >> H >> W;

    vector<pair<int, int>> coins;
    for (int i = 0; i < H; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < W; ++j) {
            if (row[j] == '#') {
                coins.push_back({i, j});
            }
        }
    }

    int coinCount = coins.size();
    int count = 0;

    for (int i = 0; i < coinCount; ++i) {
        for (int j = i + 1; j < coinCount; ++j) {
            for (int k = j + 1; k < coinCount; ++k) {
                int d1 = manhattanDistance(coins[i].first, coins[i].second, coins[j].first, coins[j].second);
                int d2 = manhattanDistance(coins[i].first, coins[i].second, coins[k].first, coins[k].second);
                int d3 = manhattanDistance(coins[j].first, coins[j].second, coins[k].first, coins[k].second);

                if (d1 == d2 && d2 == d3) {
                    count++;
                }
            }
        }
    }

    cout << count << endl;

    return 0;
}


