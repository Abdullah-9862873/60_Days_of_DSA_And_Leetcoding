/*
Lets say you have a single graph given below:
0-based indexing
                                  
                    0 ---- 1    4 ---- 5      6
                          /     |             |
                        2       3             7

n = 8
m = 5

So as there are 3 components of this graph so there are 3 provinces in here
so the answer will be 3

So in here we can use the DFS approach to just visit it and when it comes a point in which function will end which means that there is not other point to visit then it will have one province
*/

import java.util.*;

public class Part_07_Number_of_Provinces {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        
        // Making adjacency matrix
        int[][] arr = makeAdjacencyMatrixOfUndirectedGraph(n, m, input);
        input.close();

        int provinces = findNumberOfProvinces(n,m,arr);
        System.out.println("Provinces are: " + provinces);
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

    public static int findNumberOfProvinces(int n, int m, int[][] arr){
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfsTraverse(n,m,arr,i,visited);
                count++;
            }
        }
        return count;
    }
    public static void bfsTraverse(int n, int m, int[][] arr, int start, boolean[] visited){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        visited[start] = true;

        while(!list.isEmpty()){
            int vis = list.get(0);
            list.remove(0);

            for(int i=0; i<n; i++){
                if(arr[vis][i] == 1 && visited[i] == false){
                    list.add(i);
                    visited[i] = true;
                }
            }
        }
        return;
    }
}
