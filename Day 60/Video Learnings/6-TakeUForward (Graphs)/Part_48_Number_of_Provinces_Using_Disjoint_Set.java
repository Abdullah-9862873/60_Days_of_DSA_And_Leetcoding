/*
Lets say you are given the following graph:

    1 --- 2 --- 3           4 --- 5             6 --- 7

n=7
m=4
Unit Weights

*/
import java.util.*;

public class Part_48_Number_of_Provinces_Using_Disjoint_Set {
    // 1-based indexing
    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            size = new int[n + 1];
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
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        int[][] arr = makeAdjacencyMatrixOfUndirectedGraph(n, m, input);
        displayUndirectedGraphOfAdjacencyMatrix(arr);

        input.close();

        DisjointSet ds = new DisjointSet(n);
        for(int u=0; u<arr.length; u++){
            for(int v=0; v<arr[u].length; v++){
                if(arr[u][v] == 1){
                    ds.unionByRank(u, v);
                }
            }
        }

        int ans = countProvinces(n,ds);
        System.out.println("Number of provinces are: " + ans);
    }

    public static int countProvinces(int n, DisjointSet ds){
        int count = 0;
        for(int i=1; i<=n; i++){
            if(ds.findUltimateParent(i) == i){
                count++;
            }
        }
        return count;
    }

    // 1-based indexing
    public static int[][] makeAdjacencyMatrixOfUndirectedGraph(int n, int m, Scanner input) {
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like (node1 node2): ");
            if (i == 0) {
                input.nextLine(); // captures the newLine left in the input buffer after input.nextInt()
            }
            String userInput = input.nextLine();
            String[] parts = userInput.split(" ");
            if (parts.length == 2) {
                int first = Integer.parseInt(parts[0]);
                int second = Integer.parseInt(parts[1]);
                arr[first][second] = 1;
                arr[second][first] = 1;
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        return arr;
    }

    public static void displayUndirectedGraphOfAdjacencyMatrix(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    visited[j][i] = true;
                    System.out.println(i + " --- " + j);
                }
            }
        }
    }
}
