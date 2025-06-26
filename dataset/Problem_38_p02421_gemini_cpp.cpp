/*
Card Game

  Taro and Hanako are playing card games. They have 
n
 cards each, and they compete 
n
 turns. At each turn Taro and Hanako respectively puts out a card.
  The name of the animal consisting of alphabetical letters is written on each card, and the bigger one in lexicographical order becomes the winner of that turn. The winner obtains 3 points. In the case of a draw, they obtain 1 point each.

  Write a program which reads a sequence of cards Taro and Hanako have and reports the final scores of the game.

Input

  In the first line, the number of cards 
n
 is given. In the following 
n
 lines, the cards for 
n
 turns are given respectively. For each line, the first string represents the Taro's card and the second one represents Hanako's card.

Constraints

n
 ≤ 1000

The length of the string ≤ 100

Output

  Print the final scores of Taro and Hanako respectively. Put a single space character between them.

Sample Input

3
cat dog
fish fish
lion tiger

Sample Output

1 7
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;

    int taro_score = 0;
    int hanako_score = 0;

    for (int i = 0; i < n; i++) {
        string taro_card, hanako_card;
        cin >> taro_card >> hanako_card;

        if (taro_card > hanako_card) {
            taro_score = taro_score + 3;
        } else if (taro_card < hanako_card) {
            hanako_score = hanako_score + 3;
        } else {
            taro_score = taro_score + 1;
            hanako_score = hanako_score + 1;
        }
    }

    string res = to_string(taro_score) + " " + to_string(hanako_score);
    cout << res << endl;

    return 0;
}


// {annotation: "reformatted code for better readability, used string concatenation for output, renamed variables for matching my style"}