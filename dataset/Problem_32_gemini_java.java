/*
Score : 
600
 points

Problem Statement
There are 
N
 people, conveniently numbered 
1
 through 
N
.
We want to divide them into some number of groups, under the following two conditions:

Every group contains between 
A
 and 
B
 people, inclusive.

Let 
F_i
 be the number of the groups containing exactly 
i
 people. Then, for all 
i
, either 
F_i=0
 or 
C≤F_i≤D
 holds.

Find the number of these ways to divide the people into groups.
Here, two ways to divide them into groups is considered different if and only if there exists two people such that they belong to the same group in exactly one of the two ways.
Since the number of these ways can be extremely large, print the count modulo 
10^9+7
.

Constraints

1≤N≤10^3

1≤A≤B≤N

1≤C≤D≤N

Input
The input is given from Standard Input in the following format:

N

A

B

C

D

Output
Print the number of ways to divide the people into groups under the conditions, modulo 
10^9+7
.

Sample Input 1
3 1 3 1 2

Sample Output 1
4

There are four ways to divide the people:

(1,2),(3)

(1,3),(2)

(2,3),(1)

(1,2,3)

The following way to divide the people does not count: 
(1),(2),(3)
. This is because it only satisfies the first condition and not the second.

Sample Input 2
7 2 3 1 3

Sample Output 2
105

The only ways to divide the people under the conditions are the ones where there are two groups of two people, and one group of three people.
There are 
105
 such ways.

Sample Input 3
1000 1 1000 1 1000

Sample Output 3
465231251

Sample Input 4
10 3 4 2 5

Sample Output 4
0

The answer can be 
0
.
*/


// =============SOLUTION STARTS HERE==============



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int MOD = 1000000007;

    private static long[][] combinations(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.close();

        long[][] comb = combinations(n, n);
        long ans = 0;

        for (int groupsA = 0; groupsA <= n / a; groupsA++) {
            for (int groupsB = 0; groupsB <= n / b; groupsB++) {
                if (groupsA * a + groupsB * b > n) continue;
                for (int i = a; i <= b; i++) {
                    for (int f = 0; f <= n; f++) {
                        if (f < 0) continue;
                        if (i * f > n) break;
                        int remaining = n - i * f;

                        if (f != 0 && (f < c || f > d)) {
                            continue;
                        }
                        if (f == 0) {
                            continue;
                        }

                        long ways = 0;
                        if (remaining == 0) {
                            ways = 1;
                        }
                        else {
                            for (int groupsSize = a; groupsSize <= b; groupsSize++) {
                                if(groupsSize * (n - i*f)/(groupsSize) < n - i*f) continue;
                                if(groupsSize > n -i *f) continue;
                                if((n - i * f) % groupsSize != 0) continue;
                                if(groupsSize * (n - i*f)/groupsSize != n-i*f) continue;

                                long numGroups = (n - i * f) /groupsSize;

                                if (numGroups < c || numGroups > d) continue;
                                long tempWays = 1;

                                tempWays = (tempWays * comb[n][i * f]) % MOD;
                                n -= i*f;
                                for(int x = 0; x <f; x++){
                                    long combValue = 1;
                                    if(i <= n){
                                        combValue = comb[n][i];
                                    }else {
                                        combValue = 0;
                                    }

                                    tempWays = (tempWays * combValue) % MOD;
                                    n -=i;
                                }
                                

                                ans = (ans + tempWays) % MOD;
                                n +=i*f;

                                break;
                            }
                        }
                        
                    }

                }
            }
        }
        System.out.println(ans);
    }
}


