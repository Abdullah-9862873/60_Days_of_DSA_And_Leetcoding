// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

// Example 1:

// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]
// Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

package newAssignments;

import java.util.ArrayList;

public class LuckyNumberInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 7, 8 },
                { 9, 11, 13 },
                { 15, 16, 17 },
        };

        ArrayList<Integer> luckyNumber = new ArrayList<>(10);

        for (int i = 0; i < matrix.length; i++) {
            int minimumVal = 99999;
            int indexOfMinVal = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                minimumVal = Math.min(minimumVal, matrix[i][j]);
                if (minimumVal == matrix[i][j]) {
                    indexOfMinVal = j;
                }
            }

            // Watch in every row----> At the indexofMinVal ----> That whether the value is
            // greater than miniumVal
            boolean condition = true;
            for (int k = 0; k < matrix.length; k++) {
                if (k == i) {
                    continue;
                }

                int val = matrix[k][indexOfMinVal];
                if (val > minimumVal) {
                    condition = false;
                }
            }

            if (condition) {
                luckyNumber.add(minimumVal);
            }
        }

        System.out.println(luckyNumber);

    }
}
