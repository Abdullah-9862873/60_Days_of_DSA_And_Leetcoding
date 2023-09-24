// Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

// Example 1:

// Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
// Output: true
// Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

package newAssignments;

public class MatrixObtainedByRotation {
    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 1 } };

        int[][] target = {
                { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 1 }
        };

        // Validtion of condition
        boolean check = true;
        int count = 4;

        while (count > 0) {
            check = true;
            // Taking transpose
            for (int i = 0; i < mat.length; i++) {
                for (int j = i; j < mat.length; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            // Reverse the row
            for (int i = 0; i < mat.length; i++) {
                int l = 0;
                int r = mat[i].length - 1;
                while (l < r) {
                    int temp = mat[i][l];
                    mat[i][l] = mat[i][r];
                    mat[i][r] = temp;
                    l++;
                    r--;
                }
            }

            // Assuming that rows and columns of both matrix are same
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat[i][j] != target[i][j]) {
                        check = false;
                    }
                }
            }
            if (check) {
                break;
            }
            count--;
        }

        System.out.println(check);

    }
}
