/*
Grading

  Write a program which reads a list of student test scores and evaluates the performance for each student.

  The test scores for a student include scores of the midterm examination 
m
 (out of 50), the final examination 
f
 (out of 50) and the makeup examination 
r
 (out of 100). If the student does not take the examination, the score is indicated by -1.

  The final performance of a student is evaluated by the following procedure:

If the student does not take the midterm or final examination, the student's grade shall be F.

If the total score of the midterm and final examination is greater than or equal to 80, the student's grade shall be A.

If the total score of the midterm and final examination is greater than or equal to 65 and less than 80, the student's grade shall be B.

If the total score of the midterm and final examination is greater than or equal to 50 and less than 65, the student's grade shall be C.

If the total score of the midterm and final examination is greater than or equal to 30 and less than 50, the student's grade shall be D. However, if the score of the makeup examination is greater than or equal to 50, the grade shall be C.

If the total score of the midterm and final examination is less than 30, the student's grade shall be F.

Input

  The input consists of multiple datasets. For each dataset, three integers 
m
, 
f
 and 
r
 are given in a line.

  The input ends with three -1 for 
m
, 
f
 and 
r
 respectively. Your program should not process for the terminal symbols.

The number of datasets (the number of students) does not exceed 50.

Output

  For each dataset, print the grade (
A
, 
B
, 
C
, 
D
 or 
F
) in a line.

Sample Input

40 42 -1
20 30 -1
0 2 -1
-1 -1 -1

Sample Output

A
C
F
*/


// =============SOLUTION STARTS HERE==============



import java.util.ArrayList;
import java.util.Scanner;

public class Problem_04_p02411_gemini_java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> grades = new ArrayList<>();
        while (true) {
            int m = scanner.nextInt();
            int f = scanner.nextInt();
            int r = scanner.nextInt();
            if (m == -1 && f == -1 && r == -1) {
                break;
            }
            if (m == -1 || f == -1) {
                grades.add("F");
            } else {
                int total = m + f;
                if (total >= 80) {
                    grades.add("A");
                } else if (total >= 65 && total < 80) {
                    grades.add("B");
                } else if (total >= 50 && total < 65) {
                    grades.add("C");
                } else if (total >= 30 && total < 50) {
                    if (r >= 50) {
                        grades.add("C");
                    } else {
                        grades.add("D");
                    }
                } else {
                    grades.add("F");
                }
            }
        }
        scanner.close();

        for (String grade : grades) {
            System.out.println(grade);
        }
    }
}


// {annotation: "used a list to store grades and print them at the end"}