/*
_________________________________________________________
Negative Cycle ---> If a graph has a path weight < 0 then we can say that it has a negative cycle

Example:
0 ----> 1 (Weight -2)
1 ----> 2 (Weight -1)
2 ----> 0 (Weight 2)


Path weight = -2 -1 + 2 = -1
So this graph cannot get applied by using Dijkstra... But Bellman can be used to detect this negative cycle in it...


Path Weight ----> Summation of all the edge weights
_________________________________________________________
Uses
----> It is used to find the shortest paths from source to destination like Dijkstra
----> Dijkstra algorithm do not get applied to a graph having negative edges because that will create a Time Limit Exceeded and will be an infinite loop... To overcome this an algorithm called Bellman Ford came

_________________________________________________________
Bellman Ford is helpful in detecting these negative cycles...

----> It is only applied on Directed Graphs...

----> If you want to apply Bellman Ford to undirected graph then first convert the undirected graph to directed graph and then apply this algorithm...

Example

1 ----- 2(Weight 5)

Can be converted to directed graph as
1 -----> 2 (Weight 5)
2 -----> 1 (Weight 5)

_________________________________________________________
Bellman Ford's Algorithm:

Step1---> Relax all the edges n-1 times sequentially

Relaxing means the following:
For (u,v,weight)

if(distance[u] + weight < distance[v]){
    distance[v] = distance[u] + weight
}

This is how the distances will get updated and we have to do it n-1 times which means

For the following graph
0 ---> 1 ---> 2 ---> 3 ---> 4

Lets say all of them have weight 1 on their edges
For edges like the following
(u, v, wt)

(3,4,1)
(2,3,1)
(1,2,1)
(0,1,1)

Why N-1 Iterations??
----> If we take the above graph then in the first iteration we will have the following four things

dist[3] + 1 < dist[4]
dist[2] + 1 < dist[3]
dist[1] + 1 < dist[2]
dist[0] + 1 < dist[1]

Now since the distance array looks like
[0,infinity,infinity,infinity,infinity]

then in the firs iteration since the dist[3],dist[2],dist[1] are all infinity so there is not point to add 1 in them so we cannot add 1 in them... Only condition that will get true is 4th i-e
dist[0] + 1 < dist[1]
0 + 1 < infinity

Then dist[1] will get updated to 1 so the distance array looks like
[0,1,infinity,infinity,infinity]

This was first iteration... Now in the n-1 i-e 4 iterations all of them will get filled
[0,1,2,3,4]

This is why we have N-1 iterations
____________________________________________________
How to detect a negative cycle??

----> We know that we only need N-1 iterations to get all the values of distance[] of the graph with negative edges... So if we do Nth iteration or you can say one more iteration then the values of the distance[] should not get updated... But in a negative cycle if we do the Nth iteration then then values of the distance[] will still get changed... So if by doing one more iteration then n-1 iterations and the values of the distance[] gets updated or changed then we can say that there is a negative cycle in the graph
____________________________________________________

*/

/*
Lets say we have the following graph:
                          → 1 → → → 2
                         /  ↓      ↑  \
                        0   ↓      ↑  → 4
                            ↓      ↑ /
                            5 → → → 3

n=6
m=7

0 ---> 1 (Weight 5) -
1 ---> 5 (Weight -3) -
1 ---> 2 (Weight -2) -
5 ---> 3 (Weight 1) -
3 ---> 2 (Weight 6) -
3 ---> 4 (Weight -2) -
2 ---> 4 (Weight 3)


*/

import java.util.*;

public class Part_41_Bellman_Ford_Algorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = makeAdjacencyListOfDirectedWeightedGraph(n, m, input);
        displayAdjacencyListOfDirectedWeightedGraph(adj);

        input.close();
        // Applying Bellman Ford Algorithm
        int[] distances = getShortestDistancesofGraphWithNegativeEdges(n, adj);
        System.out.println(Arrays.toString(distances));
    }

    public static int[] getShortestDistancesofGraphWithNegativeEdges(int n,
            ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[0] = 0;
        for (int count = 0; count <= n - 1; count++) {
            for (int i = 0; i < adj.size(); i++) {
                ArrayList<ArrayList<Integer>> list = adj.get(i);
                if (list.size() > 0) {
                    for (int j = 0; j < list.size(); j++) {
                        int u = i;
                        int v = list.get(j).get(0);
                        int wt = list.get(j).get(1);

                        if (distances[u] != Integer.MAX_VALUE && distances[u] + wt < distances[v]) {
                            distances[v] = distances[u] + wt;
                        }
                    }
                }
            }
        }

        // Detecting a negative cycle
        boolean negativeCyclePresent = false;
        for (int count = 0; count <= n - 1; count++) {
            for (int i = 0; i < adj.size(); i++) {
                ArrayList<ArrayList<Integer>> list = adj.get(i);
                if (list.size() > 0) {
                    for (int j = 0; j < list.size(); j++) {
                        int u = i;
                        int v = list.get(j).get(0);
                        int wt = list.get(j).get(1);

                        if (distances[u] != Integer.MAX_VALUE && distances[u] + wt < distances[v]) {
                            negativeCyclePresent = true;
                        }
                    }
                }
            }
        }
        if(negativeCyclePresent){
            System.out.println("Negative Cycle is present");
        }

        return distances;
    }

    // 0-based indexing
    public static ArrayList<ArrayList<ArrayList<Integer>>> makeAdjacencyListOfDirectedWeightedGraph(int n, int m,
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
            } else {
                System.out
                        .println("Invalid Input Form...Enter the edge and weight like node1(space)node2(space)weight");
                input.nextLine();
                i--;
            }
        }

        return adj;
    }

    public static void displayAdjacencyListOfDirectedWeightedGraph(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
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
