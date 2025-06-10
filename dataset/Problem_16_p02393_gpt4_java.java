/*
Sorting Three Numbers

  Write a program which reads three integers, and prints them in ascending order.

Input

  Three integers separated by a single space are given in a line.

Output

  Print the given integers in ascending order in a line. Put a single space between two integers.

Constraints

 1 ≤ the three integers ≤ 10000

Sample Input 1

3 8 1

Sample Output 1

1 3 8
*/


// =============SOLUTION STARTS HERE==============



import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        
        for (int i = 0; i < 3; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        Arrays.sort(numbers);
        
        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }
}


