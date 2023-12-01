
/*
Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

*/
import java.util.*;

public class Part_16_Number_of_Distinct_Islands {
    public static int[] dRow = { -1, 0, 1, 0 };
    public static int[] dCol = { 0, -1, 0, +1 };

    public static String convertToString(int val1, int val2) {
        return (Integer.toString(val1) + " " + Integer.toString(val2));
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 0 },
        };
        int ans = countDistinctIslands(grid);
        System.out.println("The number of distinct islands are: " + ans);
    }

    public static int countDistinctIslands(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> arr = new ArrayList<>();
                    int baseRow = i;
                    int baseCol = j;
                    dfsTraversal(grid, visited, arr, i, j, baseRow, baseCol);
                    set.add(arr);
                }
            }
        }
        return set.size();
    }

    public static void dfsTraversal(int[][] grid, int[][] visited, ArrayList<String> arr, int row, int col, int baseRow,
            int baseCol) {

        visited[row][col] = 1;
        String str = convertToString(row - baseRow, col - baseCol);
        arr.add(str);

        for (int i = 0; i < 4; i++) {
            int adjx = row + dRow[i];
            int adjy = col + dCol[i];

            if (isValid(grid, visited, adjx, adjy)) {
                dfsTraversal(grid, visited, arr, adjx, adjy, baseRow, baseCol);
            }
        }
    }

    public static boolean isValid(int[][] grid, int[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) {
            return false;
        }
        if (visited[row][col] == 0 && grid[row][col] == 1) {
            return true;
        }
        return false;
    }
    
}
