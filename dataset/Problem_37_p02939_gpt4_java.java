/*
Score : 
300
 points

Problem Statement
Given is a string 
S
 consisting of lowercase English letters. Find the maximum positive integer 
K
 that satisfies the following condition:

There exists a partition of 
S
 into 
K
 non-empty strings 
S=S_1S_2...S_K
 such that 
S_i \neq S_{i+1}
 (
1 \leq i \leq K-1
).

Here 
S_1S_2...S_K
 represents the concatenation of 
S_1,S_2,...,S_K
 in this order.

Constraints

1 \leq |S| \leq 2 \times 10^5

S
 consists of lowercase English letters.

Input
Input is given from Standard Input in the following format:

S

Output
Print the maximum positive integer 
K
 that satisfies the condition.

Sample Input 1
aabbaa

Sample Output 1
4

We can, for example, divide 
S
 into four strings 
aa
, 
b
, 
ba
, and 
a
.

Sample Input 2
aaaccacabaababc

Sample Output 2
12
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Problem_37_p02939_gpt4_java {
    public static int deepseek(String S) {
        int count = 1;
        char pre_char = S.charAt(0);
        
        for (int i = 1; i < S.length(); i++) {
            char cur_char = S.charAt(i);
            if (cur_char != pre_char) {
                count++;
                pre_char = cur_char;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();

        int k = deepseek(S);

        System.out.println(k + 1);

        scanner.close();
    }
}


// {annotation: "renamed some variables to fit my style, moved main method to the top, improved readability"}