/*
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
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>

int main() {
    std::string s, p;
    std::cin >> s >> p;

    // Create a new string that simulates the ring
    std::string ring_text = s + s;

    // Check if pattern p is in the ring_text
    if (ring_text.find(p) != std::string::npos) {
        std::cout << "Yes" << std::endl;
    } else {
        std::cout << "No" << std::endl;
    }

    return 0;
}


