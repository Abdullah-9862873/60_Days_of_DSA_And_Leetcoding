import java.util.Arrays;

public class Video53_Knights_Tour {
    public static void main(String[] args) {
        int n = 6;
        int[][] arr = new int[n][n];
        knightsTour(arr, 3, 3, 1);
    }
    public static void knightsTour(int[][] arr, int row, int col, int move){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr.length || arr[row][col] > 0){
            return;
        }else if(move == arr.length * arr.length){
            arr[row][col] = move;
            displayBoard(arr);
            arr[row][col] = 0;
            return;
        }

        // At every point then can be only eight positions where the knight can move
        arr[row][col] = move;
        knightsTour(arr, row-2, col+1, move+1);
        knightsTour(arr, row-1, col+2, move+1);
        knightsTour(arr, row+1, col+2, move+1);
        knightsTour(arr, row+2, col+1, move+1);
        knightsTour(arr, row+2, col-1, move+1);
        knightsTour(arr, row+1, col-2, move+1);
        knightsTour(arr, row-1, col-2, move+1);
        knightsTour(arr, row-2, col-1, move+1);
        arr[row][col] = 0;
    }
    public static void displayBoard(int[][] arr){
        for(int[] temp : arr){
            System.out.println(Arrays.toString(temp));
        }
        System.out.println("_______________________________");
        return;
    }
}

/*
The question is that you are given a chess board of nxn and in that board you are given a position where one knight is standing... Now you have to make that knight take a tour of the whole board and see if that knight can visit each and every position of the board and if it can then you have to display the board...
 */
