/*
Score : 
600
 points

Problem Statement
Given is an integer 
N
.
Find the minimum possible positive integer 
k
 such that 
(1+2+\cdots+k)
 is a multiple of 
N
.
It can be proved that such a positive integer 
k
 always exists.

Constraints

1 \leq N \leq 10^{15}

All values in input are integers.

Input
Input is given from Standard Input in the following format:

N

Output
Print the answer in a line.

Sample Input 1
11

Sample Output 1
10

1+2+\cdots+10=55
 holds and 
55
 is indeed a multple of 
N=11
.
There are no positive integers 
k \leq 9
 that satisfy the condition, so the answer is 
k = 10
.

Sample Input 2
20200920

Sample Output 2
1100144
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n % 2 == 1) {
            long temp = n;
            for (long k = 1; k <= Math.sqrt(n); k++) {
                if (n % k == 0) {
                    long k1 = k;
                    long k2 = n / k;
                    if ((k1 + 1) / 2 % temp == 0) {
                        System.out.println(k1);
                        return;
                    }
                     if ((k2 + 1) / 2 % temp == 0) {
                        System.out.println(k2);
                        return;
                    }
                }
            }
            System.out.println(n * 2);
        } else {
            if (n % 4 != 0) {
                System.out.println(n);
            } else {
                long temp = n / 2;
               for (long k = 1; k <= Math.sqrt(temp); k++) {
                    if (temp % k == 0) {
                        long k1 = k;
                        long k2 = temp / k;

                        if ((k1 + 1) % (n/2) == 0) {
                            System.out.println(k1 * 2);
                            return;
                        }
                        if ((k2 + 1) % (n/2) == 0) {
                            System.out.println(k2 * 2);
                            return;
                        }
                    }
                }
                System.out.println(n + 1);
            }
        }
    }
}


