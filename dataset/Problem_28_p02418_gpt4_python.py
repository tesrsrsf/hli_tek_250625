'''
Ring

  Write a program which finds a pattern $p$ in a ring shaped text $s$.

Input

  In the first line, the text $s$ is given.

  In the second line, the pattern $p$ is given.

Output

  If $p$ is in $s$, print 
Yes
 in a line, otherwise 
No
.

Constraints

$1 \leq $ length of $p \leq $ length of $s \leq 100$

$s$ and $p$ consists of lower-case letters

Sample Input 1

vanceknowledgetoad
advance

Sample Output 1

Yes

Sample Input 2

vanceknowledgetoad
advanced

Sample Output 2

No
'''


# =============SOLUTION STARTS HERE==============



s = input().strip()
p = input().strip()

# Create the ring by concatenating the string to itself
ring_s = s + s

# Check if the pattern p exists in the ring string
if p in ring_s:
    print("Yes")
else:
    print("No")


