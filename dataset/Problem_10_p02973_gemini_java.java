/*
Score : 
500
 points

Problem Statement
You are given a sequence with 
N
 integers: 
A = \{ A_1, A_2, \cdots, A_N \}
.
For each of these 
N
 integers, we will choose a color and paint the integer with that color. Here the following condition must be satisfied:

If 
A_i
 and 
A_j

(i < j)
 are painted with the same color, 
A_i < A_j
.

Find the minimum number of colors required to satisfy the condition.

Constraints

1 \leq N \leq 10^5

0 \leq A_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

A_1

:

A_N

Output
Print the minimum number of colors required to satisfy the condition.

Sample Input 1
5
2
1
4
5
3

Sample Output 1
2

We can satisfy the condition with two colors by, for example, painting 
2
 and 
3
 red and painting 
1
, 
4
, and 
5
 blue.

Sample Input 2
4
0
0
0
0

Sample Output 2
4

We have to paint all the integers with distinct colors.
*/


// =============SOLUTION STARTS HERE==============



import java.util.ArrayList;
import java.util.Scanner;

public class Problem_10_p02973_gemini_java {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            array.add(temp);
        }

        scanner.close();

        ArrayList<Integer> lastPainted = new ArrayList<>();
        int colors = 0;
        for (int num : array) {
            boolean painted = false;
            for (int i = 0; i < lastPainted.size(); i++) {
                if (lastPainted.get(i) < num) {
                    lastPainted.set(i, num);
                    painted = true;
                    break;
                }
            }
            if (painted == false) {
                lastPainted.add(num);
                colors++;
            }
        }
        System.out.println(colors);
    }
}


// {annotation: "redefined some implicit types to explicit types, list to arraylist"}