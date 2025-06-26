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



import java.util.*;

public class Problem_32_p03832_gpt4_java {
    static final int MOD = 1000000007;
    
    static long comb(int n, int k) {
        if (k > n || k < 0) {
            return 0;
        }
        long num = 1, denom = 1;
        for (int i = 0; i < k; i++) {
            num = (num * (n - i)) % MOD;
            denom = (denom * (i + 1)) % MOD;
        }
        return (num * modInverse(denom)) % MOD;
    }


    static long modInverse(long a) {
        return pow(a, MOD - 2);
    }


    static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.close();

        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;

        for (int people = 1; people < n + 1; people++) {
            for (int groups = 1; groups < people + 1; groups++) {
                for (int size = a; size < b + 1; size++) {
                    if (people >= size) {
                        for (int f = c; f < d + 1; f++) {
                            if (groups > f) {
                                continue;
                            }
                            
                            dp[people][groups] = (dp[people][groups] + (dp[people - size][groups - 1] * comb(groups - 1, f - 1)) % MOD) % MOD;
                        }
                    }
                }
            }
        }

        long res = 0;
        for (int groups = c; groups < d + 1; groups++) {
            res = (res + dp[n][groups]) % MOD;
        }

        System.out.println(res);
    }
}


// {annotation: "moved tool functions to the top for better readability, avoiding use of capital letters in variables, refactored the program to fit my style"}