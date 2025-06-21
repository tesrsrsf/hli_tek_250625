/*
ICPC Ranking

Your mission in this problem is to write a program
which, given the submission log of an ICPC (International Collegiate Programming Contest),
determines team rankings.

The log is a sequence of records of program submission
in the order of submission.
A record has four fields: elapsed time, team number,
problem number, and judgment.
The elapsed time is the time elapsed from the beginning of the contest
to the submission.
The judgment field tells whether the submitted program was
correct or incorrect, and when incorrect,
what kind of an error was found.

The team ranking is determined according to the following rules.
Note that the rule set shown here is one used in the real ICPC World Finals and Regionals,
with some detail rules omitted for simplification.

Teams that solved more problems are ranked higher.

Among teams that solve the same number of problems, 
ones with smaller total consumed time are ranked higher.

If two or more teams solved the same number of problems, and their
total consumed times are the same, they are ranked the same.

The total consumed time is the sum of the consumed time for each problem solved.
The consumed time for a solved problem is the elapsed time 
of the accepted submission plus 20 penalty minutes for every previously rejected submission for that problem.

If a team did not solve a problem, the consumed time for the problem is zero, and thus even if there are several incorrect submissions, no penalty is given.

You can assume that a team never submits a program for a problem
after the correct submission for the same problem.

Input

The input is a sequence of datasets each in the following format.
The last dataset is followed by a line with four zeros.

M

T

P

R

m
1

t
1

p
1

j
1

m
2

t
2

p
2

j
2

..... 

m
R

t
R

p
R

j
R

The first line of a dataset contains four integers

M
, 
T
, 
P
, and 
R
.

M
 is the duration of the contest.

T
 is the number of teams.

P
 is the number of problems.

R
 is the number of submission records.
The relations 
120 ≤ 
M
 ≤ 300,
1 ≤ 
T
 ≤ 50,
1 ≤ 
P
 ≤ 10,
and 0 ≤ 
R
 ≤ 2000
hold for these values.
Each team is assigned a team number between 1 and 
T
, inclusive.
Each problem is assigned a problem number between 1 and 
P
, inclusive.

Each of the following 
R
 lines contains a submission record
with four integers

m
k
, 
t
k
,

p
k
, and 
j
k

(1 ≤ 
k
 ≤ 
R
).

m
k
 is the elapsed time.

t
k
 is the team number.

p
k
 is the problem number.

j
k
 is the judgment
(0 means correct, and other values mean incorrect).
The relations
0 ≤ 
m
k
 ≤ 
M
−1,
1 ≤ 
t
k
 ≤ 
T
,
1 ≤ 
p
k
 ≤ 
P
,
and 0 ≤ 
j
k
 ≤ 10
hold for these values.

The elapsed time fields are rounded off to the nearest minute.

Submission records are given in the order of submission.
Therefore, if 
i
 < 
j
,
the 
i
-th submission is done before the 
j
-th submission
(
m
i
 ≤ 
m
j
).
In some cases, you can determine the ranking of two teams
with a difference less than a minute, by using this fact.
However, such a fact is never used in the team ranking.
Teams are ranked only using time information in minutes.

Output

For each dataset, your program should output team numbers (from 1 to 
T
),
higher ranked teams first.
The separator between two team numbers should be a comma.
When two teams are ranked the same, the separator between them
should be an equal sign.
Teams ranked the same should be listed
in decreasing order of their team numbers.

Sample Input

300 10 8 5
50 5 2 1
70 5 2 0
75 1 1 0
100 3 1 0
150 3 2 0
240 5 5 7
50 1 1 0
60 2 2 0
70 2 3 0
90 1 3 0
120 3 5 0
140 4 1 0
150 2 4 1
180 3 5 4
15 2 2 1
20 2 2 1
25 2 2 0
60 1 1 0
120 5 5 4
15 5 4 1
20 5 4 0
40 1 1 0
40 2 2 0
120 2 3 4
30 1 1 0
40 2 1 0
50 2 2 0
60 1 2 0
120 3 3 2
0 1 1 0
1 2 2 0
300 5 8 0
0 0 0 0

Output for the Sample Input

3,1,5,10=9=8=7=6=4=2
2,1,3,4,5
1,2,3
5=2=1,4=3
2=1
1,2,3
5=4=3=2=1
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

struct TeamResult {
    int teamNumber;
    int solvedProblems;
    int totalTime;
};

bool compareTeams(TeamResult& a, TeamResult& b) {
    if (a.solvedProblems != b.solvedProblems) {
        return a.solvedProblems > b.solvedProblems;
    } else if (a.totalTime != b.totalTime) {
        return a.totalTime < b.totalTime;
    } else {
        return a.teamNumber > b.teamNumber;
    }
}

int main() {
    int M, T, P, R;
    cin >> M >> T >> P >> R;
    vector<string> results;
    while (M || T || P || R) {
        vector<vector<int>> wa_subs(T + 1, vector<int>(P + 1, 0));
        vector<vector<int>> solvedTime(T + 1, vector<int>(P + 1, -1));

        for (int i = 0; i < R; ++i) {
            int m, t, p, j;
            cin >> m >> t >> p >> j;
            if (j == 0 && solvedTime[t][p] == -1) {
                solvedTime[t][p] = m;
            } else if (j != 0 && solvedTime[t][p] == -1) {
                wa_subs[t][p]++;
            }
        }

        vector<TeamResult> teamResults(T);
        for (int team = 1; team <= T; ++team) {
            teamResults[team - 1].teamNumber = team;
            teamResults[team - 1].solvedProblems = 0;
            teamResults[team - 1].totalTime = 0;
            for (int problem = 1; problem <= P; ++problem) {
                if (solvedTime[team][problem] != -1) {
                    teamResults[team - 1].solvedProblems++;
                    teamResults[team - 1].totalTime += solvedTime[team][problem] + 20 * wa_subs[team][problem];
                }
            }
        }

        sort(teamResults.begin(), teamResults.end(), compareTeams);

        string output = "";
        int rank = 1;
        int previousSolved = -1;
        int previousTime = -1;
        vector<int> sameRankTeams;

        for (int i = 0; i < T; ++i) {
            if (i == 0 || teamResults[i].solvedProblems != previousSolved || teamResults[i].totalTime != previousTime) {
                if (!sameRankTeams.empty()) {
                    sort(sameRankTeams.begin(), sameRankTeams.end(), greater<int>());
                    for (int j = 0; j < sameRankTeams.size(); ++j) {
                        output = output + to_string(sameRankTeams[j]);
                        if (j < sameRankTeams.size() - 1) {
                            output = output + "=";
                        }
                    }
                    output = output + ",";
                    sameRankTeams.clear();
                }
                sameRankTeams.push_back(teamResults[i].teamNumber);
                previousSolved = teamResults[i].solvedProblems;
                previousTime = teamResults[i].totalTime;
            } else {
                sameRankTeams.push_back(teamResults[i].teamNumber);
            }
        }

        if (!sameRankTeams.empty()) {
            sort(sameRankTeams.begin(), sameRankTeams.end(), greater<int>());
            for (int j = 0; j < sameRankTeams.size(); ++j) {
                output = output + to_string(sameRankTeams[j]);
                if (j < sameRankTeams.size() - 1) {
                    output = output + "=";
                }
            }
        }
        results.push_back(output);
        cin >> M >> T >> P >> R;
    }

    for (string result : results) {
        cout << result << endl;
    }

    return 0;
}


// {annotation: "renamed the variables to fit my style, also modified the output format to match the requirements of the problem statement"}