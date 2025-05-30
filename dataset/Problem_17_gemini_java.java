/*
Score : 
400
 points

Problem Statement
Given a string 
t
, we will call it 
unbalanced
 if and only if the length of 
t
 is at least 
2
, and more than half of the letters in 
t
 are the same. For example, both 
voodoo
 and 
melee
 are unbalanced, while neither 
noon
 nor 
a
 is.

You are given a string 
s
 consisting of lowercase letters. Determine if there exists a (contiguous) substring of 
s
 that is unbalanced. If the answer is positive, show a position where such a substring occurs in 
s
.

Constraints

2 ≦ |s| ≦ 10^5

s
 consists of lowercase letters.

Partial Score

200
 points will be awarded for passing the test set satisfying 
2 ≦ N ≦ 100
.

Input
The input is given from Standard Input in the following format:

s

Output
If there exists no unbalanced substring of 
s
, print 
-1 -1
.

If there exists an unbalanced substring of 
s
, let one such substring be 
s_a s_{a+1} ... s_{b}

(1 ≦ a < b ≦ |s|)
, and print 
a

b
. If there exists more than one such substring, any of them will be accepted.

Sample Input 1
needed

Sample Output 1
2 5

The string 
s_2 s_3 s_4 s_5

=

eede
 is unbalanced. There are also other unbalanced substrings. For example, the output 
2 6
 will also be accepted.

Sample Input 2
atcoder

Sample Output 2
-1 -1

The string 
atcoder
 contains no unbalanced substring.
*/


// =============SOLUTION STARTS HERE==============



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        int start = -1, end = -1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String sub = s.substring(i, j + 1);
                int len = sub.length();
                if (len >= 2) {
                    Map<Character, Integer> counts = new HashMap<>();
                    for (char c : sub.toCharArray()) {
                        counts.put(c, counts.getOrDefault(c, 0) + 1);
                    }
                    for (int count : counts.values()) {
                        if (count * 2 > len) {
                            start = i + 1;
                            end = j + 1;
                            break;
                        }
                    }
                }
                if (start != -1) {
                    break;
                }
            }
            if (start != -1) {
                break;
            }
        }

        System.out.println(start + " " + end);
    }
}


