// Given a square matrix mat, return the sum of the matrix diagonals.

// Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

// Example 1:

// Input: mat = [[1,2,3],
//               [4,5,6],
//               [7,8,9]]
// Output: 25
// Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
// Notice that element mat[1][1] = 5 is counted only once.

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        int primaryDiagonalCount = 0;
        int secondaryDiagonalCount = 0;

        // Calculating Primary Diagonal Count
        for (int i = 0; i < mat.length; i++) {
            int lengthOfRow = mat[i].length;
            for (int j = 0; j < lengthOfRow; j++) {
                if (i == j) {
                    primaryDiagonalCount += mat[i][j];
                }
            }
        }

        // Calculating Secondary Diagonal Count
        boolean runOnce = true;
        int lastIndex = -1;
        int l = -1;

        for (int i = 0; i < mat.length; i++) {
            int lengthOfRow = mat[i].length;

            int firstIndex = i;
            if (runOnce) {
                lastIndex = 1; // Should run only once
                l = 0; // should run only once
            }
            int j = lengthOfRow - lastIndex;

            if (firstIndex == l && j == lengthOfRow - lastIndex) {
                if (i != j) {
                    secondaryDiagonalCount += mat[i][j];
                } else {
                    secondaryDiagonalCount += 0;
                }

            }
            l += 1;
            lastIndex += 1;

            runOnce = false;
        }

        // Calculating Diagonal Sum
        int sum = 0;
        sum = primaryDiagonalCount + secondaryDiagonalCount;
        System.out.println(sum);

    }
}
