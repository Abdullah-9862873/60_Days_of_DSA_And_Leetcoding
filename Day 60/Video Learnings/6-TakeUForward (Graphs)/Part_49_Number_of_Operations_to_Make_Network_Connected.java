/*
Lets have the following graph
 
              1 --- 2       4 --- 5     7 --- 8
              |    /|       |
              |   / |       6
              |  /  |
              | /   |
              0 --- 3

n=9
m=8

*/

import java.util.*;

public class Part_49_Number_of_Operations_to_Make_Network_Connected {
    // 0-based indexing
    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
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
            return parent[node] = findUltimateParent(parent[node]); // Doing path Compression by assigning the ultimate
                                                                    // parent as parent of every under node
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
        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfUndirectedGraph(n, m, input);
        displayUndirectedGraphOfAdjacencyList(adj);
        input.close();

        int ans = countNumberOfOperations(n, adj);
        System.out.println("Number of operations are: " + ans);
    }

    public static int countNumberOfOperations(int n, ArrayList<ArrayList<Integer>> adj) {
        // Count the number of components
        // Number of operations required are (number of components - 1)
        // Count extra edges
        // If extra edges are >= number of operations required then return number of
        // operations
        // else return -1

        DisjointSet ds = new DisjointSet(n);
        int totalEdges = 0;
        int extraEdges = 0;
        for (int i = 0; i < adj.size(); i++) {
            int j = 0;
            while (j < adj.get(i).size()) {
                int node = adj.get(i).get(j);
                adj.get(node).remove(0);

                // i --- node
                if (ds.findUltimateParent(i) != ds.findUltimateParent(node)) {
                    ds.unionByRank(i, node);
                    totalEdges++;
                } else {
                    extraEdges++;
                    totalEdges++;
                }
                j++;
            }
        }

        // Counting total number of components
        // 0-based indexing
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUltimateParent(i) == i) {
                components++;
            }
        }

        if (extraEdges >= components-1) {
            return components - 1;
        }
        return -1;
    }

    // Assuming 0-based indexing
    public static ArrayList<ArrayList<Integer>> makeAdjacencyListOfUndirectedGraph(int n, int m, Scanner input) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like (node1 node2): ");
            if (i == 0) {
                input.nextLine();
            }
            String userInput = input.nextLine();

            String[] parts = userInput.split(" ");

            if (parts.length == 2) {
                int first = Integer.parseInt(parts[0]);
                int second = Integer.parseInt(parts[1]);
                adj.get(first).add(second);
                adj.get(second).add(first);
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        for (int i = 0; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        return adj;
    }

    public static void displayUndirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for (ArrayList<Integer> originalList : adj) {
            ArrayList<Integer> copyList = new ArrayList<>(originalList);
            copied.add(copyList);
        }

        for (int i = 0; i < copied.size(); i++) {
            ArrayList<Integer> arr = copied.get(i);
            while (arr.size() > 0) {
                int j = copied.get(i).get(0);
                System.out.println(i + " --- " + j);
                copied.get(i).remove(0);
                copied.get(j).remove(0);
            }
        }
    }
}