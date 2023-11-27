
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

Time Complexity: O(N + 2M)
Space complexity: O(N) + O(N) ==> O(N)
_________________________________________________
And for a component graph lets say you have

                  3 --- 4                          8
                 /                               /   \
                1                   5           7 --- 9
                 \                  |
                  2                 6

n = 9
m = 7   

Time Complexity: O(N + 2M) + O(N)
Space complexity: O(N) + O(N) ==> O(N)
*/
import java.util.*;

public class Part_11_Detect_Cycle_in_Undirected_Graph_Using_BFS {
    public static class Pair {
        int node;
        int parent;

        public Pair(int val1, int val2) {
            this.node = val1;
            this.parent = val2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        System.out.println("Press 1 if you have component graph and 2 if not: ");
        int userInput = input.nextInt();
        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfUndirectedGraph(n, m, input);

        displayUndirectedGraphOfAdjacencyList(adj);

        boolean ans = false;
        if (userInput == 1) {
            ans = isCycleDetectedInComponentGraph(n, m, adj);
        } else {
            ans = isCycleDetected(n, m, adj);
        }
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
    public static boolean isCycleDetectedInComponentGraph(int n, int m, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(visited[i] == false){
                if(isCycleDetectedInComponentGraphHelper(n,m,adj,visited, i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleDetectedInComponentGraphHelper(int n, int m, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int startNode){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startNode, -1));
        visited[startNode] = true;

        while(!q.isEmpty()){
            Pair top = q.remove();
            int node = top.node;
            int parent = top.parent;

            ArrayList<Integer> arr = adj.get(node);
            for(int i=0; i<arr.size(); i++){
                if(visited[arr.get(i)] == false){
                    visited[arr.get(i)] = true;
                    q.add(new Pair(arr.get(i), node));
                }else if(visited[arr.get(i)] == true && parent != arr.get(i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleDetected(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, -1)); // StartingNode:1 Parent:-1 (i-e no parent)
        boolean[] visited = new boolean[n + 1];
        visited[q.peek().node] = true;      // Starting node marked visited

        while (!q.isEmpty()) {
            Pair top = q.remove();
            int node = top.node;
            int parent = top.parent;

            ArrayList<Integer> arr = adj.get(node);
            for (int i = 0; i < arr.size(); i++) {
                if (visited[arr.get(i)] == false) {
                    q.add(new Pair(arr.get(i), node));
                    visited[arr.get(i)] = true;
                } else if (visited[arr.get(i)] && arr.get(i) != parent) {
                    return true;
                }
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