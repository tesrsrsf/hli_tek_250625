'''
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
'''


# =============SOLUTION STARTS HERE==============



import math

A = int(input())
B = int(input())
H = int(input())
M = int(input())

hour_angle = ((H % 12) + (M / 60)) * 30
minute_angle = M * 6

angle_diff = hour_angle - minute_angle
if angle_diff < 0:
    angle_diff = -angle_diff

angle_rad = math.radians(angle_diff)

p1 = A * A
p2 = B * B
p3 = 2 * A * B * math.cos(angle_rad)
res = math.sqrt(p1 + p2 - p3)

print(res)


# {annotation: "made the program more explicit by replacing abstract formula with calculations, also divided the formula calculation to several parts for better understanding"}