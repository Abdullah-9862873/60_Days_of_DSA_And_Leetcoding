import java.util.*;

public class Video_36_NQueen{
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        printNQueen(0,n,chess);
    }
    public static boolean isSafeToPlace(int[][] chess, int row, int col){
        // Checking the left side
        for(int i=row, j=col; j>=0; j--){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the right side
        for(int i=row,j=col; j<chess.length; j++){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the up side
        for(int i=row,j=col; i>=0; i--){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the down side
        for(int i=row,j=col;i<chess.length;i++){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the up left diagonal
        for(int i=row,j=col; i>=0 && j >=0; i--,j--){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the up right diagonal
        for(int i=row,j=col; i>=0 && j<chess.length; i--,j++){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the down left diagonal
        for(int i=row,j=col; i<chess.length && j>=0; i++,j--){
            if(chess[i][j] > 0){
                return false;
            }
        }

        // Checking the down right diagonal
        for(int i=row,j=col; i<chess.length&&j<chess.length; i++,j++){
            if(chess[i][j] > 0){
                return false;
            }
        }
        return true;
    }
    public static void printNQueen(int queenPlacedSoFar, int totalQueens, int[][] chess){
        if(queenPlacedSoFar == totalQueens){
            for(int[] temp : chess){
                System.out.println(Arrays.toString(temp));
            }
            System.out.println("________________________________");
            return;
        }
        for(int cell=0; cell<chess.length*chess.length; cell++){
            int row = cell / chess.length;
            int col = cell % chess.length;

            if(chess[row][col] == 0 && isSafeToPlace(chess, row, col)){
                chess[row][col] = queenPlacedSoFar+1;
                printNQueen(queenPlacedSoFar+1, totalQueens, chess);
                chess[row][col] = 0;
            }
        }
    }
}