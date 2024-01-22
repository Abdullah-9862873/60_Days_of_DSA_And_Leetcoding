/*
You'll be given a 2D matrix

[
    [1,2],
    [4,3],
    [2,4],
    [4,1],
]

There should be a condition satisfaction that the values written in the first index must be before the values written in the second index...

1 before 2 ------> states yes we can write it as (1 2)
4 before 3 ------> states yes we can write them as (1 2 4 3)
2 before 4 ------> states yes we can write them as (1 2 4 3)
4 before 1 ------> Condition overlaps so no 

Because there cannot be the case that we write 4 before 1 && 1 before 2 && 2 before 4

So we will return false

___________________________________________________________
[
    [1,0],
    [2,1],
    [3,2],
]

Yes because condition satisfies
*/

import java.util.*;
public class Part_24_Course_Schedule_1_and_2_And_PreRequisite_Tasks {
    public static void main(String[] args) {
        // int[][] matrix = {
        //     {1,2},
        //     {4,3},
        //     {2,4},
        //     {4,1},
        // };
        // int N=4;
        
        int[][] matrix = {
            {1,2},
            {3,4},
            {4,5},
            {5,6},
        };
        int N=6;

        boolean ans = findAns(matrix, N);
        if(ans){
            System.out.println("Yes Condition Satisfies");
        }else{
            System.out.println("No Condition does not satisfy");
        }
    }
    public static boolean findAns(int[][] matrix, int n){
        // Creating adjacency list graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<matrix.length; i++){
            int first = matrix[i][0];
            int second = matrix[i][1];
            adj.get(first).add(second);
        }

        
        boolean cyclePresent = isCyclePresent(adj, n);
        if(cyclePresent){
            return false;
        }
        return true;
    }

    public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adj, int n){
        ArrayList<Integer> list = topologicalSort(n, adj);
        if(list.size() < n){
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> topologicalSort(int n, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] inDegrees = new int[n+1];
        for(int i=1; i<=n; i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0; j<arr.size(); j++){
                inDegrees[arr.get(j)]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<inDegrees.length; i++){
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
