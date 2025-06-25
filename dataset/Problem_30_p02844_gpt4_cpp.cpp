/*
Score: 
400
 points

Problem Statement

AtCoder Inc. has decided to lock the door of its office with a 
3
-digit PIN code.

The company has an 
N
-digit lucky number, 
S
. Takahashi, the president, will erase 
N-3
 digits from 
S
 and concatenate the remaining 
3
 digits without changing the order to set the PIN code.

How many different PIN codes can he set this way?

Both the lucky number and the PIN code may begin with a 
0
.

Constraints

4 \leq N \leq 30000

S
 is a string of length 
N
 consisting of digits.

Input

Input is given from Standard Input in the following format:

N

S

Output

Print the number of different PIN codes Takahashi can set.

Sample Input 1
4
0224

Sample Output 1
3

Takahashi has the following options:

Erase the first digit of 
S
 and set 
224
.

Erase the second digit of 
S
 and set 
024
.

Erase the third digit of 
S
 and set 
024
.

Erase the fourth digit of 
S
 and set 
022
.

Thus, he can set three different PIN codes: 
022
, 
024
, and 
224
.

Sample Input 2
6
123123

Sample Output 2
17

Sample Input 3
19
3141592653589793238

Sample Output 3
329
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <set>
#include <string>

using namespace std;

int main() {
    int N;
    string S;
    cin >> N >> S;

    set<string> pos_nums;

    for (int i = 0; i < N - 2; i++) {
        for (int j = i + 1; j < N - 1; j++) {
            for (int k = j + 1; k < N; k++) {
                string pos_num = { S[i], S[j], S[k] };
                pos_nums.insert(pos_num);
            }
        }
    }

    cout << pos_nums.size() << endl;

    return 0;
}


// {annotation: "added using namespace std to avoid std:: prefix, improves readability, also replaced ++i to i++ to fit my style"}