/*
Score: 
400
 points

Problem Statement

AtCoder Inc. has decided to lock the door of its office with a 
3
-digit PIN code.

The company has an 
N
-digit lucky number, 
S
. Takahashi, the president, will erase 
N-3
 digits from 
S
 and concatenate the remaining 
3
 digits without changing the order to set the PIN code.

How many different PIN codes can he set this way?

Both the lucky number and the PIN code may begin with a 
0
.

Constraints

4 \leq N \leq 30000

S
 is a string of length 
N
 consisting of digits.

Input

Input is given from Standard Input in the following format:

N

S

Output

Print the number of different PIN codes Takahashi can set.

Sample Input 1
4
0224

Sample Output 1
3

Takahashi has the following options:

Erase the first digit of 
S
 and set 
224
.

Erase the second digit of 
S
 and set 
024
.

Erase the third digit of 
S
 and set 
024
.

Erase the fourth digit of 
S
 and set 
022
.

Thus, he can set three different PIN codes: 
022
, 
024
, and 
224
.

Sample Input 2
6
123123

Sample Output 2
17

Sample Input 3
19
3141592653589793238

Sample Output 3
329
*/


// =============SOLUTION STARTS HERE==============



import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String S = scanner.next();
        HashSet<String> pinCodes = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    String pinCode = "" + S.charAt(i) + S.charAt(j) + S.charAt(k);
                    pinCodes.add(pinCode);
                }
            }
        }

        System.out.println(pinCodes.size());
    }
}


