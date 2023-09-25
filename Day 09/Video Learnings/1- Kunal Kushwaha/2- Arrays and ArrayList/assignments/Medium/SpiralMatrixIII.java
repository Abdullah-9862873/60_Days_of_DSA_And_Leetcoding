/*
You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

*/

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;

        int[][] ans = new int[rows*cols][2];
        int i = 0;
        ans[i++] = new int[]{rStart, cStart};
        int[] directions = new int[]{0,1,0,-1,0};
        int d = 0;
        int len = 0;

        while(i < rows*cols){
            if(d == 0 || d== 2){
                // I have to move east 
                len++;
            }

            for(int k=0; k<len; k++){
                rStart += directions[d];
                cStart += directions[d+1];
                if(rStart < rows && rStart >=0 && cStart < cols && cStart >=0){
                    ans[i++] = new int[]{rStart, cStart};
                }
            }

            d = ++d % 4;
        }




        // Printing
        for(int[] arr : ans){
            System.out.println(Arrays.toString(arr));
        }
    }
}


