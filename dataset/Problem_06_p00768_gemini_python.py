'''
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
'''


# =============SOLUTION STARTS HERE==============



def sort_teams(teams):
    res = list(teams.items())

    for i in range(len(res)):
        for j in range(i + 1, len(res)):
            team_i = res[i]
            team_j = res[j]

            solved_i = team_i[1]['solved']
            solved_j = team_j[1]['solved']
            time_i = team_i[1]['time']
            time_j = team_j[1]['time']
            id_i = team_i[0]
            id_j = team_j[0]

            if ((solved_j > solved_i) or (solved_j == solved_i and time_j < time_i) or (solved_j == solved_i and time_j == time_i and id_j > id_i)):
                res[i], res[j] = res[j], res[i]

    return res


def solve():
    res = []
    while True:
        line = input().split()
        M, T, P, R = int(line[0]), int(line[1]), int(line[2]), int(line[3])
        if M == 0 and T == 0 and P == 0 and R == 0:
            break

        submissions = []
        for i in range(0, R):
            input_line = input().split()
            for j_s in range(0, len(input_line)):
                input_line[j_s] = int(input_line[j_s])
            submissions.append(input_line)

        teams = {}
        for team_num in range(1, T + 1):
            teams[team_num] = {'solved': 0, 'time': 0, 'problems': {}}

        for m_s, t_s, p_s, j_s in submissions:
            if p_s not in teams[t_s]['problems']:
                teams[t_s]['problems'][p_s] = {'attempts': 0, 'solved_time': -1}
            
            if j_s == 0 and teams[t_s]['problems'][p_s]['solved_time'] == -1:
                teams[t_s]['solved'] += 1
                teams[t_s]['time'] += m_s + teams[t_s]['problems'][p_s]['attempts'] * 20
                teams[t_s]['problems'][p_s]['solved_time'] = m_s
            elif j_s != 0 and teams[t_s]['problems'][p_s]['solved_time'] == -1:
                teams[t_s]['problems'][p_s]['attempts'] += 1
        
        sorted_teams = sort_teams(teams)
        
        rankings = []
        current_rank = []
        
        for i in range(len(sorted_teams)):
            if i == 0:
                current_rank.append(sorted_teams[i][0])
            else:
                if (sorted_teams[i][1]['solved'] == sorted_teams[i-1][1]['solved'] and 
                    sorted_teams[i][1]['time'] == sorted_teams[i-1][1]['time']):
                    current_rank.append(sorted_teams[i][0])
                else:
                    rankings.append(sorted_teams[i-1][0] if len(current_rank) == 1 else current_rank)
                    current_rank = [sorted_teams[i][0]]
        
        rankings.append(sorted_teams[-1][0] if len(current_rank) == 1 else current_rank)
        
        output = ""
        for rank in rankings:
            if isinstance(rank, list):
                output += "=".join(map(str, sorted(rank, reverse=True)))
            else:
                output += str(rank)
            output += (",")

        res.append(output[:-1])
    
    for line in res:
        print(line)

solve()


# {annotation: "avoided the usage of lambda to improve readability, also modified the way to construct output"}