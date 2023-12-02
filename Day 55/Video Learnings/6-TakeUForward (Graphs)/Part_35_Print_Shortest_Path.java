/*
Lets say you are given the following graph:

                1 ---- 2 ---- 5
                |       \     |
                |        \    |
                |         \   |
                |          \  |
                |           \ |
                4 ----------- 3

n = 5
m = 6
src = 1
destination = 5

1 ---- 2 (Weight 2)
1 ---- 4 (Weight 1)
2 ---- 3 (Weight 4)
2 ---- 5 (Weight 5)
3 ---- 5 (Weight 1)
4 ---- 3 (Weight 3)



*/

import java.util.*;

public class Part_35_Print_Shortest_Path {
    public static class Pair {
        int node;
        int distance;

        public Pair(int val1, int val2) {
            this.node = val1;
            this.distance = val2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of Edges: ");
        int m = input.nextInt();
        System.out.println("Enter the source from which you want the distances to find: ");
        int src = input.nextInt();
        System.out.println("Enter the destination: ");
        int destination = input.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = makeAdjacencyListOfUnDirectedWeightedGraph(n, m, input);

        // Copying
        ArrayList<ArrayList<ArrayList<Integer>>> adjCopy = new ArrayList<>(adj.size());
        for (ArrayList<ArrayList<Integer>> list : adj) {
            ArrayList<ArrayList<Integer>> listCopy = new ArrayList<>(list.size());
            for (ArrayList<Integer> edge : list) {
                listCopy.add(new ArrayList<>(edge));
            }
            adjCopy.add(listCopy);
        }

        System.out.println();
        displayAdjacencyListOfUnDirectedWeightedGraph(adjCopy);

        input.close();

        ArrayList<Integer> path = applyDijkstraAlgorithmOfPriorityQueue(adj, src, destination);
        System.out.println(path);
    }

    // 1-based indexing
    public static ArrayList<Integer> applyDijkstraAlgorithmOfPriorityQueue(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src,
        int destination) {

        int[] parents = new int[adj.size()];
        for(int i=1; i<parents.length; i++){
            parents[i] = i;
        }
        int[] distances = new int[adj.size()];
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;
        parents[src] = src;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            int node = top.node;
            int weight = top.distance;

            ArrayList<ArrayList<Integer>> list = adj.get(node);
            for (int i = 0; i < list.size(); i++) {
                int newNode = list.get(i).get(0);
                int newNodeWeight = list.get(i).get(1);

                if (distances[newNode] > weight + newNodeWeight) {
                    parents[newNode] = node;
                    distances[newNode] = weight + newNodeWeight;
                    pq.add(new Pair(newNode, weight + newNodeWeight));
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        if(distances[destination] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }

        int node = destination;
        while(parents[node] != node){
            path.add(node);
            node = parents[node];
        }
        path.add(src);
        Collections.reverse(path);

        return path;
    }

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
                System.out.println("Invalid Input Form...Enter the edge and weight like node1(space)node2(space)weight");
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
