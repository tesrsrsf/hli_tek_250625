/*
Score : 
500
 points

Problem Statement
You are given a string 
S
 of length 
N
 consisting of lowercase English letters.

Process 
Q
 queries of the following two types:

Type 
1
: change the 
i_q
-th character of 
S
 to 
c_q
. (Do nothing if the 
i_q
-th character is already 
c_q
.)

Type 
2
: answer the number of different characters occurring in the substring of 
S
 between the 
l_q
-th and 
r_q
-th characters (inclusive).

Constraints

N
, 
Q
, 
i_q
, 
l_q
, and 
r_q
 are integers.

S
 is a string consisting of lowercase English letters.

c_q
 is a lowercase English letter.

1 \leq N \leq 500000

1 \leq Q \leq 20000

|S| = N

1 \leq i_q \leq N

1 \leq l_q \leq r_q \leq N

There is at least one query of type 
2
 in each testcase.

Input
Input is given from Standard Input in the following format:

N

S

Q

Query_1

\vdots

Query_Q

Here, 
Query_i
 in the 
4
-th through 
(Q+3)
-th lines is one of the following:

1

i_q

c_q

2

l_q

r_q

Output
For each query of type 
2
, print a line containing the answer.

Sample Input 1
7
abcdbbd
6
2 3 6
1 5 z
2 1 1
1 4 a
1 7 d
2 1 7

Sample Output 1
3
1
5

In the first query, 
cdbb
 contains three kinds of letters: 
b
 , 
c
 , and 
d
, so we print 
3
.

In the second query, 
S
 is modified to 
abcdzbd
.

In the third query, 
a
 contains one kind of letter: 
a
, so we print 
1
.

In the fourth query, 
S
 is modified to 
abcazbd
.

In the fifth query, 
S
 does not change and is still 
abcazbd
.

In the sixth query, 
abcazbd
 contains five kinds of letters: 
a
, 
b
, 
c
, 
d
, and 
z
, so we print 
5
.
*/


// =============SOLUTION STARTS HERE==============



import java.util.*;

public class Main {
    static class SegmentTree {
        private int[] tree;
        private int n;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
            Arrays.fill(tree, 0);
        }

        public void update(int idx, char oldChar, char newChar) {
            if (oldChar == newChar) return;
            updateUtil(1, 0, n - 1, idx, oldChar, newChar);
        }

        private void updateUtil(int node, int start, int end, int idx, char oldChar, char newChar) {
            if (start == end) {
                tree[node] = updateFrequency(tree[node], oldChar, newChar);
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    updateUtil(2 * node, start, mid, idx, oldChar, newChar);
                } else {
                    updateUtil(2 * node + 1, mid + 1, end, idx, oldChar, newChar);
                }
                tree[node] = tree[2 * node] | tree[2 * node + 1]; // Combine results
            }
        }

        private int updateFrequency(int freq, char oldChar, char newChar) {
            // Remove oldChar and add newChar
            freq &= ~(1 << (oldChar - 'a'));
            freq |= (1 << (newChar - 'a'));
            return freq;
        }

        public int query(int L, int R) {
            return queryUtil(1, 0, n - 1, L, R);
        }

        private int queryUtil(int node, int start, int end, int L, int R) {
            if (R < start || end < L) return 0; // out of range
            if (L <= start && end <= R) return tree[node]; // fully in range
            int mid = (start + end) / 2;
            int leftQuery = queryUtil(2 * node, start, mid, L, R);
            int rightQuery = queryUtil(2 * node + 1, mid + 1, end, L, R);
            return leftQuery | rightQuery; // Combine results
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String S = scanner.nextLine();
        int Q = Integer.parseInt(scanner.nextLine());

        SegmentTree segTree = new SegmentTree(N);
        for (int i = 0; i < N; i++) {
            segTree.update(i, S.charAt(i), S.charAt(i));
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String[] query = scanner.nextLine().split(" ");
            int type = Integer.parseInt(query[0]);
            if (type == 1) {
                int idx = Integer.parseInt(query[1]) - 1;
                char newChar = query[2].charAt(0);
                char oldChar = S.charAt(idx);
                S = S.substring(0, idx) + newChar + S.substring(idx + 1);
                segTree.update(idx, oldChar, newChar);
            } else if (type == 2) {
                int l = Integer.parseInt(query[1]) - 1;
                int r = Integer.parseInt(query[2]) - 1;
                int freq = segTree.query(l, r);
                int count = Integer.bitCount(freq);
                output.append(count).append("\n");
            }
        }
        System.out.print(output.toString());
        scanner.close();
    }
}


