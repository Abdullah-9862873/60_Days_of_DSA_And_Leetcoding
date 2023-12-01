/*
Lets say you have the following graph:

                    --- 5 ------ 8--
                   /    | \      | |
                  1     |  |     | |
                 /      |  |     | |
                0 ----- 2  |     | |
                | \        |     | |
                | \        |     | |
                |  3-------------7 |
                |   \              |
                |    6--------------
                |   /
                ---4


n=9
m=13

0 ---- 1 (Weight 1)
0 ---- 2 (Weight 2)
0 ---- 3 (Weight 1)
0 ---- 4 (Weight 2)
1 ---- 5 (Weight 2)
2 ---- 5 (Weight 1)
3 ---- 5 (Weight 2)
4 ---- 6 (Weight 1)
3 ---- 7 (Weight 3)
3 ---- 6 (Weight 2)
5 ---- 8 (Weight 1)
6 ---- 8 (Weight 1)
7 ---- 8 (Weight 1)


*/
import java.util.*;

public class Part_40_Number_of_Ways_To_Arrive_at_Destination {
    public static class Pair {
        int node;
        long distance; 

        public Pair(long val1, int val2) {
            this.distance = val1;
            this.node = val2;
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
        
        int src = 0;
        int dst = 8;

        int ans = (int)(findNumberOfWaysToReachDestination(adj,src,dst));
        System.out.println("Number of ways to reach" + dst + "is:" + ans);
    }

    public static long findNumberOfWaysToReachDestination(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src, int dst) {
        long[] distances = new long[adj.size()]; 
        Arrays.fill(distances, Long.MAX_VALUE);

        long[] ways = new long[adj.size()]; 
        int mod = (int) (1e9 + 7);

        ways[src] = 1;
        distances[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.distance, y.distance)); // Compare using Long
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair top = pq.remove();
            long currDistance = top.distance;
            int currNode = top.node;

            ArrayList<ArrayList<Integer>> list = adj.get(currNode);
            for (int i = 0; i < list.size(); i++) {
                int travelNode = list.get(i).get(0);
                int travelDistance = list.get(i).get(1);

                long totalDistance = currDistance + travelDistance;
                if (totalDistance < distances[travelNode]) {
                    distances[travelNode] = totalDistance;
                    ways[travelNode] = ways[currNode];
                    pq.add(new Pair(totalDistance, travelNode));
                } else if (totalDistance == distances[travelNode]) {
                    ways[travelNode] = (ways[travelNode] + ways[currNode]) % mod;
                }
            }
        }
        return ways[dst] % mod;
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
