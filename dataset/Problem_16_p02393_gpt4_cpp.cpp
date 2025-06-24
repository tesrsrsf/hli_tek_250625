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

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    
    int data[3] = {a, b, c};
    sort(data, data + 3);
    
    cout << data[0] << ' ' << data[1] << ' ' << data[2] << endl;
    return 0;
}


// {annotation: "using namespace std to improve code readability"}