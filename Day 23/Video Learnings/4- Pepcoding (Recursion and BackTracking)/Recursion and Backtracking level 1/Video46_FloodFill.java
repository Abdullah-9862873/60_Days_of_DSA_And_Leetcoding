public class Video46_FloodFill {
    public static void main(String[] args) {
        int[][] arr = {
            {0, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0}
        };
        boolean[][] visitedOrNot = new boolean[arr.length][arr[0].length];
        printPath(arr, visitedOrNot, 0, 0, "");
    }
    
    public static void printPath(int[][] arr, boolean[][] visitedOrNot, int row, int col, String ans){
        if(arr.length == 0 || row < 0 || col >= arr[0].length || row >= arr.length || col < 0 || visitedOrNot[row][col] || arr[row][col] == 1){
            return;
        }

        if(row == arr.length-1 && col == arr[0].length-1){
            System.out.println(ans);
            return;
        }

        visitedOrNot[row][col] = true;
        printPath(arr, visitedOrNot, row-1, col, ans + "T");
        printPath(arr, visitedOrNot, row, col-1, ans + "L");
        printPath(arr, visitedOrNot, row+1, col, ans + "D");
        printPath(arr, visitedOrNot, row, col+1, ans + "R");

        visitedOrNot[row][col] = false;
    }
}
