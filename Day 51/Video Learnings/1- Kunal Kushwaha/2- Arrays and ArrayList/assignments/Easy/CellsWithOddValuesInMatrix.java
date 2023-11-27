// There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

// For each location indices[i], do both of the following:

// Increment all the cells on row ri.
// Increment all the cells on column ci.
// Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

// Example 1:

// Input: m = 2, n = 3, indices = [[0,1],[1,1]]
// Output: 6
// Explanation: Initial matrix = [[0,0,0],[0,0,0]].
// After applying first increment it becomes [[1,2,1],[0,1,0]].
// The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.

public class CellsWithOddValuesInMatrix {
    public static void main(String[] args) {
        int[][] indices = {
                { 0, 1 },
                { 1, 1 },
        };
        int m = 2; // Rows
        int n = 3; // Columns

        int[][] initialMatrix = new int[m][n];

        // initializing it with 0's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                initialMatrix[i][j] = 0;
            }
        }

        int row = -1;
        int col = -1;
        for (int i = 0; i < indices.length; i++) {
            int sizeOfRowElements = indices[i].length;
            int j = 0;
            while (j < sizeOfRowElements) {
                row = indices[i][j];
                col = indices[i][j + 1];
                break;
            }
            for (int k = 0; k < n; k++) {
                initialMatrix[row][k] += 1;
            }
            // Traverse all the rows but only the column that is col
            for (int k = 0; k < m; k++) {
                initialMatrix[k][col] += 1;
            }
        }

        // Counting odd values in the whole 2D matrix
        int count = 0;
        for (int i = 0; i < initialMatrix.length; i++) {
            int sizeOfRowElements = initialMatrix[i].length;
            for (int j = 0; j < sizeOfRowElements; j++) {
                if (initialMatrix[i][j] % 2 != 0) {
                    count += 1;
                }
            }
        }

        System.out.println(count);

    }
}
