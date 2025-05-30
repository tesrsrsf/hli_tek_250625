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



import java.util.*;
import java.io.*;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
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

    boolean findRec(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        return key < root.key ? findRec(root.left, key) : findRec(root.right, key);
    }

    void print() {
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> preorderList = new ArrayList<>();
        inorderRec(root, inorderList);
        preorderRec(root, preorderList);
        System.out.print(" " + String.join(" ", inorderList.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println();
        System.out.print(" " + String.join(" ", preorderList.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println();
    }

    void inorderRec(TreeNode root, List<Integer> inorderList) {
        if (root != null) {
            inorderRec(root.left, inorderList);
            inorderList.add(root.key);
            inorderRec(root.right, inorderList);
        }
    }

    void preorderRec(TreeNode root, List<Integer> preorderList) {
        if (root != null) {
            preorderList.add(root.key);
            preorderRec(root.left, preorderList);
            preorderRec(root.right, preorderList);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < m; i++) {
            String[] input = reader.readLine().split(" ");
            String command = input[0];
            if (command.equals("insert")) {
                int k = Integer.parseInt(input[1]);
                bst.insert(k);
            } else if (command.equals("find")) {
                int k = Integer.parseInt(input[1]);
                System.out.println(bst.find(k) ? "yes" : "no");
            } else if (command.equals("print")) {
                bst.print();
            }
        }
    }
}


