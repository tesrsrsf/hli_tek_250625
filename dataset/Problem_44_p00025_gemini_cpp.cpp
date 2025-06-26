/*
Hit and Blow

Let's play Hit and Blow game. 
A
 imagines four numbers and 
B
 guesses the numbers. After 
B
 picks out four numbers, 
A
 answers:

 The number of numbers which have the same place with numbers 
A
 imagined (Hit) 

 The number of numbers included (but different place) in the numbers 
A
 imagined (Blow)

For example, if 
A
 imagined numbers:

9 1 8 2

and 
B
 chose:

4 1 5 9

A
 should say 1 Hit and 1 Blow.

Write a program which reads four numbers 
A
 imagined and four numbers 
B
 chose and prints the number of Hit and Blow respectively. You may assume that the four numbers are all different and within from 0 to 9.

Input

The input consists of multiple datasets. Each dataset set consists of:

a
1

a
2

a
3

a
4

b
1

b
2

b
3

b
4

, where 
a
i
 (0 ≤ 
a
i
 ≤ 9) is 
i
-th number 
A
  imagined and 
b
i
 (0 ≤ 
b
i
 ≤ 9) is 
i
-th number 
B
 chose.

The input ends with EOF. The number of datasets is less than or equal to 50.

Output

For each dataset, print the number of Hit and Blow in a line. These two numbers should be separated by a space.

Sample Input

9 1 8 2
4 1 5 9
4 6 8 2
4 6 3 2

Output for the Sample Input

1 1
3 0
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>

using namespace std;

int main() {
    int a1, a2, a3, a4, b1, b2, b3, b4;

    while (cin >> a1 >> a2 >> a3 >> a4 >> b1 >> b2 >> b3 >> b4) {
        vector<int> a = {a1, a2, a3, a4};
        vector<int> b = {b1, b2, b3, b4};
        int hit = 0, blow = 0;

        for (int i = 0; i < 4; i++) {
            if (a[i] == b[i]) {
                hit++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j && a[i] == b[j]) {
                    blow++;
                }
            }
        }
        string res = to_string(hit) + " " + to_string(blow);
        cout << res << endl;
    }
    return 0;
}


// {annotation: "output message generation is done in a separate variable, improving readability"}