/*
Score : 
300
 points

Problem Statement
There are 
N+1
 towns. The 
i
-th town is being attacked by 
A_i
 monsters.

We have 
N
 heroes. The 
i
-th hero can defeat monsters attacking the 
i
-th or 
(i+1)
-th town, for a total of at most 
B_i
 monsters.

What is the maximum total number of monsters the heroes can cooperate to defeat?

Constraints

All values in input are integers.

1 \leq N \leq 10^5

1 \leq A_i \leq 10^9

1 \leq B_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

A_1

A_2

...

A_{N+1}

B_1

B_2

...

B_N

Output
Print the maximum total number of monsters the heroes can defeat.

Sample Input 1
2
3 5 2
4 5

Sample Output 1
9

If the heroes choose the monsters to defeat as follows, they can defeat nine monsters in total, which is the maximum result.

The first hero defeats two monsters attacking the first town and two monsters attacking the second town.

The second hero defeats three monsters attacking the second town and two monsters attacking the third town.

Sample Input 2
3
5 6 3 8
5 100 8

Sample Output 2
22

Sample Input 3
2
100 1 1
1 100

Sample Output 3
3
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_23_p02959_gpt4_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] monsNum = new int[n + 1];
        int[] heroNum = new int[n];
        
        for (int i = 0; i < n + 1; i++) {
            monsNum[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            heroNum[i] = scanner.nextInt();
        }
        
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int p1 = heroNum[i];
            if (p1 > monsNum[i]) p1 = monsNum[i];

            int p2 = heroNum[i];
            if (p2 > monsNum[i + 1]) p2 = monsNum[i];

            int defeatMonsters = p1 + p2;

            res += defeatMonsters;
            monsNum[i] = Math.max(0, monsNum[i] - heroNum[i]);
            monsNum[i + 1] = Math.max(0, monsNum[i + 1] - heroNum[i]);
        }
        
        res += monsNum[n]; // defeat last town monsters if left
        
        System.out.println(res);
        scanner.close();
    }
}


// {annotation: "made defeatMonsterss calculation become explicit, also renamed variables for better readability"}