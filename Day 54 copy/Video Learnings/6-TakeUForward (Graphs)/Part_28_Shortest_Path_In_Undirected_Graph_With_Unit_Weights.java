/*
Lets say you are given the following graph:

              1 --- 2
             /|     |  7
            0 |     | / \
             \|     |/   \
              3     6 --- 8
              |     |
              4 --- 5

n = 9
m = 11
src = 0;

Edges: 
0 1
0 3
1 2
2 6
6 7
7 8
8 6
3 4
4 5
5 6
1 3

Weights are 1 of every edge

*/

import java.util.*;

public class Part_28_Shortest_Path_In_Undirected_Graph_With_Unit_Weights {
    public static class Pair{
        int node;
        int distance;

        public Pair(int val1, int val2){
            this.node = val1;
            this.distance = val2;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numebr of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of Edges: ");
        int m = input.nextInt();
        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfUndirectedGraph(n, m, input);
        displayUndirectedGraphOfAdjacencyList(adj);

        System.out.println("Enter the source from which you want the distances to get calculated: ");
        int src = input.nextInt();
        input.close();
        int[] distances = computeShortestDistances(n,src,adj);
        System.out.println(Arrays.toString(distances));
    }
    public static int[] computeShortestDistances(int n,int src, ArrayList<ArrayList<Integer>> adj){
        int[] distances = new int[n];
        for(int i=0; i<distances.length; i++){
            distances[i] = Integer.MAX_VALUE;
        }

        distances[src] = 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src,0));

        while(!q.isEmpty()){
            Pair top = q.remove();
            int node = top.node;
            int distance = top.distance;

            ArrayList<Integer> list = adj.get(node);
            for(int i=0; i<list.size(); i++){
                int newNode = list.get(i);
                int distOfNewNodeInArray = distances[newNode];
                int newDistance = distance+1;
                
                distances[newNode] = Math.min(distances[newNode], newDistance);
                if(distances[newNode] != distOfNewNodeInArray){
                    // It got updated
                    q.add(new Pair(newNode,newDistance));
                }
            }
        }
        return distances;
    }

    public static ArrayList<ArrayList<Integer>> makeAdjacencyListOfUndirectedGraph(int n, int m, Scanner input) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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
                adj.get(second).add(first);
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        for (int i = 0; i < adj.size(); i++) {
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

        for (int i = 0; i < copied.size(); i++) {
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
