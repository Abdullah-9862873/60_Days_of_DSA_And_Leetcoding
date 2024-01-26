/*
Lets take the following graph

                      2 --- 5 
                     /       \
                    1         7
                     \       /
                      3 --- 6
                      |
                      4

n = 7
m = 7





_________________________________________________
And for a component graph lets say you have

                  3 --- 4                          8
                 /                               /   \
                1                   5           7 --- 9
                 \                  |
                  2                 6

n = 9
m = 7   

__________________________________________________
Same for both

Time Complexity: O(N +2M) 
Space Comlexity: O(N) + O(N) --- One is Stack Space of Nodes and other is visited array... We cam say it is equal to O(N)

*/
import java.util.*;

public class Part_12_Detect_Cycle_In_Undirected_Graph_Using_DFS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        
        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfUndirectedGraph(n, m, input);
        input.close();

        displayUndirectedGraphOfAdjacencyList(adj);

        
        boolean ans = isCycleDetected(n,m,adj);
        if (ans) {
            System.out.println("______________________________");
            System.out.println("There is a cycle in the graph");
            System.out.println("______________________________");
        } else {
            System.out.println("______________________________");
            System.out.println("There is not a cycle in the graph");
            System.out.println("______________________________");
        }
    }

    public static boolean isCycleDetected(int n, int m, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n+1];
        
        // Traversing all the nodes
        for(int i=1; i<=n; i++){
            if(!visited[i] && cycleDetectedHelper(adj, visited, i, -1)){
                return true;
            }
        }
        return false;
    }
    public static boolean cycleDetectedHelper(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent){
        visited[node] = true;
        ArrayList<Integer> arr = adj.get(node);
        for(int i=0; i<arr.size(); i++){
            if(!visited[arr.get(i)]){
                if(cycleDetectedHelper(adj, visited, arr.get(i), node)){
                    return true;
                }
            }
            else if(visited[arr.get(i)] && arr.get(i) != parent){
                return true;
            }
        }
        return false;
    }

    // 1-based indexing
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
            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';
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
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for (ArrayList<Integer> originalList : adj) {
            ArrayList<Integer> copyList = new ArrayList<>(originalList);
            copied.add(copyList);
        }

        for (int i = 1; i < copied.size(); i++) {
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
