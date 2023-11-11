/*
-----------------------Problem-----------------------
----> Problem 1 (Skewed / Degenerate BST)
Lets say I am being asked to put the following nodes in the tree in the respective order...
5 7 9 11 13 17

The tree that will be made using this will be:
                                5
                                 \
                                  7
                                   \
                                    9
                                     \
                                      11
                                        \
                                         13
                                           \
                                            17

Now if I have to search for 17 in this tree then this search operation is going to take O(n) time complexity rather than O(Log n) which was the whole point of Binary Search Tree... 

Description:
----> It is not a balanced tree... A balanced BST is when the absolute difference between the height of left subtree and the right subtree is <= 1

_____________________________________________________________________________

-----------------------Solution-----------------------

----> Solution is Self Balancing Binary Tree eg AVL
Description:
----> Binary tree will get restructured in a way that it will always be balanced
*/
