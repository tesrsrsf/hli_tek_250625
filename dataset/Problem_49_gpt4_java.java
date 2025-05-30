/*
Score : 
300
 points

Problem Statement
There are 
N
 boxes arranged in a row.
Initially, the 
i
-th box from the left contains 
a_i
 candies.

Snuke can perform the following operation any number of times:

Choose a box containing at least one candy, and eat one of the candies in the chosen box.

His objective is as follows:

Any two neighboring boxes contain at most 
x
 candies in total.

Find the minimum number of operations required to achieve the objective.

Constraints

2 ≤ N ≤ 10^5

0 ≤ a_i ≤ 10^9

0 ≤ x ≤ 10^9

Input
The input is given from Standard Input in the following format:

N

x

a_1

a_2

...

a_N

Output
Print the minimum number of operations required to achieve the objective.

Sample Input 1
3 3
2 2 2

Sample Output 1
1

Eat one candy in the second box.
Then, the number of candies in each box becomes 
(2, 1, 2)
.

Sample Input 2
6 1
1 6 1 2 0 4

Sample Output 2
11

For example, eat six candies in the second box, two in the fourth box, and three in the sixth box.
Then, the number of candies in each box becomes 
(1, 0, 1, 0, 0, 1)
.

Sample Input 3
5 9
3 1 4 1 5

Sample Output 3
0

The objective is already achieved without performing operations.

Sample Input 4
2 0
5 5

Sample Output 4
10

All the candies need to be eaten.
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long x = scanner.nextLong();
        
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextLong();
        }

        long operations = 0;

        for (int i = 0; i < N - 1; i++) {
            long total = a[i] + a[i + 1];
            if (total > x) {
                long excess = total - x;
                operations += excess;
                // Adjust the next box to reflect the candies eaten
                a[i + 1] -= excess;
                if (a[i + 1] < 0) {
                    a[i + 1] = 0;
                }
            }
        }

        System.out.println(operations);
    }
}


