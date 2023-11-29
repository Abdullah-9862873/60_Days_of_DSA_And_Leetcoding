// Method used in placing boxes on the levels

import java.util.Arrays;

public class Video_31_Queens_Permutation_and_Combination {
    public static void main(String[] args) {
        // Calling Permutation
        // int totalQueens = 4;
        // int row = 0;
        // int col = 0;
        // int queensPlacedSoFar = 0;
        // String[][] chess = new String[totalQueens][totalQueens];
        // boolean[] used = new boolean[totalQueens];
        // printQueensPermutation(chess,row,col,queensPlacedSoFar, totalQueens, used);

        // Calling Combination
        int totalQueens = 4;
        int row = 0;
        int col = 0;
        int queensPlaced = 0;
        boolean[][] chess = new boolean[totalQueens][totalQueens];
        printQueenCombination(chess, totalQueens, queensPlaced, row, col);
    }

    public static void printQueensPermutation(String[][] chess, int row, int col, int queensPlacedSoFar,
            int totalQueens, boolean[] used) {
        if (row == totalQueens) {
            if (queensPlacedSoFar == totalQueens) {
                for (String[] temp : chess) {
                    System.out.println(Arrays.toString(temp));
                }
                System.out.println();
                System.out.println("___________________________");
                System.out.println();
            }
            return;
        }

        int newRow = 0;
        int newCol = 0;

        if (col == totalQueens - 1) {
            newRow = row + 1;
            newCol = 0;
        } else {
            newRow = row;
            newCol = col + 1;
        }

        for (int i = 0; i < totalQueens; i++) {
            if (used[i] == false) {
                used[i] = true;
                if (chess[i][col] == null) {
                    chess[row][col] = "Q" + (queensPlacedSoFar + 1);
                    printQueensPermutation(chess, newRow, newCol, queensPlacedSoFar + 1, totalQueens, used);
                    chess[row][col] = null;
                }
                used[i] = false;
            }
        }
        printQueensPermutation(chess, newRow, newCol, queensPlacedSoFar, totalQueens, used);
    }

    public static void printQueenCombination(boolean[][] chess, int totalQueens, int queensPlaced, int row, int col) {
        if (row == totalQueens) {
            if (queensPlaced == totalQueens) {
                for (boolean[] temp : chess) {
                    System.out.println(Arrays.toString(temp));
                }
                System.out.println();
                System.out.println("__________________________");
                System.out.println();
            }
            return;
        }
        int newRow = 0;
        int newCol = 0;

        if (col == totalQueens - 1) {
            newRow = row + 1;
            newCol = 0;
        } else {
            newRow = row;
            newCol = col + 1;
        }

        chess[row][col] = true;
        printQueenCombination(chess, totalQueens, queensPlaced + 1, newRow, newCol);
        chess[row][col] = false; 
        printQueenCombination(chess, totalQueens, queensPlaced, newRow, newCol);
    }

}
