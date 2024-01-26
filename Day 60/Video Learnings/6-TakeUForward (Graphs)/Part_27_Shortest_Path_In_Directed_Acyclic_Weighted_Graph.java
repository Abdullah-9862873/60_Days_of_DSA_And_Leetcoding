
/*
Lets say you are given the following graph:

                  6 --(2)--> 4 --(3)--> 0 --(2)--> 1 --(1)--> 3
                (3)↓        ↑ ↓(1)                            ↑
                  5 ---(1)--↑ 2 ------------(3)-------------- ↑


The stuff is brackets are the weights
n=7
m=8
src = 6

6 ---> 4 (Weight 2)
4 ---> 0 (Weight 3)
0 ---> 1 (Weight 2)
1 ---> 3 (Weight 1)
6 ---> 5 (Weight 3)
5 ---> 4 (Weight 1)
4 ---> 2 (Weight 1)
2 ---> 3 (Weight 3)
*/
import java.util.*;

public class Part_27_Shortest_Path_In_Directed_Acyclic_Weighted_Graph {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the number of nodes: ");
    int n = input.nextInt();
    System.out.println("Enter the number of edges: ");
    int m = input.nextInt();

    ArrayList<ArrayList<int[]>> adj = makeAdjacencyListOfDirectedWeightedGraph(n, m, input);
    displayAdjacencyListOfDirectedWeightedGraph(adj);

    Stack<Integer> st = getTopoSortStack(n, adj);

    System.out.println("Enter the source from which you want the distances to calculate: ");
    int src = input.nextInt();

    input.close();
    int[] shortestDistances = computeShortestPathInDAG(n, src, adj, st);
    System.out.println(Arrays.toString(shortestDistances));
  }

  public static int[] computeShortestPathInDAG(int n, int src, ArrayList<ArrayList<int[]>> adj,Stack<Integer> st) {
    int[] distances = new int[n];
    for (int i = 0; i < distances.length; i++) {
      distances[i] = Integer.MAX_VALUE;
    }

    distances[src] = 0;

    while (!st.isEmpty()) {
      int val = st.peek();
      if (val == src) {
        break;
      }
      distances[val] = -1; // not reachable
      st.pop();
    }
    while (!st.isEmpty()) {
      int val = st.pop();
      int totalDistanceSoFar = distances[val];
      computeShortestPathInDAGHelper(adj, distances, st, val, totalDistanceSoFar);
    }
    return distances;
  }

  public static void computeShortestPathInDAGHelper(ArrayList<ArrayList<int[]>> adj, int[] distances, Stack<Integer> st,
      int node, int totalDistanceSoFar) {

    ArrayList<int[]> list = adj.get(node);
    for (int i = 0; i < list.size(); i++) {
      int newNode = list.get(i)[0];
      int newDistance = list.get(i)[1];
      distances[newNode] = Math.min(distances[newNode], totalDistanceSoFar + newDistance);
    }
  }

  public static Stack<Integer> getTopoSortStack(int n, ArrayList<ArrayList<int[]>> adj) {
    Stack<Integer> st = new Stack<>();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(adj, visited, st, i);
      }
    }
    return st;
  }

  public static void dfs(ArrayList<ArrayList<int[]>> adj, boolean[] visited, Stack<Integer> st, int node) {
    visited[node] = true;

    ArrayList<int[]> list = adj.get(node);
    for (int i = 0; i < list.size(); i++) {
      int[] arr = list.get(i);
      if (!visited[arr[0]]) {
        dfs(adj, visited, st, arr[0]);
      }
    }
    st.push(node);
  }

  // 0-based indexing
  public static ArrayList<ArrayList<int[]>> makeAdjacencyListOfDirectedWeightedGraph(int n, int m, Scanner input) {
    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      System.out.println("Enter the edge like node1(space)node2(space)weight : ");
      if (i == 0) {
        input.nextLine();
      }

      String userInput = input.nextLine();
      String[] parts = userInput.split(" ");
      if (parts.length == 3) {
        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        int weight = Integer.parseInt(parts[2]);
        int[] list = new int[2];
        list[0] = second;
        list[1] = weight;
        adj.get(first).add(list);
      } else {
        System.out.println("Input form Invalid... Enter the edge like node1(space)node2(space)weight : ");
        i--;
      }
    }
    return adj;
  }

  public static void displayAdjacencyListOfDirectedWeightedGraph(ArrayList<ArrayList<int[]>> adj) {
    for (int i = 0; i < adj.size(); i++) {
      ArrayList<int[]> list = adj.get(i);

      // Check if there are edges for the current node
      if (!list.isEmpty()) {
        System.out.print(i + " ---> {");
        for (int j = 0; j < list.size(); j++) {
          System.out.print("[" + list.get(j)[0] + "," + list.get(j)[1] + "]");
          if (j < list.size() - 1) {
            System.out.print(", ");
          }
        }
        System.out.println("}");
      }
    }
  }
}
