/*
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node). 


Let's say you are having following graph:


                    1   →   2   →   3   →   4
                            ↑       ↓       ↓
                            8 → 9   7   →   5  →  6
                            ↑   ↓
                             ← 10 ← 11

The idea is that 
---> Where there is a cycle there cannot be a safeNode
---> The nodes that are associated with the cycle will never be the safeNode

---> Rest of the nodes are all safeNodes 

n=11
m=12

*/
import java.util.*;

public class Part_20_Find_Eventual_Safe_States{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfDirectedGraph(n, m, input);
        displayDirectedGraphOfAdjacencyList(adj);
        input.close();

        ArrayList<Integer> safeNodes = getSafeNodes(adj,n,m);
        System.out.println(safeNodes);
    }
    public static ArrayList<Integer> getSafeNodes(ArrayList<ArrayList<Integer>> adj, int n, int m){
        int[] visited = new int[n+1];
        int[] pathVisited = new int[n+1];
        int[] safeNodes = new int[n+1];

        for(int i=1; i<=n; i++){
            if(visited[i] == 0){
                getSafeNodesHelper(adj,visited,pathVisited,safeNodes,i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(safeNodes[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean getSafeNodesHelper(ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited, int[] safeNodes, int node){
        visited[node] = 1;
        pathVisited[node] = 1;
        safeNodes[node] = 0;

        ArrayList<Integer> arr = adj.get(node);
        for(int i=0; i<arr.size(); i++){
            if(visited[arr.get(i)] == 0 && pathVisited[arr.get(i)] == 0){
                if(getSafeNodesHelper(adj, visited, pathVisited, safeNodes, arr.get(i))){
                    safeNodes[arr.get(i)] = 0;
                    return true;
                }
            }else if(visited[arr.get(i)] == 1 && pathVisited[arr.get(i)] == 1){
                safeNodes[arr.get(i)] = 0;
                return true;
            }
        }
        // If no cycle found in the path then it is a safe node
        safeNodes[node] = 1;
        pathVisited[node] = 0;
        return false;
    }

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
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        return adj;
    }
        public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for (ArrayList<Integer> temp : adj) {
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copied.add(copyList);
        }

        // I have already copied
        for (int i = 1; i < adj.size(); i++) {
            System.out.print(i + " ---> {");
            ArrayList<Integer> list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == list.size() - 1) {
                    System.out.print(list.get(j));
                } else {
                    System.out.print(list.get(j) + " ,");
                }
            }

            System.out.println("}");
        }
    }

}
