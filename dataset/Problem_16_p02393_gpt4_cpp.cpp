/*
Sorting Three Numbers

  Write a program which reads three integers, and prints them in ascending order.

Input

  Three integers separated by a single space are given in a line.

Output

  Print the given integers in ascending order in a line. Put a single space between two integers.

Constraints

 1 ≤ the three integers ≤ 10000

Sample Input 1

3 8 1

Sample Output 1

1 3 8
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <algorithm>

int main() {
    int a, b, c;
    std::cin >> a >> b >> c;
    
    int numbers[3] = {a, b, c};
    std::sort(numbers, numbers + 3);
    
    std::cout << numbers[0] << ' ' << numbers[1] << ' ' << numbers[2] << std::endl;
    return 0;
}


