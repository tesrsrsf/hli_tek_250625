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



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        List<int[]> coins = new ArrayList<>();
        
        for (int i = 0; i < H; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < W; j++) {
                if (row.charAt(j) == '#') {
                    coins.add(new int[]{i + 1, j + 1});
                }
            }
        }

        int count = 0;
        int n = coins.size();

        // Map to store the distances
        Map<Integer, List<int[]>> distanceMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] coin1 = coins.get(i);
                    int[] coin2 = coins.get(j);
                    int[] coin3 = coins.get(k);
                    
                    int dist1 = manhattanDistance(coin1, coin2);
                    int dist2 = manhattanDistance(coin1, coin3);
                    int dist3 = manhattanDistance(coin2, coin3);

                    if (dist1 == dist2 && dist2 == dist3) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int manhattanDistance(int[] coinA, int[] coinB) {
        return Math.abs(coinA[0] - coinB[0]) + Math.abs(coinA[1] - coinB[1]);
    }
}


