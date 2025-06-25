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
#include <algorithm>

using namespace std;

struct Node {
    int key;
    Node* left;
    Node* right;
    Node(int k) : key(k), left(nullptr), right(nullptr) {}
};


Node* insert(Node* root, int k) {
    if (root == nullptr) {
        return new Node(k);
    }

    if (k < root->key) {
        root->left = insert(root->left, k);
    } else if (k > root->key) {
        root->right = insert(root->right, k);
    }

    return root;
}


bool find(Node* root, int k) {
    if (root == nullptr) {
        return false;
    }

    if (k == root->key) {
        return true;
    } else if (k < root->key) {
        return find(root->left, k);
    } else {
        return find(root->right, k);
    }
}


void inorder(Node* root, vector<int>& result) {
    if (root != nullptr) {
        inorder(root->left, result);
        result.push_back(root->key);
        inorder(root->right, result);
    }
}


void preorder(Node* root, vector<int>& result) {
    if (root != nullptr) {
        result.push_back(root->key);
        preorder(root->left, result);
        preorder(root->right, result);
    }
}


void nuke(Node* root) {
    if (root != nullptr) {
        nuke(root->left);
        nuke(root->right);
        delete root;
    }
}


int main() {
    int m;
    cin >> m;

    Node* root = nullptr;

    for (int i = 0; i < m; i++) {
        string cmd;
        cin >> cmd;

        if (cmd == "insert") {
            int k;
            cin >> k;
            root = insert(root, k);
        } else if (cmd == "find") {
            int k;
            cin >> k;
            if (find(root, k)) {
                cout << "yes" << endl;
            } else {
                cout << "no" << endl;
            }
        } else if (cmd == "print") {
            vector<int> inoRes;
            inorder(root, inoRes);
            cout << " ";
            for (int key : inoRes) {
                cout << key << " ";
            }
            cout << endl;

            vector<int> proRes;
            preorder(root, proRes);
            cout << " ";
            for (int key : proRes) {
                cout << key << " ";
            }
            cout << endl;
        }
    }
    nuke(root);
    return 0;
}


// {annotation: "renamed variables and modified output structure to fit my style"}