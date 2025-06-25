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

public class Problem_28_p02418_gpt4_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();

        scanner.close();

        String temp_str = s + s;

        if (temp_str.contains(p)) { // if subseq p in temp_str
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


// {annotation: "added comment for clarity, also reformatted code for better readability"}