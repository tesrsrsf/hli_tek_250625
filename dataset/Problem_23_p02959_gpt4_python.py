'''
Score : 
300
 points

Problem Statement
There are 
N+1
 towns. The 
i
-th town is being attacked by 
A_i
 monsters.

We have 
N
 heroes. The 
i
-th hero can defeat monsters attacking the 
i
-th or 
(i+1)
-th town, for a total of at most 
B_i
 monsters.

What is the maximum total number of monsters the heroes can cooperate to defeat?

Constraints

All values in input are integers.

1 \leq N \leq 10^5

1 \leq A_i \leq 10^9

1 \leq B_i \leq 10^9

Input
Input is given from Standard Input in the following format:

N

A_1

A_2

...

A_{N+1}

B_1

B_2

...

B_N

Output
Print the maximum total number of monsters the heroes can defeat.

Sample Input 1
2
3 5 2
4 5

Sample Output 1
9

If the heroes choose the monsters to defeat as follows, they can defeat nine monsters in total, which is the maximum result.

The first hero defeats two monsters attacking the first town and two monsters attacking the second town.

The second hero defeats three monsters attacking the second town and two monsters attacking the third town.

Sample Input 2
3
5 6 3 8
5 100 8

Sample Output 2
22

Sample Input 3
2
100 1 1
1 100

Sample Output 3
3
'''


# =============SOLUTION STARTS HERE==============



def max_defeated_monsters(N, A, B):
    total_defeated = 0
    for i in range(N):
        monsters_in_town_i = A[i]
        monsters_in_town_i1 = A[i + 1]
        
        can_defeat = min(B[i], monsters_in_town_i + monsters_in_town_i1)
        total_defeated += can_defeat
        
        remaining = B[i] - can_defeat + monsters_in_town_i + monsters_in_town_i1
        if remaining < 0:
            remaining = 0
            
        A[i] = max(0, monsters_in_town_i - (can_defeat - min(monsters_in_town_i, B[i])))
        A[i + 1] = max(0, monsters_in_town_i1 - (can_defeat - min(monsters_in_town_i1, B[i])))
        
    return total_defeated


if __name__ == "__main__":
    N = int(input())
    mons_num = []
    hero_num = []
    mons_num_str = input().split()
    hero_num_str = input().split()

    for mons in mons_num_str:
        mons_num.append(int(mons))

    for hero in hero_num_str:
        hero_num.append(int(hero))
    
    result = max_defeated_monsters(N, mons_num, hero_num)
    print(result)


# {annotation: "changed the way to get input, renamed variables for better readability"}