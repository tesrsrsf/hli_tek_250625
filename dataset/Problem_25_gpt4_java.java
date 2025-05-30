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
        long N = scanner.nextLong();
        long k = 1;
        long sum = 0;

        while (true) {
            sum += k;
            if (sum % N == 0) {
                System.out.println(k);
                break;
            }
            k++;
        }
    }
}


