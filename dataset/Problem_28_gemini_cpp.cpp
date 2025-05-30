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

using namespace std;

int main() {
  string s, p;
  cin >> s >> p;

  int n = s.length();
  int m = p.length();

  for (int i = 0; i < n; ++i) {
    bool found = true;
    for (int j = 0; j < m; ++j) {
      if (s[(i + j) % n] != p[j]) {
        found = false;
        break;
      }
    }
    if (found) {
      cout << "Yes" << endl;
      return 0;
    }
  }

  cout << "No" << endl;
  return 0;
}


