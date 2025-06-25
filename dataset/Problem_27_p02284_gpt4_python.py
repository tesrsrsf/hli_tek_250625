'''
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
'''


# =============SOLUTION STARTS HERE==============



class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key


class BST:
    def __init__(self):
        self.root = None


    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self.insert_next(self.root, key)


    def insert_next(self, node, key):
        if key < node.val:
            if node.left is None:
                node.left = Node(key)
            else:
                self.insert_next(node.left, key)
        else:
            if node.right is None:
                node.right = Node(key)
            else:
                self.insert_next(node.right, key)


    def find(self, key):
        return self.find_exe(self.root, key)


    def find_exe(self, node, key):
        if node is None:
            return False
        if key == node.val:
            return True
        elif key < node.val:
            return self.find_exe(node.left, key)
        else:
            return self.find_exe(node.right, key)


    def inorder(self):
        return self.inorder_exe(self.root)


    def inorder_exe(self, node):
        return self.inorder_exe(node.left) + [node.val] + self.inorder_exe(node.right) if node else []


    def preorder(self):
        return self.preorder_exe(self.root)


    def preorder_exe(self, node):
        return [node.val] + self.preorder_exe(node.left) + self.preorder_exe(node.right) if node else []


import sys

input = sys.stdin.read
data = input().splitlines()

m = int(data[0])
bst = BST()
output = []

for i in range(1, m + 1):
    operation = data[i].split()
    cmd = operation[0]

    if cmd == 'insert':
        k = int(operation[1])
        bst.insert(k)
    elif cmd == 'find':
        k = int(operation[1])
        if bst.find(k):
            output.append("yes")
        else:
            output.append("no")
    elif cmd == 'print':
        inorder_result = bst.inorder()
        preorder_result = bst.preorder()
        output.append(" " + " ".join(map(str, inorder_result)))
        output.append(" " + " ".join(map(str, preorder_result)))

sys.stdout.write("\n".join(output) + "\n")


# {annotation: "renamed identifiers for better understanding and simplicity"}