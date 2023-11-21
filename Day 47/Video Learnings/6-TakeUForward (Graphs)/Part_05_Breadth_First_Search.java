/*
We always prefer Adjacency List over Adjacency Matrix
Lets say you are making following graph

                                 1
                               /   \
                              2      6
                             / \    / \
                            3  4   7   9
                               |   |
                               5---8

n = 9
m = 9

*/
import java.util.*;

public class Part_05_Breadth_First_Search{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        // Lets say you have Undirected Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        makeAdjacencyListOfUndirectedGraph(n,m, adj, input);

        String traversal = bfsTraverse(n,m,adj);
        System.out.println(traversal);

        input.close();
    }

    // Assuming 1-based indexing
    public static void makeAdjacencyListOfUndirectedGraph(int n, int m, ArrayList<ArrayList<Integer>> adj, Scanner input) {
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
    public static String bfsTraverse(int n, int m, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        q.add(1);
        String str = "";
        while(!q.isEmpty()){
            int element = q.remove();
            str = str + " " + element;
            ArrayList<Integer> arr = adj.get(element);
            for(int i=0; i<arr.size(); i++){
                if(!visited[arr.get(i)]){
                    visited[arr.get(i)] = true;
                    q.add(arr.get(i));
                }
            }
        }
        str = str.substring(1);
        return str;
    }
}

/*
Time Complexity: O(N) + O(2M)

O(N) is for the while loop because it runs for every node value and the inner for loop runs for the total degrees of each node... which are 2 x E... As total degrees are equal to the (2 x total edges)

Space Complexity: O(n+m+N+M)

 */