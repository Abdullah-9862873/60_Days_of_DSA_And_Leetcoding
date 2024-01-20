/*
Case: DFS on Adjacency Matrix
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

public class Part_06_Depth_First_Search2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        
        // Making adjacency matrix
        int[][] arr = makeAdjacencyMatrixOfUndirectedGraph(n, m, input);
        for(int[] temp: arr){
            System.out.println(Arrays.toString(temp));
        }
        input.close();
        
        System.out.println("_______________________________________");
        System.out.println("DFS Traversal is: ");
        System.out.println("_______________________________________");


        String traversal = dfsTraverse(n,m,arr);
        System.out.println(traversal);
    }
    public static String dfsTraverse(int n, int m, int[][] arr){
        int startNode = 1;
        boolean[] visited = new boolean[n+1];

        String ans = dfsTraversalHelp(n,m,arr,startNode,visited);
        return ans.substring(1);
    }
    public static String dfsTraversalHelp(int n, int m, int[][] arr, int node, boolean[] visited){
        visited[node] = true;

        String str = "-" + node;

        for(int i=0; i<arr[node].length; i++){
            if(arr[i][node] == 1 && visited[i] == false){
                String ans = dfsTraversalHelp(n, m, arr, i, visited);
                str += ans;
            }
        }
        return str;
    }
    public static int[][] makeAdjacencyMatrixOfUndirectedGraph(int n, int m, Scanner input) {
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like (node1 node2): ");
            if (i == 0) {
                input.nextLine(); // captures the newLine left in the input buffer after input.nextInt()
            }
            String userInput = input.nextLine();

            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';

                arr[first][second] = 1;
                arr[second][first] = 1;
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        return arr;
    }
}
