/*
Topological Sorting:
---> Linear Ordering of vertices such that if there is an edge between u and v, u appears before v in that ordering...

---> It is Applied only to DAG (Directed Acyclic Graph)

Example Graph

                        5 → 0 ← 4
                        ↓       ↓
                        2 → 3 → 1

n = 6
m = 6

Valid orderings can be
1) 5 4 2 3 1 0
2) 4 5 2 3 1 0

*/
import java.util.*;

public class Part_22_Topological_Sort_Algorithm_Using_BFS_Kahns_Algorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfDirectedGraph(n, m, input);
        displayDirectedGraphOfAdjacencyList(adj);

        input.close();

        ArrayList<Integer> arr= topologicalSort(n,m,adj);
        System.out.println(arr);
    }

    public static ArrayList<Integer> topologicalSort(int n, int m, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegrees = new int[n];
        for(int i=0; i<n; i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0; j<arr.size(); j++){
                inDegrees[arr.get(j)]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<inDegrees.length; i++){
            if(inDegrees[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int top = q.remove();
            ans.add(top);

            ArrayList<Integer> list = adj.get(top);
            for(int i=0; i<list.size(); i++){
                int num = list.get(i);
                inDegrees[num]--;
                if(inDegrees[num] == 0){
                    q.add(num);
                }
            }
        }
        return ans;
    }
    // 0-based indexing
    public static ArrayList<ArrayList<Integer>> makeAdjacencyListOfDirectedGraph(int n, int m, Scanner input) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
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
    public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for(ArrayList<Integer> temp: adj){
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copied.add(copyList);
        }

        for (int i = 0; i < copied.size(); i++) {
            ArrayList<Integer> arr = copied.get(i);
            for(int j=0; j<arr.size(); j++){
                System.out.println(i + " ---> " + copied.get(i).get(j));
            }
        }
    }
}
