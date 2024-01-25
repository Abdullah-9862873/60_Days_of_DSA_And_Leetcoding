/*
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node). 


Let's say you are having following graph:


                    1   →   2   →   3   →   4
                            ↑       ↓       ↓
                            8 → 9   7   →   5  →  6
                            ↑   ↓
                             ← 10 ← 11

n=11
m=12

The idea is that 
---> Where there is a cycle there cannot be a safeNode
---> The nodes that are associated with the cycle will never be the safeNode

---> Rest of the nodes are all safeNodes 

The idea of solution is:
----> We will reverse the edges and then the edge with 0 inDegree will be our terminal node...

*/

import java.util.*;

public class Part_25_Find_Eventual_Safe_States_Using_Topological_Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        ArrayList<ArrayList<Integer>> adj = makeAdjacencyListOfDirectedGraph(n, m, input);
        displayDirectedGraphOfAdjacencyList(adj);
        System.out.println("___________________________");
        input.close();

        ArrayList<Integer> safeNodes = getSafeNodes(adj, n, m);
        System.out.println(safeNodes);
    }

    public static ArrayList<Integer> getSafeNodes(ArrayList<ArrayList<Integer>> adj, int n, int m) {
        // Reversing the edges
        adj = reverseEdges(adj);

        int[] inDegrees = new int[n + 1];
        for (int i = 1; i < adj.size(); i++) {
            ArrayList<Integer> list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                int element = list.get(j);
                inDegrees[element]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int top = q.remove();
            ans.add(top);

            ArrayList<Integer> list = adj.get(top);
            for (int i = 0; i < list.size(); i++) {
                int element = list.get(i);
                if (inDegrees[element] > 0) {
                    inDegrees[element]--;
                }
                if (inDegrees[element] == 0) {
                    q.add(element);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> reverseEdges(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            reversedAdj.add(new ArrayList<>());
        }

        for (int i = 1; i < adj.size(); i++) {
            ArrayList<Integer> list = adj.get(i);
            for (int j = 0; j < list.size(); j++) {
                int element = list.get(j);
                reversedAdj.get(element).add(i);
            }
        }
        return reversedAdj;
    }

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
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        return adj;
    }

    public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> copied = new ArrayList<>();

        for (ArrayList<Integer> temp : adj) {
            ArrayList<Integer> copyList = new ArrayList<>(temp);
            copied.add(copyList);
        }

        for (int i = 1; i < copied.size(); i++) {
            ArrayList<Integer> arr = copied.get(i);
            for (int j = 0; j < arr.size(); j++) {
                System.out.println(i + " ---> " + copied.get(i).get(j));
            }
        }
    }
}
