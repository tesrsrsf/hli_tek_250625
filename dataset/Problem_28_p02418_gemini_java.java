/*
Ring

  Write a program which finds a pattern $p$ in a ring shaped text $s$.

Input

  In the first line, the text $s$ is given.

  In the second line, the pattern $p$ is given.

Output

  If $p$ is in $s$, print 
Yes
 in a line, otherwise 
No
.

Constraints

$1 \leq $ length of $p \leq $ length of $s \leq 100$

$s$ and $p$ consists of lower-case letters

Sample Input 1

vanceknowledgetoad
advance

Sample Output 1

Yes

Sample Input 2

vanceknowledgetoad
advanced

Sample Output 2

No
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

class Problem_28_p02418_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();

        boolean is_found = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() < p.length()) {
                break;
            }

            if (i + p.length() <= s.length()) {
                if (s.substring(i, i + p.length()).equals(p)) {
                    is_found = true;
                    break;
                }
            }

            if(i + p.length() > s.length()){
                String rotaS = s.substring(i) + s.substring(0, i);
                if(rotaS.length() < p.length()) break;
                if (rotaS.substring(0, p.length()).equals(p)) {
                    is_found = true;
                    break;
                }
            }
        }

        if (is_found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}


// {annotation: "closed scanner, renamed variables to fit my style"}