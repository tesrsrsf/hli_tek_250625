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

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int startBox = 0; startBox < N; startBox++) {
            int[] tempA = new int[N];
            System.arraycopy(A, 0, tempA, 0, N);
            boolean possible = true;
            for (int j = 1; j <= N; j++) {
                int boxIndex = (startBox + j) % N;
                if (tempA[boxIndex] < j) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                for (int j = 1; j <= N; j++) {
                    int boxIndex = (startBox + j) % N;
                    tempA[boxIndex] -= j;
                }
                boolean allZero = true;
                for (int i = 0; i < N; i++) {
                    if (tempA[i] != 0) {
                        allZero = false;
                        break;
                    }
                }
                if (allZero) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}


