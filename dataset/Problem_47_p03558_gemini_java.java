/*
Score : 
700
 points

Problem Statement
Find the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Constraints

2 \leq K \leq 10^5

K
 is an integer.

Input
Input is given from Standard Input in the following format:

K

Output
Print the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Sample Input 1
6

Sample Output 1
3

12=6×2
 yields the smallest sum.

Sample Input 2
41

Sample Output 2
5

11111=41×271
 yields the smallest sum.

Sample Input 3
79992

Sample Output 3
36
*/


// =============SOLUTION STARTS HERE==============



import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

class Problem_47_p03558_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int[] dist = new int[k];
        Arrays.fill(dist, -1);
        LinkedList<Integer> q = new LinkedList<>();

        dist[0] = 0;
        q.offer(0);

        while (!q.isEmpty()) {
            int rem = q.poll();
            for (int digit = 0; digit <= 9; digit++) {
                int nextRem = (rem * 10 + digit) % k;
                if (dist[nextRem] == -1) {
                    dist[nextRem] = dist[rem] + digit;
                    q.offer(nextRem);
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < k; i++) {
            if (dist[i] != -1) {
                minSum = Math.min(minSum, dist[i]);
            }
        }

        System.out.println(minSum + 1);

        scanner.close();
    }
}


// {annotation: "renamed variables and reformatted structures in my style"}