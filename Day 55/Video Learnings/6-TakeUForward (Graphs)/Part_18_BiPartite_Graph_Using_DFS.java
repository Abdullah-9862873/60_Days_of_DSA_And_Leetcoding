/*
Bipartite Graph: Color the graph using 2 colors such that no neighboring nodes have the same color

______________________________________________________
Example 1: Lets say Y is for yellow color and G is for Green

                4 ---- 5
               /        \
1 ---- 2 ---- 3          6 --- 9 --- 10
               \        /
                8 ---- 7

                G ---- Y
               /        \
Y ---- G ---- Y          G --- Y --- G
               \        /
                G ---- Y

n = 10
m = 10

This is a BiPartite Graph... Cycle length = 6

Example 2: 

                G ---- Y
               /        \
Y ---- G ---- Y          G --- Y --- G
               \       /
                \     /
                   Y  

                4 ---- 5
               /        \
1 ---- 2 ---- 3          6 --- 8 --- 9
               \       /
                \     /
                   7  

n = 9
m = 9

Since two same colors came adjacent so it is not a BiPartite
Cycle length = 5

______________________________________________________
Observations

Linear Graphs with no cycles are alway Bipartite
Any Graph with even length cycle is also a BiPartite

Any Graph with odd length cycle in it is not a BiPartite
______________________________________________________
*/

import java.util.*;

public class Part_18_BiPartite_Graph_Using_DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfUndirectedGraph(n, m, input);
        displayUndirectedGraphOfAdjacencyList(adj);
        input.close();

        boolean ans = isBipartite(adj, n, m);
        if (ans) {
            System.out.println("Yes, it is Bipartite");
        } else {
            System.out.println("No, it is not Bipartite");
        }
    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1){
                if(!isBipartiteHelper(adj, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartiteHelper(ArrayList<ArrayList<Integer>> adj, int[] visited, int node) {
        if (visited[node] == -1) {
            visited[node] = 0;
        }

        ArrayList<Integer> arr = adj.get(node);
        for(int i=0; i<arr.size(); i++){
            int neighbor = arr.get(i);
            if(visited[neighbor] == -1){    // not visited
                // Visiting the node
                visited[neighbor] = 1 - visited[node];
                if(!isBipartiteHelper(adj, visited, neighbor)){
                    return false;
                }
            }else{
                if(visited[node] == visited[neighbor]){
                    return false;
                }
            }
        }
        return true;
    }

    // Assuming 1-based indexing
    public static ArrayList<ArrayList<Integer>> makeAdjacencyListOfUndirectedGraph(int n, int m, Scanner input) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
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
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        return adj;
    }

    public static void displayUndirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            ArrayList<Integer> arr = adj.get(i);
            for (int j : arr) {
                System.out.println(i + " --- " + j);
            }
        }
    }
}
