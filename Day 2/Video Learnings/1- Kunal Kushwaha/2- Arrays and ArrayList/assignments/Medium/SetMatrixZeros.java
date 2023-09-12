/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
import java.util.ArrayList;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,0}};

        ArrayList<ArrayList<Integer>> zeros = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
               if(matrix[i][j] == 0){
                ArrayList<Integer> zero = new ArrayList<>();
                zero.add(i);
                zero.add(j);
                zeros.add(zero);
               }
            }
        }

        int[][] arr = new int[zeros.size()][2];
        int itr = 0;

        for (ArrayList<Integer> zero : zeros) {
            int row = zero.get(0);
            int col = zero.get(1);
            arr[itr++] = new int[]{row,col};
        }

        int rowPointer = 0;
        int colPointer = 0;

        for(int[] ar: arr){
            int i = ar[0];
            int j = ar[1];
             if(matrix[i][j] == 0){
                    rowPointer = i;

                    rowPointer -= 1;
                    while(rowPointer >= 0){
                        matrix[rowPointer][j] = 0;
                        rowPointer -= 1;
                    }

                    rowPointer = i;
                    while(rowPointer < matrix.length){
                        matrix[rowPointer][j] = 0;
                        rowPointer += 1;
                    }
                    rowPointer = 0;

                    // For Columns
                    colPointer = j;

                    colPointer -= 1;
                    while(colPointer >= 0){
                        matrix[i][colPointer] = 0;
                        colPointer -= 1;
                    }
                    colPointer = j;
                    while(colPointer < matrix[i].length){
                        matrix[i][colPointer] = 0;
                        colPointer += 1;
                    }
                    colPointer = 0;
                }
        }
    }
}
