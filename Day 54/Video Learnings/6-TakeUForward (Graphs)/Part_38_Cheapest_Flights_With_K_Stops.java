// /*

//                 0 --- 1 --- 2
//                  \   / \   /
//                   \ /   \ /
//                    3     4

// n=5
// m=6

// 0 ----> 1 (Weight 5)
// 0 ----> 3 (Weight 2)
// 1 ----> 2 (Weight 5)
// 3 ----> 1 (Weight 2)
// 1 ----> 4 (Weight 1)
// 4 ----> 2 (Weight 1)


// */
import java.util.*;

public class Part_38_Cheapest_Flights_With_K_Stops {
    public static class Tuple{
        int stop;
        int node;
        int price;

        public Tuple(int val1, int val2, int val3){
            this.stop = val1;
            this.node = val2;
            this.price = val3;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = makeAdjacencyListOfDirectedWeightedGraph(n, m, input);
        displayAdjacencyListOfUnDirectedWeightedGraph(adj);
        
        System.out.println("Enter the value of Stops (K): ");
        int k = input.nextInt();
        System.out.println("Enter the source node: ");
        int cheapestPrice = getCheapestPriceWithinKStops(adj,k);
        System.out.println("Cheapest Price will be: " + cheapestPrice);

        input.close();
    }

    public static int getCheapestPriceWithinKStops(ArrayList<ArrayList<ArrayList<Integer>>> adj, int k){
        int[] prices = new int[adj.size()];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[0] = 0;

        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(0,0,0));

        while(!q.isEmpty()){
            Tuple top = q.remove();
            int stop = top.stop;      
            int node = top.node;
            int price = top.price;

            if(stop > k){
                continue;
            }

            ArrayList<ArrayList<Integer>> list = adj.get(node);
            for(int i=0; i<list.size(); i++){
                int newStop = stop + 1;    
                int newPrice = price + list.get(i).get(1);
                int newNode = list.get(i).get(0);

                if(stop <= k && newPrice < prices[newNode]){
                    prices[newNode] = newPrice;
                    q.add(new Tuple(newStop,newNode,newPrice));
                }
            }
        }
        if(prices[2] == Integer.MAX_VALUE){
            return -1;
        }
        return prices[2];
    }

    // 0- based indexing
    public static ArrayList<ArrayList<ArrayList<Integer>>> makeAdjacencyListOfDirectedWeightedGraph(int n, int m, Scanner input) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <n; i++) {
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
                System.out.println("Invalid Input Form...Enter the edge and weight like node1(space)node2(space)weight");
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


