/*
Score : 
600
 points

Problem Statement
There are 
N
 people, conveniently numbered 
1
 through 
N
.
We want to divide them into some number of groups, under the following two conditions:

Every group contains between 
A
 and 
B
 people, inclusive.

Let 
F_i
 be the number of the groups containing exactly 
i
 people. Then, for all 
i
, either 
F_i=0
 or 
C≤F_i≤D
 holds.

Find the number of these ways to divide the people into groups.
Here, two ways to divide them into groups is considered different if and only if there exists two people such that they belong to the same group in exactly one of the two ways.
Since the number of these ways can be extremely large, print the count modulo 
10^9+7
.

Constraints

1≤N≤10^3

1≤A≤B≤N

1≤C≤D≤N

Input
The input is given from Standard Input in the following format:

N

A

B

C

D

Output
Print the number of ways to divide the people into groups under the conditions, modulo 
10^9+7
.

Sample Input 1
3 1 3 1 2

Sample Output 1
4

There are four ways to divide the people:

(1,2),(3)

(1,3),(2)

(2,3),(1)

(1,2,3)

The following way to divide the people does not count: 
(1),(2),(3)
. This is because it only satisfies the first condition and not the second.

Sample Input 2
7 2 3 1 3

Sample Output 2
105

The only ways to divide the people under the conditions are the ones where there are two groups of two people, and one group of three people.
There are 
105
 such ways.

Sample Input 3
1000 1 1000 1 1000

Sample Output 3
465231251

Sample Input 4
10 3 4 2 5

Sample Output 4
0

The answer can be 
0
.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>

using namespace std;

const int mod = 1e9 + 7;
const int MAXN = 1005;

long long dp[MAXN][MAXN];
long long fact[MAXN];
long long inv[MAXN];

long long power(long long x, long long y) {
    long long ret = 1;
    x %= mod;
    while (y) {
        if (y & 1) ret = (ret * x) % mod;
        y >>= 1;
        x = (x * x) % mod;
    }
    return ret;
}

long long C(int n, int k) {
    if (k < 0 || k > n) return 0;
    return (((fact[n] * inv[k]) % mod) * inv[n - k]) % mod;
}

int main() {
    int n, a, b, c, d;
    cin >> n >> a >> b >> c >> d;

    fact[0] = 1;
    for (int i = 1; i <= n; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
    }
    inv[n] = power(fact[n], mod - 2);
    for (int i = n - 1; i >= 0; i--) {
        inv[i] = (inv[i + 1] * (i + 1)) % mod;
    }

    dp[0][0] = 1;
    for (int i = a; i <= b; i++) {
        for (int j = 0; j * i <= n; j++) {
            for (int k = c; k <= d; k++) {
                if (j + k * i <= n) {
                    dp[i][j + k * i] = (dp[i][j + k * i] + (dp[i - 1][j] * C(n - j, k * i) % mod) * fact[k] % mod * inv[k]) % mod;
                }
            }
        }
    }

    long long ans = 0;
    for(int j = 0; j <= n; ++j) {
            ans = (ans + dp[b][j]) % mod;
    }
    
    cout << ans << endl;

    return 0;
}


