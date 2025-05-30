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
import sys

# Read input
A = int(sys.stdin.readline().strip())
B = int(sys.stdin.readline().strip())
H = int(sys.stdin.readline().strip())
M = int(sys.stdin.readline().strip())

# Calculate angles
total_minutes = H * 60 + M

# Angle moved by the hour hand (360 degrees = 12 hours = 720 minutes)
hour_angle = (total_minutes / 720) * 360

# Angle moved by the minute hand (360 degrees = 1 hour = 60 minutes)
minute_angle = (total_minutes / 60) * 360

# Convert angles to radians
hour_angle_rad = math.radians(hour_angle)
minute_angle_rad = math.radians(minute_angle)

# Calculate the position of the tips of the hands
x_hour = A * math.cos(hour_angle_rad)
y_hour = A * math.sin(hour_angle_rad)

x_minute = B * math.cos(minute_angle_rad)
y_minute = B * math.sin(minute_angle_rad)

# Calculate the distance between the two tips
distance = math.sqrt((x_hour - x_minute) ** 2 + (y_hour - y_minute) ** 2)

# Print the result
print(f"{distance:.20f}")


