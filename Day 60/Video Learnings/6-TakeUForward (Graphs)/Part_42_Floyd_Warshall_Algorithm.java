/*
___________________________________________________________
----> It is known as MultiSource Shortest Path Algorithm
----> Helps to detect negative cycles as well

so if you have the following graph

                      → 4
                     /   \
                  → 2 → → → 1 ← ←  
                 /          ↑   ↑
                0 → → → → → →   ↑
                 \              ↑
                  3 → → → → → → →

n=5
m=7

0 ----> 2 (Weight 2)
0 ----> 1 (Weight 6)
0 ----> 3 (Weight 4)
2 ----> 4 (Weight 1)
2 ----> 1 (Weight 3)
3 ----> 1 (Weight 1)
4 ----> 1 (Weight 1)

Using Floyd Warshall you will know lets say the shortest path from 1 to 4
from 4 to 2
like from every node to where they can go you will know the shortest path
___________________________________________________________
Floyd Warshall Algorithm:

----> Lets say you have the following graph
          <---      
        0 ---> 1
        ↓    / ↓
        ↓   /  ↓
        ↓  /   ↓
        ↓ /    ↓
        3 ---->2

n=4
m=6

0 ----> 1 (Weight 2)
1 ----> 0 (Weight 1)
3 ----> 0 (Weight 3)
3 ----> 2 (Weight 4)
3 ----> 1 (Weight 5)
1 ----> 2 (Weight 3)

The matrix made will be something like

int[][] cost = {
    {0,2,inf,inf},
    {1,0,3,inf},
    {inf,inf,0,inf},
    {3,5,4,0},
}

The idea is that we have to travel from every node via every node...
So like from 
0 to 0 via 0
0 to 1 via 0
0 to 2 via 0
0 to 3 via 0
0 to 4 via 0

The same for 1 like 1 to 0 via 1 and so on for n-1 nodes...

Traversing via some node is pretty simple like
if you want to traverse from node 0 to 1 via 2 lets say then the value will be
cost[0][2] + cost[2][1]

And you have to keep track of the minimum among this value and the value that is already present in the array...
___________________________________________________________
How to Detect a cycle?

Lets say you have some graph like the following

0 ----> 1 (Weight -2)
1 ----> 2 (Weight -3)
2 ----> 0 (Weight +2)

We know that the shortest distance from node i to itself is 0...
But if there is a negative cycle like in this graph when we travel from node 0 to node 0 then the node 0 will have a negative value... Which denotes that the shortest distance from node 0 to itself is negative which doesn't make sense... So we can say the following

for(int i=0; i<n; i++){
    if(cost[i][i] < 0){
        THERE IS A NEGATIVE CYCLE HERE
    }
}
___________________________________________________________
*/

/*
----> Lets say you have the following graph
          <---      
        0 ---> 1
        ↓    / ↓
        ↓   /  ↓
        ↓  /   ↓
        ↓ /    ↓
        3 ---->2

n=4
m=6

0 ----> 1 (Weight 2)
1 ----> 0 (Weight 1)
3 ----> 0 (Weight 3)
3 ----> 2 (Weight 4)
3 ----> 1 (Weight 5)
1 ----> 2 (Weight 3)

*/
import java.util.*;

public class Part_42_Floyd_Warshall_Algorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        int[][] grid = makeAdjacencyMatrixOfDirectedWeightedGraph(n, m, input);
        displayAdjacencyMatrixOfDirectedWeightedGraph(grid);

        input.close();

        grid = applyFloydWarshall(n,grid);
        for(int[] temp: grid){
            System.out.println(Arrays.toString(temp));
        }
    }
    public static int[][] applyFloydWarshall(int n, int[][] matrix){
        // Placing infinity where there are no values and placing 0 where like from node 0 to 0 it would be 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                                            matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Converting the infinity back to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
        return matrix;
    }

    public static int[][] makeAdjacencyMatrixOfDirectedWeightedGraph(int n, int m, Scanner input) {
        int[][] grid = new int[n][n];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like node1(space)node2(space)node3: ");
            if (i == 0) {
                input.nextLine(); // Clearing the input buffer
            }

            String userInput = input.nextLine();
            String[] parts = userInput.split(" ");
            if (parts.length == 3) {
                int node1 = Integer.parseInt(parts[0]);
                int node2 = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                grid[node1][node2] = weight;
            } else {
                System.out.println("Invalid Input Form... Enter the edge like node1(space)node2(space)node3: ");
                i--;
                input.nextLine();
            }
        }

        return grid;
    }

    public static void displayAdjacencyMatrixOfDirectedWeightedGraph(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            System.out.print(i + " ---> {");
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0 && grid[i][j] != Integer.MAX_VALUE) {
                    System.out.print("{" + j + "," + grid[i][j] + "}");
                    if (j < grid[i].length - 2) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println("}");
        }
    }
}
