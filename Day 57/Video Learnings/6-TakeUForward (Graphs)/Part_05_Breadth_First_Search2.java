/*
Case: Adjacency Matrix
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

public class Part_05_Breadth_First_Search2 {
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
        System.out.println("BFS Traversal is: ");
        System.out.println("_______________________________________");

        int startNode = 1;
        String traversal = bfsTraverse(n,m,arr,startNode);
        System.out.println(traversal);
    }
    public static String bfsTraverse(int n, int m, int[][] arr, int start){
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        visited[start] = true;

        String str = "";
        while(!list.isEmpty()){
            int vis = list.get(0);
            str += "-" + vis;
            list.remove(0);

            for(int i=0; i<=n; i++){
                if(arr[vis][i] == 1 && visited[i] == false){
                    list.add(i);
                    visited[i] = true;
                }
            }
        }
        return str.substring(1);
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