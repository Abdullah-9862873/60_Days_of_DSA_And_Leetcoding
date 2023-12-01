/*
In the question we can clearly see something like travelling every node from every node... Which leads us to Floyd Warshall Algorithm

Lets say you are having a graph like:

This is an undirected graph

0 -----1
      /|
     / |
    /  |
   /   |
  /    |
3 -----2

threshold = 4
n=4
m=4

0 ---- 1 (Weight 3)
1 ---- 2 (Weight 1)
2 ---- 3 (Weight 1)
3 ---- 1 (Weight 4)

*/

import java.util.*;

public class Part_43_Find_The_City_With_Smallest_Number_Of_Neighbors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        int[][] grid = makeAdjacencyMatrixOfUnDirectedWeightedGraph(n, m, input);
        displayAdjacencyMatrixOfUndirectedWeightedGraph(grid);

        input.close();

        grid = applyFloydWarshall(n,grid);

        int threshold = 4;
        int ans = getCityWithSmallestNeighbors(grid, threshold);
        System.out.println("City with smallest neighbors at most threshold is: " + ans);
    }

    public static int getCityWithSmallestNeighbors(int[][] grid, int threshold){
        int cityMax = grid.length;
        int city = -1;

        for(int i=0; i<grid.length; i++){
            int count = 0;
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] <= threshold){
                    count++;
                }
            }
            if (count < cityMax) {
                cityMax = count;
                city = i;
            } else if (count == cityMax) {
                city = Math.max(city, i);
            }
            
        }
        return city;
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

    // 0-based indexing
    public static int[][] makeAdjacencyMatrixOfUnDirectedWeightedGraph(int n, int m, Scanner input) {
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
                grid[node2][node1] = weight;
            } else {
                System.out.println("Invalid Input Form... Enter the edge like node1(space)node2(space)node3: ");
                i--;
                input.nextLine();
            }
        }

        return grid;
    }

    public static void displayAdjacencyMatrixOfUndirectedWeightedGraph(int[][] grid) {

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
