// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

// You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

// The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

// Example 1:

// Input: mat = [[1,2],[3,4]], r = 1, c = 4
// Output: [[1,2,3,4]]

package newAssignments;

import java.util.ArrayList;
import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
        };
        int r = 3;
        int c = 2;

        // Checking condition
        boolean check = true;
        int matRows = mat.length;
        int matColumns = mat[0].length;

        if (matRows * matColumns != r * c) {
            check = false;
        }

        if (!check) {
            for (int[] ans : mat) {
                System.out.println(Arrays.toString(ans));
            }
            // return mat;
        } else {
            ArrayList<ArrayList<Integer>> ansList = new ArrayList<>(r);
            ArrayList<Integer> list = new ArrayList<>(matRows * matColumns);

            for (int[] row : mat) {
                for (int val : row) {
                    list.add(val);
                }
            }

            // Initializing the new 2D matrix
            for (int i = 0; i < r; i++) {
                // For each row how many columns are present
                ansList.add(new ArrayList<>(c));
                for (int j = 0; j < c; j++) {
                    ansList.get(i).add(list.get(i * c + j));
                }
            }

            // Converting ArrayList to array
            int[][] ans = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ans[i][j] = ansList.get(i).get(j);
                }
            }

            for (int[] a : ans) {
                System.out.println(Arrays.toString(a));
            }
            // return ans;
        }
    }
}
