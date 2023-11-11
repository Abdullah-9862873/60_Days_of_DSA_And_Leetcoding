// Optimizing the items on levels queen combination code
import java.util.*;

public class Video34_QueensCombination_Treating2D_as_1D {
    public static void main(String[] args) {
        int totalQueens = 4;
        int queensPlacedSoFar = 0;
        boolean[][] chess = new boolean[totalQueens][totalQueens];
        printQueenCombination(chess, totalQueens, queensPlacedSoFar, 0);
    }
    public static void printQueenCombination(boolean[][] chess, int totalQueens, int queensPlacedSoFar, int currentCell){
        if(totalQueens == queensPlacedSoFar){
            for(boolean[] temp: chess){
                System.out.println(Arrays.toString(temp));
            }
            System.out.println();
            System.out.println("_______________________________");
            System.out.println();
            return;
        }

        for(int cell = currentCell+1; cell < chess.length*chess.length; cell++){
            int row = cell / chess.length;
            int col = cell % chess.length;

            chess[row][col] = true;
            printQueenCombination(chess, totalQueens, queensPlacedSoFar+1, cell);
            chess[row][col] = false;
        }
    }
}
