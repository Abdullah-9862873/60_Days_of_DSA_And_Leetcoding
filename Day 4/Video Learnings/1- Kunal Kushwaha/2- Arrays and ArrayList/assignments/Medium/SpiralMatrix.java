/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        List<Integer> list = new ArrayList<>();

        int i_low_lim = 0;
        int j_low_lim = 0;
        int i_up_lim = matrix.length - 1;
        int j_up_lim = matrix[0].length - 1;

        while (i_low_lim <= i_up_lim && j_low_lim <= j_up_lim) {
            // Traverse top row
            for (int j = j_low_lim; j <= j_up_lim; j++) {
                list.add(matrix[i_low_lim][j]);
            }
            i_low_lim++;

            // Traverse right column
            for (int i = i_low_lim; i <= i_up_lim; i++) {
                list.add(matrix[i][j_up_lim]);
            }
            j_up_lim--;

            // Traverse bottom row
            if (i_low_lim <= i_up_lim) {
                for (int j = j_up_lim; j >= j_low_lim; j--) {
                    list.add(matrix[i_up_lim][j]);
                }
                i_up_lim--;
            }

            // Traverse left column
            if (j_low_lim <= j_up_lim) {
                for (int i = i_up_lim; i >= i_low_lim; i--) {
                    list.add(matrix[i][j_low_lim]);
                }
                j_low_lim++;
            }
        }

        System.out.println(list);
    }
}
