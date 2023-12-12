/*
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

public class Part_03_Graph_Representation_In_Java2{
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
        System.out.println("____________________________________");
        System.out.println("Converting the Adjacency Matrix to Adjacency List");
        System.out.println("____________________________________");

        ArrayList<ArrayList<Integer>> list = convertAdjacencyMatrixToAdjacencyList(n,m,arr);
        for(int i=1; i<list.size(); i++){
            ArrayList<Integer> temp = list.get(i);
            System.out.println(i + " ----> " + temp);
        }
        input.close();
    }

    public static ArrayList<ArrayList<Integer>> convertAdjacencyMatrixToAdjacencyList(int n, int m, int[][] arr){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        return list;
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