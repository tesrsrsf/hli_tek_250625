/*
Score : 
700
 points

Problem Statement
Find the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Constraints

2 \leq K \leq 10^5

K
 is an integer.

Input
Input is given from Standard Input in the following format:

K

Output
Print the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Sample Input 1
6

Sample Output 1
3

12=6×2
 yields the smallest sum.

Sample Input 2
41

Sample Output 2
5

11111=41×271
 yields the smallest sum.

Sample Input 3
79992

Sample Output 3
36
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <queue>
#include <vector>
#include <set>

using namespace std;

int digitSum(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

int main() {
    int K;
    cin >> K;

    queue<pair<long long, int>> q; // pair<current multiple, digit sum>
    set<long long> visited; // to track visited multiples
    q.push({0, 0}); // start with 0 multiples
    
    while (!q.empty()) {
        auto [current, sum] = q.front();
        q.pop();

        for (int i = 1; i <= 9; i++) {
            long long next = current * 10 + i;
            if (next % K == 0) {
                cout << sum + digitSum(i) << endl;
                return 0;
            }

            if (visited.count(next) == 0) {
                visited.insert(next);
                q.push({next, sum + digitSum(i)});
            }
        }
    }
    return 0;
}


