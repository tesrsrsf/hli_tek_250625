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



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    boolean find(int key) {
        return findRec(root, key);
    }

    boolean findRec(Node root, int key) {
        if (root == null)
            return false;

        if (key == root.key)
            return true;

        if (key < root.key)
            return findRec(root.left, key);
        else
            return findRec(root.right, key);
    }

    List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorderRec(root, result);
        return result;
    }

    void inorderRec(Node root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.key);
            inorderRec(root.right, result);
        }
    }

    List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }

    void preorderRec(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.key);
            preorderRec(root.left, result);
            preorderRec(root.right, result);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        BST bst = new BST();

        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            String operation = parts[0];

            if (operation.equals("insert")) {
                int key = Integer.parseInt(parts[1]);
                bst.insert(key);
            } else if (operation.equals("find")) {
                int key = Integer.parseInt(parts[1]);
                if (bst.find(key)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (operation.equals("print")) {
                List<Integer> inorderList = bst.inorder();
                List<Integer> preorderList = bst.preorder();

                for (int key : inorderList) {
                    System.out.print(" " + key);
                }
                System.out.println();

                for (int key : preorderList) {
                    System.out.print(" " + key);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}


