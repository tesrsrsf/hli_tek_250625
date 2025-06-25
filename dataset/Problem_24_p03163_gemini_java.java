/*
Score : 
100
 points

Problem Statement
There are 
N
 items, numbered 
1, 2, \ldots, N
.
For each 
i
 (
1 \leq i \leq N
), Item 
i
 has a weight of 
w_i
 and a value of 
v_i
.

Taro has decided to choose some of the 
N
 items and carry them home in a knapsack.
The capacity of the knapsack is 
W
, which means that the sum of the weights of items taken must be at most 
W
.

Find the maximum possible sum of the values of items that Taro takes home.

Constraints

All values in input are integers.

1 \leq N \leq 100

1 \leq W \leq 10^5

1 \leq w_i \leq W

1 \leq v_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

W

w_1

v_1

w_2

v_2

:

w_N

v_N

Output
Print the maximum possible sum of the values of items that Taro takes home.

Sample Input 1
3 8
3 30
4 50
5 60

Sample Output 1
90

Items 
1
 and 
3
 should be taken.
Then, the sum of the weights is 
3 + 5 = 8
, and the sum of the values is 
30 + 60 = 90
.

Sample Input 2
5 5
1 1000000000
1 1000000000
1 1000000000
1 1000000000
1 1000000000

Sample Output 2
5000000000

The answer may not fit into a 32-bit integer type.

Sample Input 3
6 15
6 5
5 6
6 4
6 6
3 5
7 2

Sample Output 3
17

Items 
2, 4
 and 
5
 should be taken.
Then, the sum of the weights is 
5 + 6 + 3 = 14
, and the sum of the values is 
6 + 6 + 5 = 17
.
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_24_p03163_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }

            }

        }

        int max_val = 0;
        for (int j = 0; j < w + 1; j++) {
            max_val = Math.max(max_val, dp[n][j]);
        }

        System.out.println(max_val);

        scanner.close();
    }
}


// {annotation: "closed scanner, replaced unnecessary long with int"}