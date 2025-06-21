/*
Score : 
700
 points

Problem Statement
You have an integer sequence of length 
N
: 
a_1, a_2, ..., a_N
.

You repeatedly perform the following operation until the length of the sequence becomes 
1
:

First, choose an element of the sequence.

If that element is at either end of the sequence, delete the element.

If that element is not at either end of the sequence, replace the element with the sum of the two elements that are adjacent to it. Then, delete those two elements.

You would like to maximize the final element that remains in the sequence.

Find the maximum possible value of the final element, and the way to achieve it.

Constraints

All input values are integers.

2 \leq N \leq 1000

|a_i| \leq 10^9

Input
Input is given from Standard Input in the following format:

N

a_1

a_2

...

a_N

Output

In the first line, print the maximum possible value of the final element in the sequence.

In the second line, print the number of operations that you perform.

In the 
(2+i)
-th line, if the element chosen in the 
i
-th operation is the 
x
-th element from the left in the sequence at that moment, print 
x
.

If there are multiple ways to achieve the maximum value of the final element, any of them may be printed.

Sample Input 1
5
1 4 3 7 5

Sample Output 1
11
3
1
4
2

The sequence would change as follows:

After the first operation: 
4, 3, 7, 5

After the second operation: 
4, 3, 7

After the third operation: 
11(4+7)

Sample Input 2
4
100 100 -1 100

Sample Output 2
200
2
3
1

After the first operation: 
100, 200(100+100)

After the second operation: 
200

Sample Input 3
6
-1 -2 -3 1 2 3

Sample Output 3
4
3
2
1
2

After the first operation: 
-4, 1, 2, 3

After the second operation: 
1, 2, 3

After the third operation: 
4

Sample Input 4
9
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000

Sample Output 4
5000000000
4
2
2
2
2
*/


// =============SOLUTION STARTS HERE==============



import java.util.*;

public class Problem_03_p03413_gpt4_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        scanner.nextLine(); // Consume the newline character
        String nums_str = scanner.nextLine();
        String[] nums = nums_str.split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }

        scanner.close();

        List<Integer> operations = new ArrayList<>();
        while (N > 1) {
            // Perform operation on the best index
            int bestIndex = 0;
            long bestValue = a[0];
            for (int i = 0; i < N; i++) {
                if (i > 0 && i < N - 1) {
                    long currentValue = a[i - 1] + a[i + 1];
                    if (currentValue > bestValue) {
                        bestValue = currentValue;
                        bestIndex = i;
                    }
                }
            }

            // Now bestIndex contains the index of the element we will operate on
            if (bestIndex == 0 || bestIndex == N - 1) {
                // If it's at the ends, directly remove it
                operations.add(1 + bestIndex); // 1-based index
                if (bestIndex == 0) {
                    System.arraycopy(a, 1, a, 0, N - 1);
                }
            } else {
                // Replace a[bestIndex] with the sum of its neighbors and remove them
                operations.add(bestIndex + 1); // 1-based index
                a[bestIndex] = a[bestIndex - 1] + a[bestIndex + 1];
                // Shift elements left
                for (int j = bestIndex + 1; j < N - 1; j++) {
                    a[j] = a[j + 1];
                }
                N--;
            }
        }

        System.out.println(a[0]);
        System.out.println(operations.size());
        for (int op : operations) {
            System.out.println(op);
        }
    }
}


// {annotation: "this program will lead to an infinite loop, I don't think I can fix it, but I replaced the input with my way. "}