/*
Let's say you are having following graph:


                    1   →   2   →   3   →   4
                            ↑       ↓       ↓
                            8 → 9   7   →   5  →  6
                            ↑   ↓
                             ← 10


There is cycle in it in 8 9 10

n=10
m=11

*/
import java.util.*;

public class Part_19_Detect_Cycle_In_A_Directed_Graph_Using_DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfDirectedGraph(n, m, input);
        displayDirectedGraphOfAdjacencyList(adj);
        input.close();

        boolean ans = isCyclePresentInDirectedGraph(adj,n,m);
        if(ans){
            System.out.println("Yes Cycle is present");
        }else{
            System.out.println("NO Cycle is not present");
        }
    }

    public static boolean isCyclePresentInDirectedGraph(ArrayList<ArrayList<Integer>> adj, int n, int m){
        int[] visited = new int[n+1];
        int[] pathVisited = new int[n+1];

        for(int i=1; i<=n; i++){
            if(visited[i] == 0){ // not visited
                if(cycleDetectionHelperUsingDFS(adj,visited, pathVisited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean cycleDetectionHelperUsingDFS(ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited, int node){
        visited[node] = 1;
        pathVisited[node] = 1;

        ArrayList<Integer> arr = adj.get(node);
        for(int i=0; i<arr.size(); i++){
            if(visited[arr.get(i)] == 0 && pathVisited[arr.get(i)] == 0){
                if(cycleDetectionHelperUsingDFS(adj, visited, pathVisited, arr.get(i))){
                    return true;
                }
            }else if(visited[arr.get(i)] == 1 && pathVisited[arr.get(i)] == 1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
    // Assuming 1-based indexing
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
    public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for(ArrayList<Integer> temp: adj){
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copied.add(copyList);
        }

        for (int i = 1; i < copied.size(); i++) {
            ArrayList<Integer> arr = copied.get(i);
            for(int j=0; j<arr.size(); j++){
                System.out.println(i + " ---> " + copied.get(i).get(j));
            }
        }
    }
}
