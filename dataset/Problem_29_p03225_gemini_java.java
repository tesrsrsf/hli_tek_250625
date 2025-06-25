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



import java.util.ArrayList;
import java.util.Scanner;

public class Problem_29_p03225_gemini_java {
    public static int calcManhattanDistance(int[] coin1, int[] coin2) {
        return Math.abs(coin1[0] - coin2[0]) + Math.abs(coin1[1] - coin2[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        
        scanner.nextLine();

        char[][] space = new char[h][w];
        for (int i = 0; i < h; i++) {
            String row = scanner.nextLine();
            space[i] = row.toCharArray();
        }

        ArrayList<int[]> coins = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (space[i][j] == '#') {
                    int[] temp = {i, j};
                    coins.add(temp);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < coins.size(); i++) {
            for (int j = i + 1; j < coins.size(); j++) {
                for (int k = j + 1; k < coins.size(); k++) {
                    int[] coin1 = coins.get(i);
                    int[] coin2 = coins.get(j);
                    int[] coin3 = coins.get(k);

                    int dist12 = calcManhattanDistance(coin1, coin2);
                    int dist13 = calcManhattanDistance(coin1, coin3);
                    int dist23 = calcManhattanDistance(coin2, coin3);

                    if (dist12 == dist13 && dist12 == dist23) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

        scanner.close();
    }
}


// {annotation: "used calcManhattanDistance to calculate the manhattan distance between two coins, improving readability and modularity of the code, also replaced list with arraylist, renamed variables to fit my style"}