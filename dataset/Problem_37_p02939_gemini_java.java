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

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int maxK = 0;

        for (int k = 1; k <= n; k++) {
            if (canPartition(s, k)) {
                maxK = k;
            }
        }

        System.out.println(maxK);
    }

    private static boolean canPartition(String s, int k) {
        if (k == 1) {
            return true;
        }
        if (k > s.length()) {
            return false;
        }

        int[] partitionPoints = new int[k - 1];
        return canPartitionHelper(s, k, partitionPoints, 0, 0);
    }

    private static boolean canPartitionHelper(String s, int k, int[] partitionPoints, int index, int start) {
        if (index == k - 1) {
            if (start < s.length()) {
                if (s.substring(partitionPoints[k - 2] + 1, s.length()).equals(s.substring(0, 0))) {
                  
                    return false;
                }
                return true;
            } else {
                return false;
            }
            
        }

        for (int i = start; i < s.length() - (k - 1 - index); i++) {
            partitionPoints[index] = i;

            if (index == 0) {
                if (canPartitionHelper(s, k, partitionPoints, index + 1, i + 1)) {
                    if (k == 2) {
                        if(!s.substring(0, partitionPoints[0] + 1).equals(s.substring(partitionPoints[0] + 1, s.length()))){
                            return true;
                        }
                        else{
                            continue;
                        }

                    }
                   
                  
                    if (!s.substring(0, partitionPoints[0] + 1).equals(s.substring(partitionPoints[0] + 1, partitionPoints[1] + 1))) {
                        return true;
                    }


                }
            } else {
                if (index > 0 && index < k-1) {
                  
                        if(canPartitionHelper(s,k,partitionPoints,index+1,i+1))
                        {
                            if(index == 1){
                                if(!s.substring(partitionPoints[0]+1,partitionPoints[1]+1).equals(s.substring(partitionPoints[1]+1,s.length()))){
                                    return true;
                                }
                                else{
                                    continue;
                                }

                            }
                            if(!s.substring(partitionPoints[index-1]+1,partitionPoints[index]+1).equals(s.substring(partitionPoints[index]+1,partitionPoints[index+1]+1))){
                                return true;
                            }

                        }

                    }
            }
            }
            return false;
        }
}


