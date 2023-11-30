/*
Case: BFS Traversal on the matrix with distinct values 

 */
import java.util.*;

public class Part_05_Breadth_First_Search3 {
    public static class Pair {
        int first;
        int second;

        public Pair(int val1, int val2) {
            this.first = val1;
            this.second = val2;
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        String bfsTraversal = bfsTraversal(arr, 0, 0, visited);
        System.out.println(bfsTraversal);
    }

    public static int[] dRow = { -1, 0, 1, 0 };
    public static int[] dCol = { 0, 1, 0, -1 };

    public static boolean isValid(int[][] arr, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[x].length || visited[x][y] == true) {
            return false;
        }
        return true;
    }

    public static String bfsTraversal(int[][] arr, int row, int col, boolean[][] visited) {
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(row, col));
        visited[row][col] = true;
        String str = "";
        while (!q.isEmpty()) {
            Pair cell = q.peek();
            int x = cell.first;
            int y = cell.second;

            str = str + "-" + arr[x][y];
            q.remove();

            // Exploring adjacent cells
            for (int i = 0; i < 4; i++) {
                int adjx = x + dRow[i];
                int adjy = y + dCol[i];

                if (isValid(arr, visited, adjx, adjy)) {
                    q.add(new Pair(adjx, adjy));
                    visited[adjx][adjy] = true;
                }
            }
        }

        return str.substring(1);
    }
}
