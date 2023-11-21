/*
____________________________________________________________________________
--------------------How Inputs will be Given--------------------
Inputs will be given as... You'll be given N and M... N represents number of nodes and M represents the number of edges...

After that you'll ask the edges Lets say you are given N=5 and M=6 and lets say following are the edges
1 2
1 3
3 4
2 4
2 5
4 5

And they are lets say undirected graph
____________________________________________________________________________

--------------------Graph Representation in Java--------------------
----> There are two ways to represent a graph:
1) Adjacency Matrix
2) Adjacency List

____________________________________________________________________________

--------------------To Store this undirected graph in Adjacency Matrix--------------------
----> Firstly we have to know that whether it is a 1-based indexing graph...As it is starting from 1 so yeah it is one based indexing graph... So we'll make a matrix of [n+1][n+1]

----> Now the (n+1) is because we have to store 5 too... And then lets say the edge was (1 2) then arr[1][2] and arr[2][1] both will be given 1... Lets say the edge was (2 5) then arr[2][5] and arr[5][2] will have 1 inside and similarly all the other stuff...

----> The other spaces will have 0 inside of them which represents no edge...

Time Complexity---> O(N^2)
Space Complexity---> O(N^2)
So the formula is basically

____________________________________________________________________________

----------------Code To Store this undirected graph in Adjacency Matrix--------------

arr[u][v] = 1
arr[v][u] = 1

int n = 3;
        int m = 3;
        int[][] arr = new int[n+1][n+1];

        // edge 1 --- 2
        arr[1][2] = 1;
        arr[2][1] = 1;

        // edge 2 --- 3
        arr[2][3] = 1;
        arr[3][2] = 1;

        // edge 1 --- 3
        arr[1][3] = 1;
        arr[3][1] = 1;

____________________________________________________________________________

--------------------To Store this undirected graph in Adjacency List--------------------
----> Firstly we will declare 
ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

----> Now for n = 3 we will add n+1 that is four array lists into it like
for(int i=0; i<=n; i++){
    adj.add(new ArrayList<Integer>);
}

Now our arraylist will be something like it has an array list at 0,1,2,3 indexes

And if lets say 1 has an edge to 2 and 3 like 
1---2
1---3

Then the adj at index 1 will contain an arraylist like {2,3}

Similarly if 3 has an edge to 1 and 2 like
3 --- 2
3 --- 1

Then the adj at index 3 will contain an arraylist like {2,1} at any order you can also store {1,2}

Time Complexity ----> O(M)
Space Complexity ----> O(N + M)

____________________________________________________________________________

----------------Code to Store this undirected graph in Adjacency List------------

int n = 3;
int m = 3;
ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

for(int i=0; i<=n; i++){
    adj.add(new ArrayList<Integer>);
}
    // edge 1 --- 2
    adj.get(1).add(2);
    adj.get(2).add(1);

    // edge 2 --- 3
    adj.get(2).add(3);
    adj.get(3).add(2);

    // Print all the edges
    for (int i = 1; i < adj.size(); i++) {
            System.out.print("Edges for vertex " + i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                int neighbor = adj.get(i).get(j);
                System.out.print("(" + i + " --- " + neighbor + ") ");
            }
            System.out.println();
        }
    }
____________________________________________________________________________

---------------To Store this undirected weighted graph in Adjacency Matrix-------------

---> Here we will do the exact same thing that we have done for the adjacency unweighted graph matrix but the slight change is instead of storing 1 at a place where there is an edge we will store the weight...

So if 
1---2   has a weight of 5

Then arr[1][2] = 5 and arr[2][1] = 5

____________________________________________________________________________

---------------To Store this undirected weighted graph in Adjacency List-------------

---> Here we will do the exact same thing that we have done for the adjacency unweighted graph list but the slight change is instead of storing something like the following

For edge (1 -- 2)(1 -- 3)
For edge (2 -- 1)(2 -- 4)

Index 1 ---- {2,3}
Index 2 ---- {1, 4}
Index 3 ---- {1}

Lets say the weights were 
(1 -- 2) has weight 6
(1 -- 3) has weight 7
(2 -- 4) has weight 4

Index 1 ---- {(2,6), (3,7)}
Index 2 ---- {(1,6), (4,4)}
Index 3 ---- {(1,7)}

So we will have something like ArrayList<ArrayList<Pair<int,int>>>
____________________________________________________________________________

Time Complexity of Adjacency Matrix: O(N^2)
Space  Complexity of Adjacency Matrix: O(N^2)

Time Complexity of Adjacency List: O(N + M)
Space  Complexity of Adjacency List: O(N + M)

Where N are the number of nodes and M are the number of edges


*/

