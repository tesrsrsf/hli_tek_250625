'''
Score : 
300
 points

Problem Statement
We have 
N
 switches with "on" and "off" state, and 
M
 bulbs. The switches are numbered 
1
 to 
N
, and the bulbs are numbered 
1
 to 
M
.

Bulb 
i
 is connected to 
k_i
 switches: Switch 
s_{i1}
, 
s_{i2}
, 
...
, and 
s_{ik_i}
. It is lighted when the number of switches that are "on" among these switches is congruent to 
p_i
 modulo 
2
.

How many combinations of "on" and "off" states of the switches light all the bulbs?

Constraints

1 \leq N, M \leq 10

1 \leq k_i \leq N

1 \leq s_{ij} \leq N

s_{ia} \neq s_{ib} (a \neq b)

p_i
 is 
0
 or 
1
.

All values in input are integers.

Input
Input is given from Standard Input in the following format:

N

M

k_1

s_{11}

s_{12}

...

s_{1k_1}

:

k_M

s_{M1}

s_{M2}

...

s_{Mk_M}

p_1

p_2

...

p_M

Output
Print the number of combinations of "on" and "off" states of the switches that light all the bulbs.

Sample Input 1
2 2
2 1 2
1 2
0 1

Sample Output 1
1

Bulb 
1
 is lighted when there is an even number of switches that are "on" among the following: Switch 
1
 and 
2
.

Bulb 
2
 is lighted when there is an odd number of switches that are "on" among the following: Switch 
2
.

There are four possible combinations of states of (Switch 
1
, Switch 
2
): (on, on), (on, off), (off, on) and (off, off). Among them, only (on, on) lights all the bulbs, so we should print 
1
.

Sample Input 2
2 3
2 1 2
1 1
1 2
0 0 1

Sample Output 2
0

Bulb 
1
 is lighted when there is an even number of switches that are "on" among the following: Switch 
1
 and 
2
.

Bulb 
2
 is lighted when there is an even number of switches that are "on" among the following: Switch 
1
.

Bulb 
3
 is lighted when there is an odd number of switches that are "on" among the following: Switch 
2
.

Switch 
1
 has to be "off" to light Bulb 
2
 and Switch 
2
 has to be "on" to light Bulb 
3
, but then Bulb 
1
 will not be lighted. Thus, there are no combinations of states of the switches that light all the bulbs, so we should print 
0
.

Sample Input 3
5 2
3 1 2 5
2 2 3
1 0

Sample Output 3
8
'''


# =============SOLUTION STARTS HERE==============



def solve():
    nm_line = input().split()
    n, m = int(nm_line[0]), int(nm_line[1])
    switches = []
    for i in range(0, m):
        line_str = input().split()
        line = []
        for wrd in line_str:
            line.append(int(wrd))

        switches.append(line)
    
    p = []
    p_str = input().split()
    for wrd in p_str:
        p.append(int(wrd))
    
    res = 0
    for i in range(0, 2**n):
        states = []
        for j in range(0, n):
            if (i >> j) & 1:
                states.append(1)
            else:
                states.append(0)
        
        lit = True
        for bulb_idx in range(0, m):
            on_count = 0
            for switch_idx in switches[bulb_idx]:
                if states[switch_idx - 1] == 1:
                    on_count += 1
            
            if (on_count % 2) != p[bulb_idx]:
                lit = False
                break
        
        if lit:
            res += 1
    
    print(res)
    

solve()


# {annotation: "renamed variables and changed the way to get input to make the code explicit"}