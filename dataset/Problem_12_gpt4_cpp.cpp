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



#include <iostream>
#include <cmath>

int main() {
    double A, B;
    int H, M;
    std::cin >> A >> B >> H >> M;

    // Total minutes from 0 o'clock
    double totalMinutes = H * 60 + M;

    // Angle of hour hand (degrees)
    double hourAngle = (360.0 / 12) * (totalMinutes / 60);
    // Angle of minute hand (degrees)
    double minuteAngle = (360.0 / 60) * totalMinutes;

    // Convert angles to radians
    double hourRad = hourAngle * M_PI / 180.0;
    double minuteRad = minuteAngle * M_PI / 180.0;

    // Get the coordinates of the endpoints of both hands
    double xHour = A * cos(hourRad);
    double yHour = A * sin(hourRad);
    double xMinute = B * cos(minuteRad);
    double yMinute = B * sin(minuteRad);

    // Calculate the distance between the two endpoints
    double distance = sqrt(pow(xHour - xMinute, 2) + pow(yHour - yMinute, 2));

    // Output the result with required precision
    std::cout.precision(20);
    std::cout << distance << std::endl;

    return 0;
}


