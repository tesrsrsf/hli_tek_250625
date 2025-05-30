/*
Score : 
500
 points

Problem Statement
Snuke, who loves animals, built a zoo.

There are 
N
 animals in this zoo. They are conveniently numbered 
1
 through 
N
, and arranged in a circle.
The animal numbered 
i (2≤i≤N-1)
 is adjacent to the animals numbered 
i-1
 and 
i+1
. Also, the animal numbered 
1
 is adjacent to the animals numbered 
2
 and 
N
, and the animal numbered 
N
 is adjacent to the animals numbered 
N-1
 and 
1
.

There are two kinds of animals in this zoo: honest sheep that only speak the truth, and lying wolves that only tell lies.

Snuke cannot tell the difference between these two species, and asked each animal the following question: "Are your neighbors of the same species?" The animal numbered 
i
 answered 
s_i
. Here, if 
s_i
 is 
o
, the animal said that the two neighboring animals are of the same species, and if 
s_i
 is 
x
, the animal said that the two neighboring animals are of different species.

More formally, a sheep answered 
o
 if the two neighboring animals are both sheep or both wolves, and answered 
x
 otherwise.
Similarly, a wolf answered 
x
 if the two neighboring animals are both sheep or both wolves, and answered 
o
 otherwise.

Snuke is wondering whether there is a valid assignment of species to the animals that is consistent with these responses. If there is such an assignment, show one such assignment. Otherwise, print 
-1
.

Constraints

3 ≤ N ≤ 10^{5}

s
 is a string of length 
N
 consisting of 
o
 and 
x
.

Input
The input is given from Standard Input in the following format:

N

s

Output
If there does not exist an valid assignment that is consistent with 
s
, print 
-1
.
Otherwise, print an string 
t
 in the following format. The output is considered correct if the assignment described by 
t
 is consistent with 
s
.

t
 is a string of length 
N
 consisting of 
S
 and 
W
.

If 
t_i
 is 
S
, it indicates that the animal numbered 
i
 is a sheep. If 
t_i
 is 
W
, it indicates that the animal numbered 
i
 is a wolf.

Sample Input 1
6
ooxoox

Sample Output 1
SSSWWS

For example, if the animals numbered 
1
, 
2
, 
3
, 
4
, 
5
 and 
6
 are respectively a sheep, sheep, sheep, wolf, wolf, and sheep, it is consistent with their responses. Besides, there is another valid assignment of species: a wolf, sheep, wolf, sheep, wolf and wolf.

Let us remind you: if the neiboring animals are of the same species, a sheep answers 
o
 and a wolf answers 
x
. If the neiboring animals are of different species, a sheep answers 
x
 and a wolf answers 
o
.

Sample Input 2
3
oox

Sample Output 2
-1

Print 
-1
 if there is no valid assignment of species.

Sample Input 3
10
oxooxoxoox

Sample Output 3
SSWWSSSWWS
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    string s;
    cin >> s;

    for (int first1 = 0; first1 <= 1; ++first1) {
        for (int first2 = 0; first2 <= 1; ++first2) {
            vector<int> species(n);
            species[0] = first1;
            species[1] = first2;

            bool possible = true;
            for (int i = 2; i < n; ++i) {
                if (s[i - 1] == 'o') {
                    species[i] = species[i - 2];
                } else {
                    species[i] = 1 - species[i - 2];
                }
            }

            if (n > 2) {
            if (s[0] == 'o') {
                    if (species[0] != species[1] && species[0] == species[n-1] ) possible =false;
               
                } else {
                 if (species[0] == species[1] && species[0] != species[n-1]) possible =false;
                }


            if (s[n-1] == 'o') {
               if(species[n-1] != species[n-2] && species[n-1] == species[0]) possible =false;
            } else{
                if(species[n-1] == species[n-2] && species[n-1]!=species[0]) possible=false;
            }

            }

            if (possible) {
                string result = "";
                for (int i = 0; i < n; ++i) {
                    result += (species[i] == 0) ? 'S' : 'W';
                }
                cout << result << endl;
                return 0;
            }
        }
    }

    cout << -1 << endl;

    return 0;
}


