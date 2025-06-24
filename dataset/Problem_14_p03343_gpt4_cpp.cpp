/*
Score : 
600
 points

Problem Statement
You are given an integer sequence 
A
 of length 
N
 and an integer 
K
.
You will perform the following operation on this sequence 
Q
 times:

Choose a contiguous subsequence of length 
K
, then remove the smallest element among the 
K
 elements contained in the chosen subsequence (if there are multiple such elements, choose one of them as you like).

Let 
X
 and 
Y
 be the values of the largest and smallest element removed in the 
Q
 operations. You would like 
X-Y
 to be as small as possible.
Find the smallest possible value of 
X-Y
 when the 
Q
 operations are performed optimally.

Constraints

1 \leq N \leq 2000

1 \leq K \leq N

1 \leq Q \leq N-K+1

1 \leq A_i \leq 10^9

All values in input are integers.

Input
Input is given from Standard Input in the following format:

N

K

Q

A_1

A_2

...

A_N

Output
Print the smallest possible value of 
X-Y
.

Sample Input 1
5 3 2
4 3 1 5 2

Sample Output 1
1

In the first operation, whichever contiguous subsequence of length 
3
 we choose, the minimum element in it is 
1
.
Thus, the first operation removes 
A_3=1
 and now we have 
A=(4,3,5,2)
.
In the second operation, it is optimal to choose 
(A_2,A_3,A_4)=(3,5,2)
 as the contiguous subsequence of length 
3
 and remove 
A_4=2
.
In this case, the largest element removed is 
2
, and the smallest is 
1
, so their difference is 
2-1=1
.

Sample Input 2
10 1 6
1 1 2 3 5 8 13 21 34 55

Sample Output 2
7

Sample Input 3
11 7 5
24979445 861648772 623690081 433933447 476190629 262703497 211047202 971407775 628894325 731963982 822804784

Sample Output 3
451211184
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

int main() {
    int N, K, Q;
    cin >> N >> K >> Q;
    vector<int> data;
    
    for (int i = 0; i < N; ++i) {
        int temp;
        cin >> temp;
        data.push_back(temp);
    }

    multiset<int> min_eles;
    for (int i = 0; i <= N - K; ++i) {
        min_eles.insert(*min_element(data.begin() + i, data.begin() + i + K));
    }

    vector<int> smallRemoved;
    for (auto it = min_eles.begin(); it != min_eles.end() && smallRemoved.size() < Q; ++it) {
        smallRemoved.push_back(*it);
    }

    int X = *max_element(smallRemoved.begin(), smallRemoved.end());
    int Y = *min_element(smallRemoved.begin(), smallRemoved.end());
    
    cout << X - Y << "\n";

    return 0;
}


// {annotation: "renamed variables with my style"}