/*
Uses:
---> Used to find the shortest paths
---> Is not applicable for negative edge values... Because it will fall in an infinite loop...

Ways to Apply it:
1) Using Queue ---> Done in Part 28
2) Using Priority Queue ---> Done in this video
3) Using Sets

Sets is the best among them... then comes the PQ and then the Queue... Reason is in the later parts

______________________________________________
Why not Queue and Why Priority Queue?
Using Queue will work perfectly but it will be some time wasting because when using queue it will not follow the greedy path to firstly enter the queue with shortest paths and then we dont have to deal with the longer paths... Rather queue will make some longer paths to enter the queue first before the actual fruitful shortest paths... And then we have to compute for the longer paths as well which will be time consuming... But using priority queue we will greedily follow the shortest paths first so when it comes to follow the longer paths the algorithm will say that the distances[newNode] value is smaller than what you are going to compute so stop it here rather than going forward and adding things in the queue...
______________________________________________
Time Complexity: O(E log V)
where E are the edges and V are the nodes

----------------Derivation----------------
Time Complexity here is: O(V x (Pop from Queue + (No of edges of popped node x push to queue)))


----> O(V x (log(HeapSize) + (NoOfEdges x log(heapSize))))
----> O(V x (log(HeapSize) NoOfEdges+1))
As number of edges in worst case can be totalNodes-1 if all nodes are connected to eachother... which is densed graph

----> O(V x (log(HeapSize) V-1+1))
----> O(V x (log(HeapSize) V))
----> O(V^2 x (log(HeapSize)))
----> O(V^2 x (log(HeapSize)))

HeapSize in worst case can be (v^2) if in densed graph every nodes result comes out to be fruitful

----> O(V^2 x (log(V^2)))
----> O(V^2 x (2LogV))
Now V^2 is equal to the number of edges in worst case... As there are (v-1) total edges of V nodes so it will be (v-1xv == v2) which are the total number of edges E

----> O(E x 2LogV)
----> O(E Log V)
______________________________________________


Lets say you have the following graph

                0 ----- 2 ------- 3
                |     / | \       |  
                |    /  |  \      |
                |   /   |   \     | 
                |  /    |    \    |
                | /     |     \   |
                |/      |      \  |
                1       4 ------- 5

n=6
m=8
src=0

0 ---- 2 (Weight 4)
0 ---- 1 (Weight 4)
1 ---- 2 (Weight 2)
2 ---- 3 (Weight 3)
2 ---- 4 (Weight 1)
2 ---- 5 (Weight 6)
3 ---- 5 (Weight 2)
4 ---- 5 (Weight 3)

*/

import java.util.*;

public class Part_32_Dijkstras_Algorithm_Using_Priority_Queue {
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
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of Edges: ");
        int m = input.nextInt();

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

        System.out.println("Enter the source from which you want the distances to find: ");
        int src = input.nextInt();
        input.close();

        int[] distances = applyDijkstraAlgorithmOfPriorityQueue(adj,src);
        System.out.println(Arrays.toString(distances));
    }

    public static int[] applyDijkstraAlgorithmOfPriorityQueue(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src){
        int[] distances = new int[adj.size()];
        for(int i=0; i<distances.length; i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance - b.distance);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int node = top.node;
            int weight = top.distance;

            ArrayList<ArrayList<Integer>> list = adj.get(node);
            for(int i=0; i<list.size(); i++){
                int newNode = list.get(i).get(0);
                int newNodeWeight = list.get(i).get(1);

                if(distances[newNode] > weight+newNodeWeight){
                    distances[newNode] = weight + newNodeWeight;
                    pq.add(new Pair(newNode,weight+newNodeWeight));
                }
            }
        }

        return distances;        
    }

    // 0- based indexing
    public static ArrayList<ArrayList<ArrayList<Integer>>> makeAdjacencyListOfUnDirectedWeightedGraph(int n, int m,
            Scanner input) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
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
                i--;
            }
        }

        return adj;
    }

    public static void displayAdjacencyListOfUnDirectedWeightedGraph(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        for (int i = 0; i < adj.size(); i++) {
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
