/*
Score : 
600
 points

Problem Statement
Nagase is a top student in high school. One day, she's analyzing some properties of special sets of positive integers.  

She thinks that a set 
S = \{a_{1}, a_{2}, ..., a_{N}\}
 of 
distinct
 positive integers is called 
special
 if for all 
1 \leq i \leq N
, the gcd (greatest common divisor) of 
a_{i}
 and the sum of the remaining elements of 
S
 is 
not

1
.

Nagase wants to find a 
special
 set of size 
N
. However, this task is too easy, so she decided to ramp up the difficulty. Nagase challenges you to find a 
special
 set of size 
N
 such that the gcd of all elements are 
1
 and the elements of the set does not exceed 
30000
.

Constraints

3 \leq N \leq 20000

Input
Input is given from Standard Input in the following format:

N

Output
Output 
N
 space-separated integers, denoting the elements of the set 
S
. 
S
 must satisfy the following conditions :

The elements must be 
distinct
 positive integers not exceeding 
30000
.

The gcd of all elements of 
S
 is 
1
, i.e. there does not exist an integer 
d > 1
 that divides all elements of 
S
.

S
 is a 
special
 set.

If there are multiple solutions, you may output any of them. The elements of 
S
 may be printed in any order. It is guaranteed that at least one solution exist under the given contraints.

Sample Input 1
3

Sample Output 1
2 5 63

\{2, 5, 63\}
 is special because 
gcd(2, 5 + 63) = 2, gcd(5, 2 + 63) = 5, gcd(63, 2 + 5) = 7
. Also, 
gcd(2, 5, 63) = 1
. Thus, this set satisfies all the criteria.

Note that 
\{2, 4, 6\}
 is not a valid solution because 
gcd(2, 4, 6) = 2 > 1
.

Sample Input 2
4

Sample Output 2
2 5 20 63

\{2, 5, 20, 63\}
 is special because 
gcd(2, 5 + 20 + 63) = 2, gcd(5, 2 + 20 + 63) = 5, gcd(20, 2 + 5 + 63) = 10, gcd(63, 2 + 5 + 20) = 9
. Also, 
gcd(2, 5, 20, 63) = 1
. Thus, this set satisfies all the criteria.
*/


// =============SOLUTION STARTS HERE==============



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static boolean isSpecial(List<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            int sum = 0;
            for (int j = 0; j < set.size(); j++) {
                if (i != j) {
                    sum += set.get(j);
                }
            }
            if (gcd(set.get(i), sum) == 1) {
                return false;
            }
        }
        return true;
    }

    public static int gcdOfSet(List<Integer> set) {
        int result = set.get(0);
        for (int i = 1; i < set.size(); i++) {
            result = gcd(result, set.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> set = new ArrayList<>();
        if (n == 3) {
            set.add(2);
            set.add(5);
            set.add(63);
        } else if (n == 4) {
            set.add(2);
            set.add(5);
            set.add(20);
            set.add(63);
        }
        else {
            set.add(2);
            set.add(5);
            int current = 63;
            for (int i = 3; i < n; i++) {
                set.add(current);
                current +=1;
            }

        }

        
        
        for (int i = 0; i < set.size(); i++) {
            System.out.print(set.get(i) + " ");
        }
        System.out.println();
    }
}


