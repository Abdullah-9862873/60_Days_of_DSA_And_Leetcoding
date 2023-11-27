/*
Topological Sorting:
---> Linear Ordering of vertices such that if there is an edge between u and v, u appears before v in that ordering...

---> It is Applied only to DAG (Directed Acyclic Graph)

Example Graph

                        5 → 0 ← 4
                        ↓       ↓
                        2 → 3 → 1

n = 6
m = 6

Valid orderings can be
1) 5 4 2 3 1 0
2) 4 5 2 3 1 0

*/

import java.util.*;

public class Part_21_Topological_Sort_Algorithm_Using_DFS{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfDirectedGraph(n, m, input);
        displayDirectedGraphOfAdjacencyList(adj);

        input.close();

        ArrayList<Integer> arr= topologicalSort(n,m,adj);
        System.out.println(arr);
    }
    public static ArrayList<Integer> topologicalSort(int n, int m, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n];
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            if(!visited[i]){
                topologicalSortHelperUsingDFS(adj,visited, st,i);
            }
        }
        
        while(!st.isEmpty()){
            arr.add(st.pop());
        }
        return arr;
    }
    public static void topologicalSortHelperUsingDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st, int node){
        visited[node] = true;
        ArrayList<Integer> list = adj.get(node);
        for(int i=0; i<list.size(); i++){
            if(!visited[list.get(i)]){
                topologicalSortHelperUsingDFS(adj, visited, st, list.get(i));
            }
        }
        st.push(node);
    }

    // 0-based indexing
    public static ArrayList<ArrayList<Integer>> makeAdjacencyListOfDirectedGraph(int n, int m, Scanner input) {
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
    public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for(ArrayList<Integer> temp: adj){
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copied.add(copyList);
        }

        for (int i = 0; i < copied.size(); i++) {
            ArrayList<Integer> arr = copied.get(i);
            for(int j=0; j<arr.size(); j++){
                System.out.println(i + " ---> " + copied.get(i).get(j));
            }
        }
    }
}