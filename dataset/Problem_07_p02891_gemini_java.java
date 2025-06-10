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



import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        int n = s.length();
        int ans = 0;
        if (k == 1) {
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    ans++;
                }
            }
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (s.charAt(i) == s.charAt(j))
                    count++;
            }
            if (i > 0 && s.charAt(i) == s.charAt(i - 1))
                ans++;
            
        }
        
        int totalChar = 0;
        for(int i = 0; i < n; i++){
            if(i > 0 && s.charAt(i) == s.charAt(i-1)){
                totalChar++;
            }
        }
        
        ans = totalChar *k;
        
        if(k>1){
            
        }
        
        System.out.println(ans);
    }
}


