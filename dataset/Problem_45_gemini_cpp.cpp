/*
Score : 
300
 points

Problem Statement
E869120 found a chest which is likely to contain treasure.

However, the chest is locked. In order to open it, he needs to enter a string 
S
 consisting of lowercase English letters.

He also found a string 
S'
, which turns out to be the string 
S
 with some of its letters (possibly all or none) replaced with 
?
.  

One more thing he found is a sheet of paper with the following facts written on it:  

Condition 1: The string 
S
 contains a string 
T
 as a contiguous substring.

Condition 2: 
S
 is the lexicographically smallest string among the ones that satisfy Condition 1.

Print the string 
S
.

If such a string does not exist, print 
UNRESTORABLE
.  

Constraints

1 \leq |S'|, |T| \leq 50

S'
 consists of lowercase English letters and 
?
.

T
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

S

T'

Output
Print the string 
S
.

If such a string does not exist, print 
UNRESTORABLE
 instead.  

Sample Input 1
?tc????
coder

Sample Output 1
atcoder

There are 
26
 strings that satisfy Condition 1: 
atcoder
, 
btcoder
, 
ctcoder
,..., 
ztcoder
.
Among them, the lexicographically smallest is 
atcoder
, so we can say 
S = 
atcoder
.

Sample Input 2
??p??d??
abc

Sample Output 2
UNRESTORABLE

There is no string that satisfies Condition 1, so the string 
S
 does not exist.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    string s_prime, t;
    cin >> s_prime >> t;

    string ans = "UNRESTORABLE";
    int n = s_prime.length();
    int m = t.length();

    for (int i = 0; i <= n - m; ++i) {
        string temp = s_prime;
        bool possible = true;

        for (int j = 0; j < m; ++j) {
            if (i + j < n) {
                if (temp[i + j] == '?') {
                    temp[i + j] = t[j];
                } else if (temp[i + j] != t[j]) {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            string current_s = temp;
            for (int k = 0; k < n; ++k) {
                if (current_s[k] == '?') {
                    current_s[k] = 'a';
                }
            }
            
            bool contains_t = false;
            for(int k = 0; k <= n-m; ++k){
                if(current_s.substr(k, m) == t){
                    contains_t = true;
                    break;
                }
            }

            if(contains_t){
                
                bool valid_s = true;
                for(int k = 0; k < n; ++k){
                    if(s_prime[k] != '?' && s_prime[k] != current_s[k]){
                        valid_s = false;
                        break;
                    }
                }
                if(valid_s){
                    if (ans == "UNRESTORABLE" || current_s < ans) {
                        ans = current_s;
                    }
                }
            }
        }
    }

    cout << ans << endl;

    return 0;
}


