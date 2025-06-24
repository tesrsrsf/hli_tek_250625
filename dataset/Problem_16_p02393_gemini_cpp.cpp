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
#include <vector>

using namespace std;

int main() {
  vector<int> nums;
  for (int i = 0; i < 3; i++) {
    int num;
    cin >> num;
    nums.push_back(num);
  }
  sort(nums.begin(), nums.end());
  for (int i = 0; i < 3; i++) {
    cout << nums[i] << " ";
  }
  cout << endl;
  return 0;
}


// {annotation: "avoid using vector as a fixed-size array, make it as a dynamic list, matches my habit of using vector"}