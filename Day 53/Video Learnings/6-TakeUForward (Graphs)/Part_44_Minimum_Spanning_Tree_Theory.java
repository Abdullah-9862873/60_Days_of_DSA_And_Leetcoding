/*
Spanning Tree:
---> A tree in which we have n nodes and n-1 edges and all nodes are reachable from each other 


For Example lets say you are given the following graph:

    0 ---- 1 ---- 2
    |     /|     /
    |    / |    /
    |   /  |   /
    |  /   |  /
    3      4


Nodes = 5
Edges = 6

Now the following can be the minimum spanning tree of this graph

    0 ---- 1 ---- 2
          /|
         / |
        /  | 
       /   |
      /    |
     /     |
    3      4
It will have its own edge weight sum.

Nodes = 5
Edges = 4
Every node is accessible from every other node

There can be other trees also that you can make like

    0 ---- 1 ---- 2
          /      /
         /      /
        /      /
       /      /
      /      /
     /      /
    3      4
It will have its own edge weight sum.
Or

    0 ---- 1 ---- 2
    |            /
    |           /
    |          /
    |         /
    |        /
    |       /
    3      4
It will have its own edge weight sum.

Now the spanning tree that you are going to return must  be the spanning tree in which the edge weights sum is minimum...


Now minimum spanning tree demands that make such a tree from the given tree that it has edges = nodes-1 and all of them are accessible from all the other plus the sum of all the edge weights are minimum....
*/
