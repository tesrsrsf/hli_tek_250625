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
        self.key = key
        self.left = None
        self.right = None


class BST:
    def __init__(self):
        self.root = None


    def insert(self, key):
        node = Node(key)
        if self.root is None:
            self.root = node
            return
        
        curr = self.root
        while True:
            if key < curr.key:
                if curr.left is None:
                    curr.left = node
                    return
                else:
                    curr = curr.left
            elif key > curr.key:
                if curr.right is None:
                    curr.right = node
                    return
                else:
                    curr = curr.right
            else:
                return


    def find(self, key):
        curr = self.root
        while curr:
            if key == curr.key:
                return "yes"
            elif key < curr.key:
                curr = curr.left
            else:
                curr = curr.right
        return "no"


    def inorder(self):
        result = []
        def inorderExe(node):
            if node:
                inorderExe(node.left)
                result.append(node.key)
                inorderExe(node.right)
        inorderExe(self.root)
        return result


    def preorder(self):
        result = []
        def preorderExe(node):
            if node:
                result.append(node.key)
                preorderExe(node.left)
                preorderExe(node.right)
        preorderExe(self.root)
        return result


m = int(input())
bst = BST()
for i in range(0, m):
    line = input().split()
    cmd = line[0]
    if cmd == "insert":
        key = int(line[1])
        bst.insert(key)
    elif cmd == "find":
        key = int(line[1])
        print(bst.find(key))
    elif cmd == "print":
        inorder_result = bst.inorder()
        preorder_result = bst.preorder()
        
        ino_res = " "
        pro_res = " "
        for wrd in inorder_result:
            ino_res = ino_res + str(wrd) + " "

        for wrd in preorder_result:
            pro_res = pro_res + str(wrd) + " "

        print(ino_res)
        print(pro_res)


# {annotation: "modified the way to output, also renamed some methods in my style"}