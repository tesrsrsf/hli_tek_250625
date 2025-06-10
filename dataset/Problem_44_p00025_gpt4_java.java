/*
Hit and Blow

Let's play Hit and Blow game. 
A
 imagines four numbers and 
B
 guesses the numbers. After 
B
 picks out four numbers, 
A
 answers:

 The number of numbers which have the same place with numbers 
A
 imagined (Hit) 

 The number of numbers included (but different place) in the numbers 
A
 imagined (Blow)

For example, if 
A
 imagined numbers:

9 1 8 2

and 
B
 chose:

4 1 5 9

A
 should say 1 Hit and 1 Blow.

Write a program which reads four numbers 
A
 imagined and four numbers 
B
 chose and prints the number of Hit and Blow respectively. You may assume that the four numbers are all different and within from 0 to 9.

Input

The input consists of multiple datasets. Each dataset set consists of:

a
1

a
2

a
3

a
4

b
1

b
2

b
3

b
4

, where 
a
i
 (0 ≤ 
a
i
 ≤ 9) is 
i
-th number 
A
  imagined and 
b
i
 (0 ≤ 
b
i
 ≤ 9) is 
i
-th number 
B
 chose.

The input ends with EOF. The number of datasets is less than or equal to 50.

Output

For each dataset, print the number of Hit and Blow in a line. These two numbers should be separated by a space.

Sample Input

9 1 8 2
4 1 5 9
4 6 8 2
4 6 3 2

Output for the Sample Input

1 1
3 0
*/


// =============SOLUTION STARTS HERE==============



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String[] aNumbers = scanner.nextLine().split(" ");
            String[] bNumbers = scanner.nextLine().split(" ");

            int hits = 0;
            int blows = 0;
            boolean[] aUsed = new boolean[4];
            boolean[] bUsed = new boolean[4];
            
            // Calculate hits
            for (int i = 0; i < 4; i++) {
                if (aNumbers[i].equals(bNumbers[i])) {
                    hits++;
                    aUsed[i] = true;
                    bUsed[i] = true;
                }
            }

            // Calculate blows
            for (int i = 0; i < 4; i++) {
                if (!aUsed[i]) {
                    for (int j = 0; j < 4; j++) {
                        if (!bUsed[j] && aNumbers[i].equals(bNumbers[j])) {
                            blows++;
                            bUsed[j] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println(hits + " " + blows);
        }
        
        scanner.close();
    }
}


