import java.util.*;
public class Video7_Sudoku_Solver {
    public static void main(String[] args) {
        int[][] arr = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 },
        };

        if(solve(arr, 0, 0)){
            display(arr);
        }
    }

    public static boolean solve(int[][] arr, int row, int col) {
        if(row >= arr.length){
            return true;
        }
        else if(col >= arr.length){
            return solve(arr, row+1, 0);
        }
        
        if(arr[row][col] != 0){
            return solve(arr, row, col+1);
        }

        for(int i=1; i<=9; i++){
            if(isSafeToPlace(arr, row, col, i)){
                arr[row][col] = i;
                if(solve(arr, row, col+1)){
                    return true;
                }
            }
            arr[row][col] = 0;
        }
        return false;
    }

    // Returns true when it is safe to place that number in the arr[row][col]
    public static boolean isSafeToPlace(int[][] arr, int row, int col, int number) {
        boolean gridSafety = isGridSafe(arr, row, col, number);
        boolean rowSafety = isRowSafe(arr, row, col, number);
        boolean colSafety = isColSafe(arr, row, col, number);

        return gridSafety && rowSafety && colSafety;
    }

    // For Grid Safety
    public static boolean isGridSafe(int[][] arr, int row, int col, int number) {
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (arr[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    // For Row Safety
    public static boolean isRowSafe(int[][] arr, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == number) {
                return false;
            }
        }
        return true;
    }

    // For Column Safety
    public static boolean isColSafe(int[][] arr, int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == number) {
                return false;
            }
        }
        return true;
    }
    public static void display(int[][] arr){
        for(int[] temp : arr){
            System.out.println(Arrays.toString(temp));
        }
    }
}