/*
Score : 
600
 points

Problem Statement
Nagase is a top student in high school. One day, she's analyzing some properties of special sets of positive integers.  

She thinks that a set 
S = \{a_{1}, a_{2}, ..., a_{N}\}
 of 
distinct
 positive integers is called 
special
 if for all 
1 \leq i \leq N
, the gcd (greatest common divisor) of 
a_{i}
 and the sum of the remaining elements of 
S
 is 
not

1
.

Nagase wants to find a 
special
 set of size 
N
. However, this task is too easy, so she decided to ramp up the difficulty. Nagase challenges you to find a 
special
 set of size 
N
 such that the gcd of all elements are 
1
 and the elements of the set does not exceed 
30000
.

Constraints

3 \leq N \leq 20000

Input
Input is given from Standard Input in the following format:

N

Output
Output 
N
 space-separated integers, denoting the elements of the set 
S
. 
S
 must satisfy the following conditions :

The elements must be 
distinct
 positive integers not exceeding 
30000
.

The gcd of all elements of 
S
 is 
1
, i.e. there does not exist an integer 
d > 1
 that divides all elements of 
S
.

S
 is a 
special
 set.

If there are multiple solutions, you may output any of them. The elements of 
S
 may be printed in any order. It is guaranteed that at least one solution exist under the given contraints.

Sample Input 1
3

Sample Output 1
2 5 63

\{2, 5, 63\}
 is special because 
gcd(2, 5 + 63) = 2, gcd(5, 2 + 63) = 5, gcd(63, 2 + 5) = 7
. Also, 
gcd(2, 5, 63) = 1
. Thus, this set satisfies all the criteria.

Note that 
\{2, 4, 6\}
 is not a valid solution because 
gcd(2, 4, 6) = 2 > 1
.

Sample Input 2
4

Sample Output 2
2 5 20 63

\{2, 5, 20, 63\}
 is special because 
gcd(2, 5 + 20 + 63) = 2, gcd(5, 2 + 20 + 63) = 5, gcd(20, 2 + 5 + 63) = 10, gcd(63, 2 + 5 + 20) = 9
. Also, 
gcd(2, 5, 20, 63) = 1
. Thus, this set satisfies all the criteria.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>

using namespace std;

int gcd(int a, int b) {
    while (b) {
        a %= b;
        swap(a, b);
    }
    return a;
}

int main() {
    int N;
    cin >> N;
    vector<int> S;
    S.push_back(2);
    S.push_back(5);
    for (int i = 1; S.size() < N; ++i) {
        int val = 63 + ((i-1)*20);       
        bool valid = true;
        for (int x : S){
            if(val == x)
                valid = false;
        }
        if(val <= 30000 && valid){
            S.push_back(val);
        }
        
    }
     for (int i = 0; i< S.size(); ++i) {
        cout << S[i] << (i == S.size() - 1 ? "" : " ");
    }
    cout << endl;
    return 0;
}


