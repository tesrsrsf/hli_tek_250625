/*
Score : 
300
 points

Problem Statement
Given is a string 
S
 consisting of lowercase English letters. Find the maximum positive integer 
K
 that satisfies the following condition:

There exists a partition of 
S
 into 
K
 non-empty strings 
S=S_1S_2...S_K
 such that 
S_i \neq S_{i+1}
 (
1 \leq i \leq K-1
).

Here 
S_1S_2...S_K
 represents the concatenation of 
S_1,S_2,...,S_K
 in this order.

Constraints

1 \leq |S| \leq 2 \times 10^5

S
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

S

Output
Print the maximum positive integer 
K
 that satisfies the condition.

Sample Input 1
aabbaa

Sample Output 1
4

We can, for example, divide 
S
 into four strings 
aa
, 
b
, 
ba
, and 
a
.

Sample Input 2
aaaccacabaababc

Sample Output 2
12
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    string s;
    cin >> s;

    int n = s.length();
    int max_k = 0;

    for (int k = 1; k <= n; ++k) {
        if (n < k) {
            break;
        }
        
        for (int i = 0; i < (1 << (n - 1)); ++i) {
            vector<string> parts;
            string current_part = "";
            int part_count = 0;
            
            for (int j = 0; j < n; ++j) {
                current_part += s[j];
                if (j < n - 1 && (i & (1 << j))) {
                    parts.push_back(current_part);
                    current_part = "";
                    part_count++;
                }
            }
            parts.push_back(current_part);
            part_count++;

            if (part_count == k) {
                bool ok = true;
                for (int l = 0; l < k - 1; ++l) {
                    if (parts[l] == parts[l + 1]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    max_k = max(max_k, k);
                }
            }
        }
    }
    cout << max_k << endl;

    return 0;
}


