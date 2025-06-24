/*
Score : 
500
 points

Problem Statement
You are given a sequence with 
N
 integers: 
A = \{ A_1, A_2, \cdots, A_N \}
.
For each of these 
N
 integers, we will choose a color and paint the integer with that color. Here the following condition must be satisfied:

If 
A_i
 and 
A_j

(i < j)
 are painted with the same color, 
A_i < A_j
.

Find the minimum number of colors required to satisfy the condition.

Constraints

1 \leq N \leq 10^5

0 \leq A_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

A_1

:

A_N

Output
Print the minimum number of colors required to satisfy the condition.

Sample Input 1
5
2
1
4
5
3

Sample Output 1
2

We can satisfy the condition with two colors by, for example, painting 
2
 and 
3
 red and painting 
1
, 
4
, and 
5
 blue.

Sample Input 2
4
0
0
0
0

Sample Output 2
4

We have to paint all the integers with distinct colors.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <set>

using namespace std;

int main() {
    int N;
    vector<int> data;

    cin >> N;
    for (int i = 0; i < N; ++i) {
        int temp;
        cin >> temp;
        data.push_back(temp);
    }

    set<int> colors;
    vector<int> counts(1, 0);

    for (int i = 0; i < N; i++) {
        if (colors.count(data[i]) == 0) {
            colors.insert(data[i]);
            counts.push_back(1);
        } else {
            counts[colors.size()] += 1;
        }
    }

    cout << colors.size() << endl;

    return 0;
}


// {annotation: "changed ++i to i++, changed the way to use vector to my style"}