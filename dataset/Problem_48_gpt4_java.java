/*
﻿Score : 
400
 points

Problem Statement
In the year 2168, AtCoder Inc., which is much larger than now, is starting a limited express train service called 
AtCoder Express
.

In the plan developed by the president Takahashi, the trains will run as follows:

A train will run for 
(t_1 + t_2 + t_3 + ... + t_N)
 seconds.

In the first 
t_1
 seconds, a train must run at a speed of at most 
v_1
 m/s (meters per second). Similarly, in the subsequent 
t_2
 seconds, a train must run at a speed of at most 
v_2
 m/s, and so on.

According to the specifications of the trains, the acceleration of a train must be always within 
±1m/s^2
. Additionally, a train must stop at the beginning and the end of the run.

Find the maximum possible distance that a train can cover in the run.

Constraints

1 \leq N \leq 100

1 \leq t_i \leq 200

1 \leq v_i \leq 100

All input values are integers.

Input
Input is given from Standard Input in the following format:

N

t_1

t_2

t_3
 … 
t_N

v_1

v_2

v_3
 … 
v_N

Output
Print the maximum possible that a train can cover in the run.

Output is considered correct if its absolute difference from the judge's output is at most 
10^{-3}
.

Sample Input 1
1
100
30

Sample Output 1
2100.000000000000000

The maximum distance is achieved when a train runs as follows:

In the first 
30
 seconds, it accelerates at a rate of 
1m/s^2
, covering 
450
 meters.

In the subsequent 
40
 seconds, it maintains the velocity of 
30m/s
, covering 
1200
 meters.

In the last 
30
 seconds, it decelerates at the acceleration of 
-1m/s^2
, covering 
450
 meters.

The total distance covered is 
450
 + 
1200
 + 
450
 = 
2100
 meters.

Sample Input 2
2
60 50
34 38

Sample Output 2
2632.000000000000000

The maximum distance is achieved when a train runs as follows:

In the first 
34
 seconds, it accelerates at a rate of 
1m/s^2
, covering 
578
 meters.

In the subsequent 
26
 seconds, it maintains the velocity of 
34m/s
, covering 
884
 meters.

In the subsequent 
4
 seconds, it accelerates at a rate of 
1m/s^2
, covering 
144
 meters.

In the subsequent 
8
 seconds, it maintains the velocity of 
38m/s
, covering 
304
 meters.

In the last 
38
 seconds, it decelerates at the acceleration of 
-1m/s^2
, covering 
722
 meters.

The total distance covered is 
578
 + 
884
 + 
144
 + 
304
 + 
722
 = 
2632
 meters.

Sample Input 3
3
12 14 2
6 2 7

Sample Output 3
76.000000000000000

The maximum distance is achieved when a train runs as follows:

In the first 
6
 seconds, it accelerates at a rate of 
1m/s^2
, covering 
18
 meters.

In the subsequent 
2
 seconds, it maintains the velocity of 
6m/s
, covering 
12
 meters.

In the subsequent 
4
 seconds, it decelerates at the acceleration of 
-1m/s^2
, covering 
16
 meters.

In the subsequent 
14
 seconds, it maintains the velocity of 
2m/s
, covering 
28
 meters.

In the last 
2
 seconds, it decelerates at the acceleration of 
-1m/s^2
, covering 
2
 meters.

The total distance covered is 
18
 + 
12
 + 
16
 + 
28
 + 
2
 = 
76
 meters.

Sample Input 4
1
9
10

Sample Output 4
20.250000000000000000

The maximum distance is achieved when a train runs as follows:

In the first 
4.5
 seconds, it accelerates at a rate of 
1m/s^2
, covering 
10.125
 meters.

In the last 
4.5
 seconds, it decelerates at the acceleration of 
-1m/s^2
, covering 
10.125
 meters.

The total distance covered is 
10.125
 + 
10.125
 = 
20.25
 meters.

Sample Input 5
10
64 55 27 35 76 119 7 18 49 100
29 19 31 39 27 48 41 87 55 70

Sample Output 5
20291.000000000000
*/


// =============SOLUTION STARTS HERE==============



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        double[] t = new double[N];
        double[] v = new double[N];

        for (int i = 0; i < N; i++) {
            t[i] = scanner.nextDouble();
        }
        for (int i = 0; i < N; i++) {
            v[i] = scanner.nextDouble();
        }
        
        double totalDistance = 0.0;

        for (int i = 0; i < N; i++) {
            double time = t[i];
            double maxSpeed = v[i];
            
            // The potential maximum speed during the segment
            double initialSpeed = (i == 0) ? 0 : v[i - 1];
            
            // Here we calculate the segments of acceleration, constant speed, and deceleration
            // Accelerate up to the speed limit
            double accelerationTime = Math.min(time, (maxSpeed - initialSpeed));
            double distanceAccelerate = (initialSpeed * accelerationTime) + (0.5 * accelerationTime * accelerationTime);
            time -= accelerationTime;
            initialSpeed += accelerationTime;

            // Maintain constant speed if there's time left
            double distanceConstant = 0;
            if (time > 0) {
                distanceConstant = initialSpeed * time;
                time = 0;
            }
            initialSpeed = maxSpeed; // speed at the end of constant speed phase

            // Decelerate to stop
            double decelerationTime = Math.min(maxSpeed, (initialSpeed));
            double distanceDecelerate = (initialSpeed * decelerationTime) - (0.5 * decelerationTime * decelerationTime);
            time -= decelerationTime;

            totalDistance += distanceAccelerate + distanceConstant + distanceDecelerate;
        }
        
        System.out.printf("%.12f\n", totalDistance);
        scanner.close();
    }
}


