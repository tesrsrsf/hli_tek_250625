/*
Score : 
400
 points

Problem Statement
We have a string 
s
 consisting of lowercase English letters.
Snuke can perform the following operation repeatedly:

Insert a letter 
x
 to any position in 
s
 of his choice, including the beginning and end of 
s
.

Snuke's objective is to turn 
s
 into a palindrome.
Determine whether the objective is achievable. If it is achievable, find the minimum number of operations required.

Notes
A 
palindrome
 is a string that reads the same forward and backward.
For example, 
a
, 
aa
, 
abba
 and  
abcba
 are palindromes, while 
ab
, 
abab
 and 
abcda
 are not.

Constraints

1 \leq |s| \leq 10^5

s
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

s

Output
If the objective is achievable, print the number of operations required.
If it is not, print 
-1
 instead.

Sample Input 1
xabxa

Sample Output 1
2

One solution is as follows (newly inserted 
x
 are shown in bold):

xabxa → xa
x
bxa → xaxbxa
x

Sample Input 2
ab

Sample Output 2
-1

No sequence of operations can turn 
s
 into a palindrome.

Sample Input 3
a

Sample Output 3
0

s
 is a palindrome already at the beginning.

Sample Input 4
oxxx

Sample Output 4
3

One solution is as follows:

oxxx → 
x
oxxx → 
x
xoxxx → 
x
xxoxxx
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_13_p03569_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        int n = s.length();
        int operations = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                int leftIdx = left;
                int rightIdx = right;
                boolean matches = false;

                while (leftIdx < rightIdx) {
                    if (s.charAt(leftIdx) == s.charAt(rightIdx)) {
                        matches = true;
                        break;
                    }
                    rightIdx--;
                }

                if (matches == true) {
                    operations += (right - rightIdx);
                     right = rightIdx -1;
                     left++;

                } else {
                    operations += (right - left);

                        left++;
                        right = left -1;


                }
            }
        }

        System.out.println(operations);
    }
}


// {annotation: "renamed variables to my style"}