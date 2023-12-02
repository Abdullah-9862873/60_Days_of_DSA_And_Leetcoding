/*
_________________________________________________________
Lets have something like the following

1 --- 2 --- 3 --- 4

5 --- 6 --- 7

Now lets say this is one graph with two components... Now if someone asks does 1 and 5 belong to the same component or not then the answer to that is NO but to figure out the answer you'll start traversing either BFS of DFS from 1 till end to find if you got 5 in the path or not... Obviously this is gonna take some time... worst case scenario O(n) time complexity... 

But this same process can be done in constant time using Distjoint Sets..

_________________________________________________________
And one more thing is that lets say the graph is forming up
So in 
Step1 ---- > lets say 1 and 2 got joined
Step 2 ---> 2 and 3 got joined
Step 3 ---> 3 and 4 got joined
Now lets say this point someone asks does 1 and 5 belong to the same component you'll say NO

But the moment some other steps got executed then
Step 4 ---> 4 and 5 got joined 
Now the answer is YES

So Disjoint sets help to get this info at any particular time of graph formation
_________________________________________________________
Two functions are present in the Disjoint sets

1 ----> FindParent()
2 ----> Union()

Union are of two types
1) Union by Rank
2) Union by Size
_________________________________________________________
Union By Rank

Thought Process:
----> Firstly, find the ultimate parent of u and v... Lets call them pu and pv
----> Secondly, find the ranks of pu and pv
----> Thirdly, Connect smaller rank to larger rank always and if they have the same rank then connect any to any...

Method:
---> You will have two arrays... Rank and Parent... The parent will keep storing the parent of the node and the rank will get increased by one each some something gets attached under it....
For example if we have the following

        1      4
       /|      
      3 2
And we get something like attach 2 with 4 then we will see the ultimate parent pu of 2 which is 1 and the ulimate parent of 4 is 4 itself... 
Rank of 1 is 1 and Rank of 4 is 0
So 4 will get under 2

        1
       /|
      3 2
        |
        4

parent[4] = 2
rank[2] = 1

Now if anyone asks the question same question about the nodes being belonging to one component or not then that will take us Log(N) because we have to find the ultimate parent right... For example we have the following

     1                 5 
    /                  | \
   2                   6  7
  / \
 3   4

Now if there is a question of finding 4 and 7 to be of same component or not then we will find the ultimate parent of both like... 
parent[4] = 2
then parent[2] = 1
then parent[1] = 1

ok now 7's turn
parent[7] = 5
parent[5] = 5

Since both have different ultimate parents so they dont belong to the same component...
But this process is taking log(N) time complexity and not the constant time which the disjoint sets provide as traversing on parental node of tree takes O(Log N)...

So we will do Path Compression>>>
_________________________________________________________
Path Compression means that making the parent array such that every node contains its ultimate parent like we dont have to find the just parent and then the parent of the parent to reach the ultimate parent rather we will have our path compressed such that every node has its ultimate parent only in the parent array...

For Example
Parent[1] = 1
Parent[2] = 1
Parent[3] = 1
Parent[4] = 1

Parent[5] = 5
Parent[6] = 5
Parent[7] = 5

So next time if we get something like find the belongings of 2 and 7 we can say
if(parent[2] != parent[7]){
    return false;       // Do not belong to same component
}
This will take constant time....

_________________________________________________________
POINT TO NOTE: When doing the path compression we will not change the ranks... The ranks will stay the same even though we have changed parents of each node to be ultimate parent but the ranks will not get changed... 
Explanation with Example:

We had the following earlier

     1                 5 
    /                  | \
   2                   6  7
  / \
 3   4

Ranks[1] = 2
Ranks[2] = 1
Ranks[3] = 0
Ranks[4] = 0
Ranks[5] = 1
Ranks[6] = 0
Ranks[7] = 0

Parent[1] = 1
Parent[2] = 1
Parent[3] = 2
Parent[4] = 2

Parent[5] = 5
Parent[6] = 5
Parent[7] = 5

Now when we path compress it it will be something like

            1            5
           /|\          / \
          2 3 4        6   7

And ranks are parents array will be like
Ranks[1] = 2
Ranks[2] = 1
Ranks[3] = 0
Ranks[4] = 0
Ranks[5] = 1
Ranks[6] = 0
Ranks[7] = 0

Parent[1] = 1
Parent[2] = 1
Parent[3] = 1
Parent[4] = 1

Parent[5] = 5
Parent[6] = 5
Parent[7] = 5


_________________________________________________________
Time Complexity of UnionByRank(u,v) = 4(alpha) == constant 
Time Complexity of UnionBySize(u,v) = 4(alpha) == constant 
Time Complexity of findParent(node) = 4(alpha) == constant 

So overall disjoint set will have 
Time complexity = 4(alpha) = constant
_________________________________________________________

*/

// 1-based indexing
public class Part_46_Disjoint_Sets {
    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            size = new int[n+1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < size.length; i++) {
                size[i] = 1;
            }
            
        }

        int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]); // Doing path Compression by assigning the ultimate parent as parent of every under node
        }

        void unionByRank(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else{
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        // ds.unionByRank(1, 2);
        // ds.unionByRank(2, 3);
        // ds.unionByRank(4, 5);
        // ds.unionByRank(6, 7);
        // ds.unionByRank(5, 6);

        // // Checking if 3 and 7 belong to same component or not
        // if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
        //     System.out.println("They are in same component");
        // } else {
        //     System.out.println("They are not in same component");
        // }

        // ds.unionByRank(3, 7);
        // // Checking if 3 and 7 belong to same component or not
        // if (ds.rank[3] == ds.rank[7]) {
        //     System.out.println("They are in same component");
        // } else {
        //     System.out.println("They are not in same component");
        // }

        //Union By Size
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Checking if 3 and 7 belong to same component or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("They are in same component");
        } else {
            System.out.println("They are not in same component");
        }

        ds.unionBySize(3, 7);
        // Checking if 3 and 7 belong to same component or not
        if (ds.rank[3] == ds.rank[7]) {
            System.out.println("They are in same component");
        } else {
            System.out.println("They are not in same component");
        }
    }
}