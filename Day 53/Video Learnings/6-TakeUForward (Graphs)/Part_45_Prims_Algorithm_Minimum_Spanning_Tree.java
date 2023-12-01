/*
Lets take the following graph

    0--1 4
    | / / \
    |/ /   \
    2 ----- 3

n=5
m=6
0 ---- 1 (Weight 2)
0 ---- 2 (Weight 1)
2 ---- 3 (Weight 2)
2 ---- 1 (Weight 1)
2 ---- 4 (Weight 2)
3 ---- 4 (Weight 1)



*/

import java.util.*;

public class Part_45_Prims_Algorithm_Minimum_Spanning_Tree {
    public static class Tuple {
        int weight;
        int node;
        int parent;

        public Tuple(int val1, int val2, int val3) {
            this.weight = val1;
            this.node = val2;
            this.parent = val3;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = makeAdjacencyListOfUnDirectedWeightedGraph(n, m, input);
        displayAdjacencyListOfUnDirectedWeightedGraph(adj);
        input.close();

        // Applying Prims Algorithm
        int minSpanningTree = getMinimumSpanningTree(n, adj);
        System.out.println("Minimum Spanning Tree Sum is: " + minSpanningTree);
    }

    public static int getMinimumSpanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        int sum = 0;

        int[] visited = new int[n];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Tuple(0, 0, -1));

        while (!pq.isEmpty()) {
            Tuple top = pq.remove();
            int wt = top.weight;
            int currNode = top.node;
            int parent = top.parent;

            if (parent == -1) {
                visited[currNode] = 1;
            }

            if (visited[currNode] == 0) {
                mst.add(new ArrayList<>(Arrays.asList(parent, currNode)));
                sum += wt;
                visited[currNode] = 1;
            }

            ArrayList<ArrayList<Integer>> list = adj.get(currNode);
            for (int i = 0; i < list.size(); i++) {
                int newNode = list.get(i).get(0);
                int newWeight = list.get(i).get(1);
                if(visited[newNode] == 0){
                    pq.add(new Tuple(newWeight, newNode, currNode));
                }
            }
        }

        // Printing the mst
        System.out.println("Minimum Spanning Tree is: ");
        for(ArrayList<Integer> temp: mst){
            System.out.print(temp + " ");
        }
        System.out.println();
        return sum;
    }

    // 0-based indexing
    public static ArrayList<ArrayList<ArrayList<Integer>>> makeAdjacencyListOfUnDirectedWeightedGraph(int n, int m,
            Scanner input) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge and weight like node1(space)node2(space)weight");
            if (i == 0) {
                input.nextLine();
            }

            String userInput = input.nextLine();
            String[] parts = userInput.split(" ");
            if (parts.length == 3) {
                int node1 = Integer.parseInt(parts[0]);
                int node2 = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                adj.get(node1).add(new ArrayList<>(Arrays.asList(node2, weight)));
                adj.get(node2).add(new ArrayList<>(Arrays.asList(node1, weight)));
            } else {
                System.out
                        .println("Invalid Input Form...Enter the edge and weight like node1(space)node2(space)weight");
                input.nextLine();
                i--;
            }
        }

        return adj;
    }

    public static void displayAdjacencyListOfUnDirectedWeightedGraph(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            ArrayList<ArrayList<Integer>> list = adj.get(i);

            if (!list.isEmpty()) {
                System.out.print(i + " ---> {");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print("{" + list.get(j).get(0) + "," + list.get(j).get(1) + "}");
                    if (j < list.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");
            }
        }
    }
}
