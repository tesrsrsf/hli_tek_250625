/*
Score : 
300
 points

Problem Statement
Tak has 
N
 cards. On the 
i
-th 
(1 \leq i \leq N)
 card is written an integer 
x_i
.
He is selecting one or more cards from these 
N
 cards, so that the average of the integers written on the selected cards is exactly 
A
.
In how many ways can he make his selection?

Constraints

1 \leq N \leq 50

1 \leq A \leq 50

1 \leq x_i \leq 50

N,\,A,\,x_i
 are integers.

Partial Score

200
 points will be awarded for passing the test set satisfying 
1 \leq N \leq 16
.

Input
The input is given from Standard Input in the following format:

N

A

x_1

x_2

...

x_N

Output
Print the number of ways to select cards such that the average of the written integers is exactly 
A
.

Sample Input 1
4 8
7 9 8 9

Sample Output 1
5

The following are the 
5
 ways to select cards such that the average is 
8
:

Select the 
3
-rd card.

Select the 
1
-st and 
2
-nd cards.

Select the 
1
-st and 
4
-th cards.

Select the 
1
-st, 
2
-nd and 
3
-rd cards.

Select the 
1
-st, 
3
-rd and 
4
-th cards.

Sample Input 2
3 8
6 6 9

Sample Output 2
0

Sample Input 3
8 5
3 6 2 8 7 6 5 9

Sample Output 3
19

Sample Input 4
33 3
3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3

Sample Output 4
8589934591

The answer may not fit into a 
32
-bit integer.
*/


// =============SOLUTION STARTS HERE==============



import java.util.*;

public class Main {
    static long countWays(int[] cards, int target, int n) {
        long[][] dp = new long[n + 1][target * n + 1];
        dp[0][0] = 1; // There's one way to pick nothing (0 cards) to get sum 0.

        for (int i = 1; i <= n; i++) {
            int cardValue = cards[i - 1];
            for (int j = i; j >= 1; j--) {
                for (int k = cardValue; k <= target * j; k++) {
                    dp[j][k] += dp[j - 1][k - cardValue];
                }
            }
        }

        long ways = 0;
        for (int j = 1; j <= n; j++) {
            if (j * target <= target * n) {
                ways += dp[j][j * target];
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        long result = countWays(cards, A, N);
        System.out.println(result);
    }
}


