/*
Score : 
700
 points

Problem Statement
Find the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Constraints

2 \leq K \leq 10^5

K
 is an integer.

Input
Input is given from Standard Input in the following format:

K

Output
Print the smallest possible sum of the digits in the decimal notation of a positive multiple of 
K
.

Sample Input 1
6

Sample Output 1
3

12=6×2
 yields the smallest sum.

Sample Input 2
41

Sample Output 2
5

11111=41×271
 yields the smallest sum.

Sample Input 3
79992

Sample Output 3
36
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int k;
    cin >> k;

    vector<int> dist(k, -1);
    vector<int> prev(k, -1);
    queue<int> q;

    dist[1 % k] = 1;
    q.push(1 % k);

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        int next_node_list[] = {(u * 10) % k, (u + 1) % k};
        for (int i = 0; i < 2; ++i) {
            int v = next_node_list[i];
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                prev[v] = u;
                q.push(v);
            }
        }
    }

    int res = 1e9;
    for (int i = 1; i < 10; i++) {
    if (dist[(i * 1) % k] != -1) {
        if ((i * 1) % k == 0) {
          res = min(res, i);
        }
    }
    }

    if (dist[0] != -1) {
        int cur_digit_sum = 0;
        int current = 0;

        if (dist[0] == 1) {
            res = min(res, 0);
        } else {
            queue<int> q2;
            q2.push(0);
            vector<int> digit_sum(k, -1);
            digit_sum[0] = 0;

            while (!q2.empty()) {
                int u = q2.front();
                q2.pop();

                int next_node_list[] = {u * 10 % k, (u + 1) % k};
                int next_digit[] = {0, 1};

                for (int i = 0; i < 2; i++) {
                    int v = next_node_list[i];
                    int next_digit_sum = digit_sum[u] + next_digit[i];
                    if (digit_sum[v] == -1) {
                        digit_sum[v] = next_digit_sum;

                        if (v == 0) {
                            res = min(res, next_digit_sum);
                        }

                        q2.push(v);
                    } else if (next_digit_sum < digit_sum[v]) {
                        digit_sum[v] = next_digit_sum;
                        if (v == 0) {
                            res = min(res, next_digit_sum);
                        }
                        q2.push(v);
                    }
                }
            }
        }
    }

    cout << res << endl;

    return 0;
}


// {annotation: "renamed variables and reformatted structures in my style"}