/*
Score: 
500
 points

Problem Statement

In the Kingdom of AtCoder, only banknotes are used as currency. There are 
10^{100}+1
 kinds of banknotes, with the values of 
1, 10, 10^2, 10^3, \dots, 10^{(10^{100})}
. You have come shopping at a mall and are now buying a takoyaki machine with a value of 
N
. 
(Takoyaki is the name of a Japanese snack.)

To make the payment, you will choose some amount of money which is at least 
N
 and give it to the clerk. Then, the clerk gives you back the change, which is the amount of money you give minus 
N
.

What will be the minimum possible number of total banknotes used by you and the clerk, when both choose the combination of banknotes to minimize this count?

Assume that you have sufficient numbers of banknotes, and so does the clerk.

Constraints

N
 is an integer between 
1
 and 
10^{1,000,000}
 (inclusive).

Input

Input is given from Standard Input in the following format:

N

Output

Print the minimum possible number of total banknotes used by you and the clerk.

Sample Input 1
36

Sample Output 1
8

If you give four banknotes of value 
10
 each, and the clerk gives you back four banknotes of value 
1
 each, a total of eight banknotes are used.

The payment cannot be made with less than eight banknotes in total, so the answer is 
8
.

Sample Input 2
91

Sample Output 2
3

If you give two banknotes of value 
100, 1
, and the clerk gives you back one banknote of value 
10
, a total of three banknotes are used.

Sample Input 3
314159265358979323846264338327950288419716939937551058209749445923078164062862089986280348253421170

Sample Output 3
243
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <algorithm>

int main() {
    std::string N;
    std::cin >> N;

    int total_banknotes = 0;
    
    // Count the number of digits in N
    int len = N.length();

    // Count banknotes used by you
    total_banknotes += len; // Each digit in N corresponds to one banknote of value 10^i for each position i

    // Count banknotes used by clerk for change
    // If the most significant digit is not 0, we need to round up to the next power of 10
    if (N[0] != '0') {
        total_banknotes += 1; // one additional banknote for the next power of 10
    }
    
    // Total banknotes is the sum from you and the clerk
    std::cout << total_banknotes << std::endl;

    return 0;
}


