// Method used in placing items on the levels
import java.util.*;

public class Video_30_QueenPermutation_and_QueenCombination {
    public static void main(String[] args) {
        // For Permutation call
        // int queensPlaced = 0;
        // int totalQueens = 4;
        // String[][] chess = new String[totalQueens][totalQueens];
        // printQueensPermutation(chess, totalQueens, queensPlaced);

        // For Combination call
        int totalQueens = 4;
        boolean[][] chess = new boolean[totalQueens][totalQueens];
        int queensPlaced = 0;
        int row = 0;
        int col = -1;
        printQueenCombination(chess, totalQueens, queensPlaced, row, col);
    }
    
    public static void printQueensPermutation(String[][] chess, int totalQueens, int queensPlaced) {
        if (queensPlaced == totalQueens) {
            for (String[] row : chess) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            System.out.println("__________________");
            System.out.println();
            return;
        }
        
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                if (chess[i][j] == null) {  
                    chess[i][j] = "Q" + (queensPlaced+1);
                    printQueensPermutation(chess, totalQueens, queensPlaced + 1);
                    chess[i][j] = null;  
                }
            }
        }
    }

    public static void printQueenCombination(boolean[][] chess, int totalQueens, int queensPlaced, int row, int col){
        if(queensPlaced == totalQueens){
            for(boolean[] temp: chess){
                System.out.println(Arrays.toString(temp));
            }
            System.out.println();
            System.out.println("_________________________________");
            System.out.println();
            return;
        }

        //If I have placed a queen somewhere then I can only placed the rest of them after that queen
        for(int i=col+1; i<chess.length; i++){
            if(chess[row][i] == false){
                chess[row][i] = true;
                printQueenCombination(chess, totalQueens, queensPlaced+1, row, i);
                chess[row][i] = false;
            }
        }


        // Now If none queen has placed yet then row will be at the start and col will be first
        // Here -1 is passed in the col which denotes none of the queen is placed yet
        // And I have started from row+1 because the first row has been taken care of by the first loop
        for(int i=row+1; i<chess.length; i++){
            for(int j=0; j<chess.length; j++){
                if(chess[i][j] == false){
                    chess[i][j] = true;
                    printQueenCombination(chess, totalQueens, queensPlaced+1,i,j);
                    chess[i][j] = false;
                }
            }
        }
    }
}
