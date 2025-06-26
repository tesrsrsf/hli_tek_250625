'''
Score : 
500
 points

Problem Statement
Snuke, who loves animals, built a zoo.

There are 
N
 animals in this zoo. They are conveniently numbered 
1
 through 
N
, and arranged in a circle.
The animal numbered 
i (2≤i≤N-1)
 is adjacent to the animals numbered 
i-1
 and 
i+1
. Also, the animal numbered 
1
 is adjacent to the animals numbered 
2
 and 
N
, and the animal numbered 
N
 is adjacent to the animals numbered 
N-1
 and 
1
.

There are two kinds of animals in this zoo: honest sheep that only speak the truth, and lying wolves that only tell lies.

Snuke cannot tell the difference between these two species, and asked each animal the following question: "Are your neighbors of the same species?" The animal numbered 
i
 answered 
s_i
. Here, if 
s_i
 is 
o
, the animal said that the two neighboring animals are of the same species, and if 
s_i
 is 
x
, the animal said that the two neighboring animals are of different species.

More formally, a sheep answered 
o
 if the two neighboring animals are both sheep or both wolves, and answered 
x
 otherwise.
Similarly, a wolf answered 
x
 if the two neighboring animals are both sheep or both wolves, and answered 
o
 otherwise.

Snuke is wondering whether there is a valid assignment of species to the animals that is consistent with these responses. If there is such an assignment, show one such assignment. Otherwise, print 
-1
.

Constraints

3 ≤ N ≤ 10^{5}

s
 is a string of length 
N
 consisting of 
o
 and 
x
.

Input
The input is given from Standard Input in the following format:

N

s

Output
If there does not exist an valid assignment that is consistent with 
s
, print 
-1
.
Otherwise, print an string 
t
 in the following format. The output is considered correct if the assignment described by 
t
 is consistent with 
s
.

t
 is a string of length 
N
 consisting of 
S
 and 
W
.

If 
t_i
 is 
S
, it indicates that the animal numbered 
i
 is a sheep. If 
t_i
 is 
W
, it indicates that the animal numbered 
i
 is a wolf.

Sample Input 1
6
ooxoox

Sample Output 1
SSSWWS

For example, if the animals numbered 
1
, 
2
, 
3
, 
4
, 
5
 and 
6
 are respectively a sheep, sheep, sheep, wolf, wolf, and sheep, it is consistent with their responses. Besides, there is another valid assignment of species: a wolf, sheep, wolf, sheep, wolf and wolf.

Let us remind you: if the neiboring animals are of the same species, a sheep answers 
o
 and a wolf answers 
x
. If the neiboring animals are of different species, a sheep answers 
x
 and a wolf answers 
o
.

Sample Input 2
3
oox

Sample Output 2
-1

Print 
-1
 if there is no valid assignment of species.

Sample Input 3
10
oxooxoxoox

Sample Output 3
SSWWSSSWWS
'''


# =============SOLUTION STARTS HERE==============



def solve():
  n = int(input())
  s = input()
  
  for start1 in ['S', 'W']:
    for start2 in ['S', 'W']:
      t = [''] * n
      t[0] = start1
      
      
      is_possible = True
      
      if s[0] == 'o':
        if start1 == start2:
          t[1] = start1
        else:
          t[1] = 'W' if start1 == 'S' else 'S'
      else:
        if start1 != start2:
          t[1] = start2
        else:
          t[1] = 'W' if start1 == 'S' else 'S'
        
      for i in range(2, n):
        if s[i - 1] == 'o':
          if t[i - 1] == t[i - 2]:
            t[i] = t[i - 1]
          else:
            t[i] = 'W' if t[i - 1] == 'S' else 'S'
        else:
          if t[i - 1] != t[i - 2]:
            t[i] = t[i - 2]
          else:
            t[i] = 'W' if t[i - 1] == 'S' else 'S'

      if s[n - 1] == 'o':
        if t[n - 1] != t[0]:
          is_possible = False
      else:
        if t[n - 1] == t[0]:
          is_possible = False

      if is_possible:
        res = "".join(t)
        
        is_consistent = True
        for i in range(n):
          neighbors = []
          neighbors.append(t[(i - 1) % n])
          neighbors.append(t[(i + 1) % n])

          if t[i] == 'S':
            if (neighbors[0] == neighbors[1] and s[i] != 'o') or (neighbors[0] != neighbors[1] and s[i] != 'x'):
              is_consistent = False
              break
          else:
            if (neighbors[0] == neighbors[1] and s[i] != 'x') or (neighbors[0] != neighbors[1] and s[i] != 'o'):
              is_consistent = False
              break
        
        if is_consistent:
          print(res)
          return
  
  print("-1")


solve()


# {annotation: "renamed variables in my style, reorganized code for readability"}