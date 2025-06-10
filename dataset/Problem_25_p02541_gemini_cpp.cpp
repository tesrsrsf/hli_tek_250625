/*
Score : 
600
 points

Problem Statement
Given is an integer 
N
.
Find the minimum possible positive integer 
k
 such that 
(1+2+\cdots+k)
 is a multiple of 
N
.
It can be proved that such a positive integer 
k
 always exists.

Constraints

1 \leq N \leq 10^{15}

All values in input are integers.

Input
Input is given from Standard Input in the following format:

N

Output
Print the answer in a line.

Sample Input 1
11

Sample Output 1
10

1+2+\cdots+10=55
 holds and 
55
 is indeed a multple of 
N=11
.
There are no positive integers 
k \leq 9
 that satisfy the condition, so the answer is 
k = 10
.

Sample Input 2
20200920

Sample Output 2
1100144
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>

using namespace std;

long long gcd(long long a, long long b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

int main() {
    long long n;
    cin >> n;

    if (n % 2 == 1) {
        cout << n << endl;
    } else {
        long long temp = n;
        while (temp % 2 == 0) {
            temp /= 2;
        }
        cout << temp << endl;
    }

    return 0;
}


