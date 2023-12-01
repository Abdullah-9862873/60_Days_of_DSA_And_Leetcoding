
/*
Case: DFS on Adjacency List
                                1
                               / \
                              2   3---4
                             / \  |   |
                            5   6 7---8

Lets say you have this graph
n = 8
m = 8


*/
import java.util.*;

public class Part_06_Depth_First_Search {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        // Lets say you have Undirected Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        makeAdjacencyListOfUndirectedGraph(n, m, adj, input);

        String dfs = dfsTraverse(n, m, adj);
        System.out.println(dfs);
    }

    // Assuming 1-based indexing
    public static void makeAdjacencyListOfUndirectedGraph(int n, int m, ArrayList<ArrayList<Integer>> adj,
            Scanner input) {
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
    }

    // 1 based indexing
    public static String dfsTraverse(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        int startingNode = 1;
        boolean[] visited = new boolean[n + 1];
        String str = dfsTraverseHelper(n, m, adj, startingNode, visited);
        return str.substring(1);
    }

    public static String dfsTraverseHelper(int n, int m, ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        if(visited[node]){
            return "";
        }
        String ans = "-" + node;
        visited[node] = true;
        ArrayList<Integer> arr = adj.get(node);
        for (int i = 0; i < arr.size(); i++) {
            if (!visited[arr.get(i)]) {
                String str = dfsTraverseHelper(n, m, adj, arr.get(i), visited);
                ans += str;
            }
        }
        return ans;
    }
}


/*
Time complexity: O(N) + O(2M)
Space Complexity: 
[O(N) for all the nodes] + [O(N) for visited array] + [O(N) for recursion stack space in worst case where the nodes are skewed or degenrate] 
= 3 O(N)
= O(N)

 */