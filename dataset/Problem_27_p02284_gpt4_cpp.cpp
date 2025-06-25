/*
Binary Search Tree II

Write a program which performs the following operations to a binary search tree $T$ by adding the find operation to A: Binary Search Tree I.

insert 
 $k$: Insert a node containing $k$ as key into $T$.

find 
$k$: Report whether $T$ has a node containing $k$. 

print
: Print the keys of the binary search tree by inorder tree walk and  preorder tree walk respectively.

Input

  In the first line, the number of operations $m$ is given. In the following $m$ lines, operations represented by 
insert 
$k$, 
find 
$k$ or 
print
 are given.

Output

For each 
find 
$k$ operation, print "
yes
" if $T$ has a node containing $k$, "
no
" if not.

  In addition, for each 
print
 operation, print a list of keys obtained by inorder tree walk and preorder tree walk in a line respectively. Put a space character 
before each key
.

Constraints

The number of operations $\leq 500,000$

The number of print operations $\leq 10$.

$-2,000,000,000 \leq key \leq 2,000,000,000$

The height of the binary tree does not exceed 100 if you employ the above pseudo code.

The keys in the binary search tree are all different.

Sample Input 1

10
insert 30
insert 88
insert 12
insert 1
insert 20
find 12
insert 17
insert 25
find 16
print

Sample Output 1

yes
no
 1 12 17 20 25 30 88
 30 12 1 20 17 25 88

Reference

Introduction to Algorithms, Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein. The MIT Press.
*/


// =============SOLUTION STARTS HERE==============



#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Node {
    int key;
    Node* left;
    Node* right;

    Node(int k) : key(k), left(nullptr), right(nullptr) {}
};

class BST {
public:
    BST() : root(nullptr) {}

    void insert(int k) {
        root = insertRec(root, k);
    }

    bool find(int k) {
        return findRec(root, k);
    }

    void print() {
        vector<int> inorder_result;
        vector<int> preorder_result;
        inorder(root, inorder_result);
        preorder(root, preorder_result);

        for (int key : inorder_result) {
            cout << " " << key;
        }
        cout << endl;
        for (int key : preorder_result) {
            cout << " " << key;
        }
        cout << endl;
    }

private:
    Node* root;

    Node* insertRec(Node* node, int k) {
        if (!node) {
            return new Node(k);
        }
        if (k < node->key) {
            node->left = insertRec(node->left, k);
        } else {
            node->right = insertRec(node->right, k);
        }
        return node;
    }

    bool findRec(Node* node, int k) {
        if (!node) {
            return false;
        }
        if (node->key == k) {
            return true;
        }
        return k < node->key ? findRec(node->left, k) : findRec(node->right, k);
    }

    void inorder(Node* node, vector<int>& result) {
        if (!node) return;
        inorder(node->left, result);
        result.push_back(node->key);
        inorder(node->right, result);
    }

    void preorder(Node* node, vector<int>& result) {
        if (!node) return;
        result.push_back(node->key);
        preorder(node->left, result);
        preorder(node->right, result);
    }
};

int main() {
    int m;
    cin >> m;
    BST bst;
    string cmd;
    int k;

    for (int i = 0; i < m; i++) {
        cin >> cmd;
        if (cmd == "insert") {
            cin >> k;
            bst.insert(k);
        } else if (cmd == "find") {
            cin >> k;
            cout << (bst.find(k) ? "yes" : "no") << endl;
        } else if (cmd == "print") {
            bst.print();
        }
    }

    return 0;
}


// {annotation: "renamed identifiers for better understanding"}