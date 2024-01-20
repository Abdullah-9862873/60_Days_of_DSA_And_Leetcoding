
/*
Lets say we have the following graph:

          4---3
         /|\  |\
        5 | \ | \ 6 
         \|  \| /
          1---2

n = 6
m = 9

5 --- 4 (Weight 9)
5 --- 1 (Weight 4)
4 --- 1 (Weight 1)
4 --- 3 (Weight 5)
4 --- 2 (Weight 3)
1 --- 2 (Weight 2)
2 --- 3 (Weight 3)
3 --- 6 (Weight 8)
2 --- 6 (Weight 7)

Thought Process of Kruskal:
----> Sort all the edges with respect to weight in increasing order
----> Pick the first one which will ultimately be the one with the lowest weight and see if both of its nodes have the same parent or not... If they have different parent that means they are not connected so connect them and go on...


*/
import java.util.*;

public class Part_47_Kruskal_Algorithm_Finding_Minimum_Spanning_Tree {
    public static class Tuple{
        int firstNode;
        int secondNode;
        int wt;

        public Tuple(int val1, int val2, int val3){
            this.firstNode = val1;
            this.secondNode = val2;
            this.wt = val3;
        }
    }
    public static class DisjointSet {
        int[] rank;
        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            rank = new int[n + 1];
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < size.length; i++) {
                size[i] = 1;
            }

        }

        int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]); // Doing path Compression by assigning the ultimate parent as parent of every under node
        }

        void unionByRank(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }

        void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size[ulp_u] < size[ulp_v]) {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            } else {
                parent[ulp_v] = ulp_u;
                size[ulp_u] += size[ulp_v];
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = makeAdjacencyListOfUndirectedWeightedGraph(n, m, input);
        displayAdjacencyListOfUndirectedWeightedGraph(adj);

        input.close();

        int minSumSpanningTree = findMinSpanningTreeUsingKruskal(n, adj);
        System.out.println("Minimum Sum of Spanning Tree is: " + minSumSpanningTree);
    }

    public static int findMinSpanningTreeUsingKruskal(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Sort the edges with respect to increasing order of weight
        ArrayList<Tuple> list = new ArrayList<>();
        list = sortEdgesWrtWeight(adj);

        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        
        DisjointSet ds = new DisjointSet(n);
        int sum = 0;
        
        for(int i=0; i<list.size(); i++){
            Tuple top = list.get(i);
            int weight = top.wt;
            int u = top.firstNode;
            int v = top.secondNode;


            if(ds.findUltimateParent(u) != ds.findUltimateParent(v)){
                // They do not belong to one component
                ds.unionByRank(u,v);
                sum += weight;
                mst.add(new ArrayList<>(Arrays.asList(u,v)));
            }
        }
        // Printing MST
        System.out.print("Mst is: ");
        for(ArrayList<Integer> temp: mst){
            System.out.print(temp + " ");
        }
        System.out.println();

        return sum;
    }

    // 1-based indexing
public static ArrayList<Tuple> sortEdgesWrtWeight(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    ArrayList<Tuple> arr = new ArrayList<>();

    for (int i = 1; i < adj.size(); i++) {
        int node1 = i;
        for (ArrayList<Integer> edge : adj.get(i)) {
            int node2 = edge.get(0);
            int weight = edge.get(1);

            boolean edgeExists = arr.stream()
                .anyMatch(t -> (t.firstNode == node1 && t.secondNode == node2) ||
                               (t.firstNode == node2 && t.secondNode == node1));

            if (!edgeExists) {
                arr.add(new Tuple(node1, node2, weight));
            }
        }
    }

    Collections.sort(arr, Comparator.comparingInt(o -> o.wt));
    return arr;
}


    // 1- based indexing
    public static ArrayList<ArrayList<ArrayList<Integer>>> makeAdjacencyListOfUndirectedWeightedGraph(int n, int m,
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

    public static void displayAdjacencyListOfUndirectedWeightedGraph(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
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
