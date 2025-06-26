/*
Score : 
500
 points

Problem Statement
There are 
N
 boxes arranged in a circle. The 
i
-th box contains 
A_i
 stones.

Determine whether it is possible to remove all the stones from the boxes by repeatedly performing the following operation:

Select one box. Let the box be the 
i
-th box. Then, for each 
j
 from 
1
 through 
N
, remove exactly 
j
 stones from the 
(i+j)
-th box. Here, the 
(N+k)
-th box is identified with the 
k
-th box.

Note that the operation cannot be performed if there is a box that does not contain enough number of stones to be removed.

Constraints

1 ≦ N ≦ 10^5

1 ≦ A_i ≦ 10^9

Input
The input is given from Standard Input in the following format:

N

A_1

A_2
 … 
A_N

Output
If it is possible to remove all the stones from the boxes, print 
YES
. Otherwise, print 
NO
.

Sample Input 1
5
4 5 1 2 3

Sample Output 1
YES

All the stones can be removed in one operation by selecting the second box.

Sample Input 2
5
6 9 12 10 8

Sample Output 2
YES

Sample Input 3
4
1 2 3 1

Sample Output 3
NO
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_40_p03808_gpt4_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] a = new long[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            long req = (long)(i + 1) * (n + 1);
            long sum = 0;
            for (int j = 0; j < n; j++) {
                int index = (i + j) % n;
                sum += a[index];
                if (sum < req) {
                    isPossible = false;
                    break;
                }
                req -= (j + 1);
            }
            if (!isPossible) {
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}


// {annotation: "renamed variables for better readability, changed implicit statement to explicit statements"}