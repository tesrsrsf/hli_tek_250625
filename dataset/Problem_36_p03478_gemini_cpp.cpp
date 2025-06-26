/*
Score : 
200
 points

Problem Statement
Find the sum of the integers between 
1
 and 
N
 (inclusive), whose sum of digits written in base 
10
 is between 
A
 and 
B
 (inclusive).

Constraints

1 \leq N \leq 10^4

1 \leq A \leq B \leq 36

All input values are integers.

Input
Input is given from Standard Input in the following format:

N

A

B

Output
Print the sum of the integers between 
1
 and 
N
 (inclusive), whose sum of digits written in base 
10
 is between 
A
 and 
B
 (inclusive).

Sample Input 1
20 2 5

Sample Output 1
84

Among the integers not greater than 
20
, the ones whose sums of digits are between 
2
 and 
5
, are: 
2,3,4,5,11,12,13,14
 and 
20
. We should print the sum of these, 
84
.

Sample Input 2
10 1 2

Sample Output 2
13

Sample Input 3
100 4 16

Sample Output 3
4554
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>

using namespace std;

int sum_digits(int n) {
    int sum = 0;
    string s = to_string(n);
    for (char c : s) {
        sum += c - '0';
    }
    return sum;
}

int main() {
    int n, a, b;
    cin >> n >> a >> b;

    int res = 0;
    for (int i = 1; i < n + 1; i++) {
        int digit_sum = sum_digits(i);
        if (digit_sum >= a && digit_sum <= b) {
            res += i;
        }
    }

    cout << res << endl;

    return 0;
}


// {annotation: "avoiding using capital letters in variable names, also renamed variables in my style"}