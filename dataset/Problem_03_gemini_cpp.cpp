/*
Score : 
700
 points

Problem Statement
You have an integer sequence of length 
N
: 
a_1, a_2, ..., a_N
.

You repeatedly perform the following operation until the length of the sequence becomes 
1
:

First, choose an element of the sequence.

If that element is at either end of the sequence, delete the element.

If that element is not at either end of the sequence, replace the element with the sum of the two elements that are adjacent to it. Then, delete those two elements.

You would like to maximize the final element that remains in the sequence.

Find the maximum possible value of the final element, and the way to achieve it.

Constraints

All input values are integers.

2 \leq N \leq 1000

|a_i| \leq 10^9

Input
Input is given from Standard Input in the following format:

N

a_1

a_2

...

a_N

Output

In the first line, print the maximum possible value of the final element in the sequence.

In the second line, print the number of operations that you perform.

In the 
(2+i)
-th line, if the element chosen in the 
i
-th operation is the 
x
-th element from the left in the sequence at that moment, print 
x
.

If there are multiple ways to achieve the maximum value of the final element, any of them may be printed.

Sample Input 1
5
1 4 3 7 5

Sample Output 1
11
3
1
4
2

The sequence would change as follows:

After the first operation: 
4, 3, 7, 5

After the second operation: 
4, 3, 7

After the third operation: 
11(4+7)

Sample Input 2
4
100 100 -1 100

Sample Output 2
200
2
3
1

After the first operation: 
100, 200(100+100)

After the second operation: 
200

Sample Input 3
6
-1 -2 -3 1 2 3

Sample Output 3
4
3
2
1
2

After the first operation: 
-4, 1, 2, 3

After the second operation: 
1, 2, 3

After the third operation: 
4

Sample Input 4
9
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000

Sample Output 4
5000000000
4
2
2
2
2
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<long long> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    long long max_val = LLONG_MIN;
    vector<int> ans_indices;
    int num_ops = 0;

    for (int i = 0; i < (1 << (n - 1)); ++i) {
        vector<long long> current_a = a;
        vector<int> current_indices;
        int current_num_ops = 0;
        int bitmask = i;

        while (current_a.size() > 1) {
            int chosen_index = -1;
            long long max_current = LLONG_MIN;

            for (int j = 0; j < current_a.size(); ++j) {
                if (j == 0 || j == current_a.size() - 1) {
                    continue;
                }
                long long current_val = current_a[j];
                if (current_val > max_current) {
                    max_current = current_val;
                    chosen_index = j;
                }
            }

            if(chosen_index == -1) {
                for(int j = 0; j < current_a.size(); ++j) {
                    if(j == 0 || j == current_a.size() - 1) {
                        if(current_a[j] > max_current) {
                            max_current = current_a[j];
                            chosen_index = j;
                        }
                    }
                }
            }

            if (chosen_index != -1) {
                current_indices.push_back(chosen_index + 1);
                current_num_ops++;
                long long sum = current_a[chosen_index - 1] + current_a[chosen_index + 1];
                current_a.erase(current_a.begin() + chosen_index + 1);
                current_a.erase(current_a.begin() + chosen_index -1);
                current_a[chosen_index-1] = sum;

            } else {
                if (current_a[0] > max_current) {
                    max_current = current_a[0];
                    chosen_index = 0;
                    current_indices.push_back(1);
                    current_num_ops++;
                    current_a.erase(current_a.begin());
                }
                else if (current_a.back() > max_current) {
                    max_current = current_a.back();
                    chosen_index = current_a.size() -1;
                    current_indices.push_back(current_a.size());
                    current_num_ops++;
                    current_a.pop_back();
                }
            }

        }
      
        if (current_a.size() == 1 && current_a[0] > max_val) {
            max_val = current_a[0];
            ans_indices = current_indices;
            num_ops = current_num_ops;
        }
    }
    cout << max_val << endl;
    cout << num_ops << endl;
    for (int index : ans_indices) {
        cout << index << endl;
    }

    return 0;
}


