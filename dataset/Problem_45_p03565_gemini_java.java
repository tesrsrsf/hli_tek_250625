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



import java.util.Scanner;

public class Problem_45_p03565_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int n = s.length();
        int m = t.length();
        String result = "UNRESTORABLE";

        for (int i = 0; i < n - m + 1; i++) {
            StringBuilder sb = new StringBuilder(s);
            boolean is_possible = true;
            for (int j = 0; j < m; j++) {
                if (sb.charAt(i + j) != '?' && sb.charAt(i + j) != t.charAt(j)) {
                    is_possible = false;
                    break;
                }
            }
            if (is_possible) {
                StringBuilder tempSb = new StringBuilder(s);
                for (int j = 0; j < m; j++) {
                    tempSb.setCharAt(i + j, t.charAt(j));
                }
                for (int j = 0; j < n; j++) {
                    if (tempSb.charAt(j) == '?') {
                        tempSb.setCharAt(j, 'a');
                    }
                }
                
                boolean is_valid = false;
                for(int k = 0; k < n - m + 1; k++){
                    boolean seqFound = true;
                    for(int l = 0; l < m; l++){
                        if(tempSb.charAt(k+l) != t.charAt(l)){
                            seqFound = false;
                            break;
                        }
                    }
                    if(seqFound){
                        is_valid = true;
                        break;
                    }
                }
                if(is_valid){
                   if (result.equals("UNRESTORABLE") || tempSb.toString().compareTo(result) < 0) {
                       result = tempSb.toString();
                   }
                }
            }
        }

        System.out.println(result);
        scanner.close();
    }
}


// {annotation: "removed unnecessary comments and cleaned up the code for clarity, renamed variables in my style"}