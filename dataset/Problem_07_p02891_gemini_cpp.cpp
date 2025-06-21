/*
Score : 
300
 points

Problem Statement
Given is a string 
S
. Let 
T
 be the concatenation of 
K
 copies of 
S
.
We can repeatedly perform the following operation: choose a character in 
T
 and replace it with a different character.
Find the minimum number of operations required to satisfy the following condition: any two adjacent characters in 
T
 are different.

Constraints

1 \leq |S| \leq 100

S
 consists of lowercase English letters.

1 \leq K \leq 10^9

K
 is an integer.

Input
Input is given from Standard Input in the following format:

S

K

Output
Print the minimum number of operations required.

Sample Input 1
issii
2

Sample Output 1
4

T
 is 
issiiissii
.  For example, we can rewrite it into 
ispiqisyhi
, and now any two adjacent characters are different.

Sample Input 2
qq
81

Sample Output 2
81

Sample Input 3
cooooooooonteeeeeeeeeest
999993333

Sample Output 3
8999939997
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    string s;
    int k;
    cin >> s >> k;

    int n = s.length();
    int ans = 0;

    if (k == 1) {
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                ans++;
            }
        }
    } else {
        vector<int> counts(26, 0);
        for (char c : s) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i+1]) {
                ans++;
                s[i + 1] = ' ';
            }
        }
        
        int same_pairs = 0;
        for(int i = 0; i < n - 1; i++){
            if(s[i] == s[i + 1] && s[i] != ' '){
                same_pairs++;
            }
        }
        
        ans = (k * (n - 1));

        vector<int> same_count;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1] && s[i] != ' ') {
                same_count.push_back(1);
                s[i + 1] = ' ';
            }else{
                if(s[i + 1] == ' '){
                    continue;
                }
               
            }
        }
        
        
        int count_same_pairs = 0;
        for(int i = 0; i < n - 1; i++){
            if(s[i] == s[i + 1] && s[i] != ' '){
                count_same_pairs++;
            }
        }
        
        ans = (k * n) - (k * n - k);
        
        int temp = 0;
        for(int i = 0; i < n - 1; i++){
            if(s[i] == s[i+1] && s[i] != ' '){
                temp++;
            }
        }
        
        ans = (k * temp);
        
        int same_adj = 0;
        for(int i = 0; i < n - 1; i++){
            if(s[i] == s[i + 1] && s[i] != ' '){
                same_adj++;
            }
        }
         ans = (k - 1) * same_adj;
        
        ans = 0;
        int run_count = 0;
         for (int i = 0; i < n - 1; i++) {
                if (s[i] == s[i + 1]){
                    run_count++;
                }
         }
         ans = run_count * (k);

        int total_same_adj = 0;
         for (int i = 0; i < n - 1; i++) {
                if (s[i] == s[i + 1]){
                    total_same_adj++;
                }
         }
        ans = (k - 1) * total_same_adj;

        for(int i = 0; i < n-1; i++){
            if(s[i] == s[i + 1]){
                ans++;
            }
        }
          ans = (k - 1) * ans;
         
    }

    cout << ans << endl;

    return 0;
}


// {annotation: "reformatted the program to fit my coding style, still broken though"}