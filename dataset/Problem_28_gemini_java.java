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

class Ring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() < p.length()) break;
            if (i + p.length() <= s.length()) {
                if (s.substring(i, i + p.length()).equals(p)) {
                    found = true;
                    break;
                }
            }

            if(i + p.length() > s.length()){
                String rotatedS = s.substring(i) + s.substring(0,i);
                if(rotatedS.length() < p.length()) break;
                if (rotatedS.substring(0, p.length()).equals(p)) {
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


