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

using namespace std;

int main() {
    int h, w;
    cin >> h >> w;
    while (h != 0 && w != 0) {
        vector<string> space;
        for (int i = 0; i < h; ++i) {
            string line;
            cin >> line;
            space.push_back(line);
        }

        int x = 0, y = 0;
        int steps = 0;
        vector<pair<int, int>> visited;
        bool isLoop = false;

        while (steps < h * w * 2) {
            steps++;
            char cell = space[y][x];
            
            bool isDot = false;
            switch (cell) {
            case '>':
                x++;
                break;
            case '<':
                x--;
                break;
            case '^':
                y--;
                break;
            case 'v':
                y++;
                break;
            default:
                isDot = true;
                break;
            }
            if (isDot) {
                break;
            }

            if (x < 0 || x >= w || y < 0 || y >= h) {
                break;
            }

            bool isFound = false;
            for (auto p : visited) {
                if (p.first == x && p.second == y) {
                    isFound = true;
                    break;
                }
            }
            if (isFound ) {
                isLoop = true;
                break;
            }
            visited.push_back({x, y});
        }

        if (isLoop) {
            cout << "LOOP" << endl;
        } else {
            cout << x << " " << y << endl;
        }

        cin >> h >> w;
    }
    return 0;
}


// {annotation: "fixed broken logic, replaced if-else with switch-case for better readability, also renamed variables for clarity"}