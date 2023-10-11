import java.util.*;

public class Video37_N_Knights {
    public static void main(String[] args) {
        int totalKnights = 4;
        int knightsPlacedSoFar = 0;
        int lastOccurenceOfKnight = 0;
        boolean[][] chess = new boolean[totalKnights][totalKnights];
        printNKnightPositions(chess, knightsPlacedSoFar, totalKnights, lastOccurenceOfKnight);
    }
    public static void printNKnightPositions(boolean[][] chess, int knightsPlacedSoFar, int totalKnights, int lastOccurenceOfKnight){
        if(knightsPlacedSoFar == totalKnights){
            for(boolean[] temp : chess){
                System.out.println(Arrays.toString(temp));
            }
            System.out.println();
            System.out.println("_________________________");
            System.out.println();
            return;
        }
        for(int i=lastOccurenceOfKnight+1; i<chess.length * chess.length; i++){
            int row = i / chess.length;
            int col = i % chess.length;

            if(chess[row][col] == false && isSafeToPlace(chess, row, col)){
                chess[row][col] = true;
                printNKnightPositions(chess, knightsPlacedSoFar+1, totalKnights, row*chess.length+col);
                chess[row][col] = false;
            }
        }
    }
    public static boolean isSafeToPlace(boolean[][] chess, int row, int col){
        if(row-1 >=0 && col-2 >= 0 && chess[row-1][col-2] == true){
            return false;
        }
        if(row-2>=0 && col+1 < chess.length && chess[row-2][col+1] == true){
            return false;
        }
        if(row-2>=0 && col-1>=0 && chess[row-2][col-1] == true){
            return false;
        }
        if(row-1>=0 && col+2 < chess.length && chess[row-1][col+2] == true){
            return false;
        }
        return true;
    }
}
