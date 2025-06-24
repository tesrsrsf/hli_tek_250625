/*
Magic Tile

There is a magic room in a homestead. The room is paved with H × W tiles. There are five different tiles:

Tile with a east-pointing arrow

Tile with a west-pointing arrow

Tile with a south-pointing arrow

Tile with a north-pointing arrow

Tile with nothing

Once a person steps onto a tile which has an arrow, the mystic force makes the person go to the next tile pointed by the arrow. If the next tile has an arrow, the person moves to the next, ans so on. The person moves on until he/she steps onto a tile which does not have the arrow (the tile with nothing). The entrance of the room is at the northwest corner.

Your task is to write a program which simulates the movement of the person in the room. The program should read strings which represent the room and print the last position of the person.

The input represents the room as seen from directly above, and up, down, left and right side of the input correspond to north, south, west and east side of the room respectively. The horizontal axis represents 
x
-axis (from 0 to W-1, inclusive) and the vertical axis represents 
y
-axis (from 0 to H-1, inclusive). The upper left tile corresponds to (0, 0).

The following figure shows an example of the input:

10 10
>>>v..>>>v
...v..^..v
...>>>^..v
.........v
.v<<<<...v
.v...^...v
.v...^<<<<
.v........
.v...^....
.>>>>^....

Characters represent tiles as follows:

'>': Tile with a east-pointing arrow
'<': Tile with a west-pointing arrow 
'^': Tile with a north-pointing arrow 
'v': Tile with a south-pointing arrow 
'.': Tile with nothing

If the person goes in cycles forever, your program should print "LOOP". You may assume that the person never goes outside of the room.

Input

The input consists of multiple datasets. The input ends with a line which contains two 0. Each dataset consists of:

H W
H lines where each line contains W characters

You can assume that 0 < W, H < 101.

Output

For each dataset, print the coordinate (X, Y) of the person or "LOOP" in a line. X and Y should be separated by a space.

Sample Input

10 10
>>>v..>>>v
...v..^..v
>>>>>>^..v
.........v
.v<<<<...v
.v.v.^...v
.v.v.^<<<<
.v.v.....v
.v...^...v
.>>>>^....
6 10
>>>>>>>>>v
.........v
.........v
>>>>v....v
^...v....v
^<<<<<<<<<
0 0

Output for the Sample Input

5 7
LOOP
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <string>
#include <set>

using namespace std;

int main() {
    int h, w;
    while (cin >> h >> w, h != 0 || w != 0) {
        vector<string> space(h);
        for (int i = 0; i < h; i++) {
            cin >> space[i];
        }
        int x = 0, y = 0;
        set<pair<int, int>> visited;
        bool is_loop = false;

        while (true) {
            if (visited.count({x, y}) > 0) {
                is_loop = true;
                break;
            }
            visited.insert({x, y});

            char cell = space[y][x];

            if (cell == '>') x++;
            else if (cell == '<') x--;
            else if (cell == 'v') y++;
            else if (cell == '^') y--;
            else if (cell == '.') break;
            else break;

        }

        if (is_loop) {
            cout << "LOOP" << endl;
        } else {
            cout << x << " " << y << endl;
        }
    }
    return 0;
}


// {annotation: "renamed variables to be more descriptive"}