// Undirected Graph

import java.util.*;

public class Part_03_Graph_Representation_In_Java {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = input.nextInt();

        System.out.println("Enter the number of edges: ");
        int m = input.nextInt();

        System.out.println("Press 1 for Directed Graph and 2 for Undirected Graph");
        String in = input.next();
        if (in.equalsIgnoreCase("1")) {
            System.out.println("Press 1 for using Adjacency Matrix and 2 for using Adjacency List: ");
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("1")) {
                makeAdjacencyMatrixOfDirectedGraph(n, m, input);
            } else {
                makeAdjacencyListOfDirectedGraph(n, m, input);
            }
        } else {
            System.out.println("Press 1 for using Adjacency Matrix and 2 for using Adjacency List: ");
            String userInput = input.next();
            if (userInput.equalsIgnoreCase("1")) {
                makeAdjacencyMatrixOfUndirectedGraph(n, m, input);
            } else {
                makeAdjacencyListOfUndirectedGraph(n, m, input);
            }
        }

        input.close();
    }

    // Assuming you have 1-based indexing not 0-based indexing that is (first node
    // or vertex of graph is 1 and not 0)
    public static void makeAdjacencyMatrixOfUndirectedGraph(int n, int m, Scanner input) {
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like (node1 node2): ");
            if (i == 0) {
                input.nextLine(); // captures the newLine left in the input buffer after input.nextInt()
            }
            String userInput = input.nextLine();

            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';

                arr[first][second] = 1;
                arr[second][first] = 1;
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        displayUndirectedGraphOfAdjacencyMatrix(arr);
    }

    public static void displayUndirectedGraphOfAdjacencyMatrix(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    visited[j][i] = true;
                    System.out.println(i + " --- " + j);
                }
            }
        }
    }

    // Assuming 1-based indexing
    public static void makeAdjacencyMatrixOfDirectedGraph(int n, int m, Scanner input) {
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the edge like (node1 node2): ");
            if (i == 0) {
                input.nextLine(); // captures the newLine left in the input buffer after input.nextInt()
            }
            String userInput = input.nextLine();

            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';

                arr[first][second] = 1;
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        displayDirectedGraphOfAdjacencyMatrix(arr);
    }

    public static void displayDirectedGraphOfAdjacencyMatrix(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    System.out.println(i + " ---> " + j);
                }
            }
        }
    }

    // Assuming 1-based indexing
    public static void makeAdjacencyListOfUndirectedGraph(int n, int m, Scanner input) {
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
            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';
                adj.get(first).add(second);
                adj.get(second).add(first);
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        displayUndirectedGraphOfAdjacencyList(adj);
    }

    public static void displayUndirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            ArrayList<Integer> arr = adj.get(i);
            while (arr.size() > 0) {
                int j = adj.get(i).get(0);
                System.out.println(i + " --- " + j);
                adj.get(i).remove(0);
                adj.get(j).remove(0);
            }
        }
    }

    // Assuming 1-based indexing
    public static void makeAdjacencyListOfDirectedGraph(int n, int m, Scanner input) {
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
            if (userInput.length() >= 3 && userInput.charAt(1) == ' ') {
                int first = userInput.charAt(0) - '0';
                int second = userInput.charAt(2) - '0';
                adj.get(first).add(second);
            } else {
                System.out.println("Invalid input. Please enter the edge in the format 'node1 node2'");
                i--;
            }
        }
        for (int i = 1; i < adj.size(); i++) {
            Collections.sort(adj.get(i));
        }
        displayDirectedGraphOfAdjacencyList(adj);
    }
    public static void displayDirectedGraphOfAdjacencyList(ArrayList<ArrayList<Integer>> adj){
        for (int i = 1; i < adj.size(); i++) {
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0; j<arr.size(); j++){
                System.out.println(i + " ---> " + adj.get(i).get(j));
            }
        }
    }

}