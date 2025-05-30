/*
Score: 
300
 points

Problem Statement

Consider an analog clock whose hour and minute hands are 
A
 and 
B
 centimeters long, respectively.

An endpoint of the hour hand and an endpoint of the minute hand are fixed at the same point, around which each hand rotates clockwise at constant angular velocity. It takes the hour and minute hands 
12
 hours and 
1
 hour to make one full rotation, respectively.

At 
0
 o'clock, the two hands overlap each other. 
H
 hours and 
M
 minutes later, what is the distance in centimeters between the unfixed endpoints of the hands?

Constraints

All values in input are integers.

1 \leq A, B \leq 1000

0 \leq H \leq 11

0 \leq M \leq 59

Input

Input is given from Standard Input in the following format:

A

B

H

M

Output

Print the answer without units. Your output will be accepted when its absolute or relative error from the correct value is at most 
10^{-9}
.

Sample Input 1
3 4 9 0

Sample Output 1
5.00000000000000000000

The two hands will be in the positions shown in the figure below, so the answer is 
5
 centimeters.

Sample Input 2
3 4 10 40

Sample Output 2
4.56425719433005567605

The two hands will be in the positions shown in the figure below. Note that each hand always rotates at constant angular velocity.
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        int H = scanner.nextInt();
        int M = scanner.nextInt();

        double hourAngle = ((H % 12 + (double)M / 60) / 12) * 2 * Math.PI;
        double minuteAngle = (M / 60.0) * 2 * Math.PI;

        double angleDiff = Math.abs(hourAngle - minuteAngle);
        angleDiff = Math.min(angleDiff, 2 * Math.PI - angleDiff);

        double distance = Math.sqrt(A*A + B*B - 2 * A * B * Math.cos(angleDiff));
        System.out.println(distance);
    }
}


