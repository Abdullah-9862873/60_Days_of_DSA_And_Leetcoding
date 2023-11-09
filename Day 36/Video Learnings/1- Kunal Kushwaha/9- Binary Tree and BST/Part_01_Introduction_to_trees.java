/*
Binary Tree: A tree in which the nodes have 0,1 or 2 children 

---------------------Types of Binary Tree---------------------
1- Full/Strict Binary Tree: Either has 0 or 2 children
2- Complete Binary Tree: All the levels are complete except the last one... And the last level has the nodes as left as possible
3- Perfect Binary Tree: All the levels are complete...All the leaf nodes are at same level
4- Balanced Binary Tree: Height of the tree at max must be LogBase2(Number Of Nodes)... eg if number of nodes are 8 then the height must be Log2(8) = 3 and not more than that... The height difference between any two nodes on the same level must be less than equal to 1... The height is calculated by counting the number of edges beneath the node till the leaf node that is the height of that node...
5- Degenerate/Skewed Binary Tree: Basically a skew tree or you can say that every node has a single child... eg shown below:

                                (node)
                                 /
                              (node)
                               /
                            (node)
                             /
                          (node)

6- UnBalanced Binary Tree: Unbalanced binary tree is when the height is greater than Log2(no of nodes) and the time complexity needed for the operations such as delete,add,find is more than O(log n)
7- Ordered Binary Tree: Every node has some property that it follows example: Binary Search Tree that has a property that every left node is smaller and every right node is greater
_______________________________________________________________________________
---------------------Some Properties---------------------
1- In a Perfect Binary Tree:

-----> Maximum number of Nodes = 2^(Height + 1) - 1
-----> Minimum number of Nodes = height + 1
-----> Perfect Binary Tree has the maximum number of nodes
-----> Total Leaf Nodes = 2^(Height)
-----> Total Internal Nodes (Nodes except the leaf node) = 2^(Height + 1) - 1 - 2^(Height) = 2 x 2^h - 1 - 2^h = 2 x 2^h - 2^h -1 = 2^h(2-1) - 1 = 2^h(1) - 1 = 2^h - 1

2- In a perfect binary tree... If n(no of nodes) = 15 then:
----> The minimum number of levels it can have = ceil(log2(n)) - 1
----> The maximum number of levels it can have = n - 1

3- In a Full/Strict Binary tree:
----> No of leaf nodes = No of internal Nodes + 1

4- Maximum Height of a binary tree = n-1        (n are the number of nodes)
5- Minimum Height of a binary tree = floor(log2(n))      (n are the number of nodes)



_______________________________________________________________________________

---------------------Why we use Trees??---------------------
----> We can search, add, delete in O(Log N) time complexity.... Efficient Insertion and Deletion

_______________________________________________________________________________

---------------------Problem!!!---------------------
----> If there are n number of nodes and the height of the tree is more than log2(n) then that is an unbalanced tree... The problems associated with this kinda tree is that the search, add, delete operations take O(n) time complexity but it should have been O(log n) which was was purpose of the binary tree... So this is a problem...
----> When data is sorted in a binary search tree (BST), it can lead to an inefficient tree structure where search, insertion, and deletion operations become slow. This happens because the tree may become degenerate, resembling a linked list, and its height becomes equal to the number of nodes, leading to O(N) time complexity for these operations instead of the desired O(log N) time

_______________________________________________________________________________

---------------------How To Solve!!!---------------------
----> We'll use self balancing binary tree...

_______________________________________________________________________________

---------------------Where is it used??---------------------
----> In File System representing an heirarchy... eg. Every single node can represent a folder, directory or file....
----> In Databases, We have fast retrieval of data like in AVL stuff
----> In Network Routing, using path finding algorithms
----> In Solving complex mathematical problems... One of the type of traversal is used to solve complex problems
----> In Decision Trees i-e Machine Learning
----> Compression of Files
----> In other data structures like Heaps, Graphs.. A tree is basically directed A-cyclic graph

_______________________________________________________________________________

------------------Terminologies---------------------

1- Size of tree ---------> Number of nodes
2- Child Parent Relationship
3- Sibling Relationship
4- Edge----> Two nodes been connected by a line... That line is called Edge
5- Height ----> The maximum number of edges from the node you are trying to find the height and the lead node... It is the longest path from the root node to the leaf node
6- Level ----> Subtract Height of Root - Height of node ... Level of root node is 0
7- Ancestor and Descendent
8- Root Node: The highest node in the tree structure that does not have any parent
9- Child Node: Any subnode of a given node is a child node
10- Leaf Node: A node that does not have any child node
11- SubTree: A tree that descends from the node of the starting tree

*/