/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

 */

import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        int count = 0;

        int[] arr = new int[n*n];
        for(int i=1; i<=n*n; i++){
            arr[i-1] = i;
        }

        int[][] matrix = new int[n][n];

        int i_low_limit = 0;
        int j_low_limit = 0;
        int i_up_limit = n-1;
        int j_up_limit = n-1;
        
        while(count < n*n){
            // Setting first row
            for(int j=j_low_limit; j<=j_up_limit; j++){
                matrix[i_low_limit][j] = arr[count];
                count++;
            }
            i_low_limit++;

            // Setting last col
            for(int i=i_low_limit; i<=i_up_limit; i++){
                matrix[i][j_up_limit] = arr[count];
                count++;
            }
            j_up_limit--;

            // Setting last row
            for(int j= j_up_limit; j>=j_low_limit; j--){
                matrix[i_up_limit][j] = arr[count];
                count++;
            }
            i_up_limit--;

            // Setting first col
            for(int i=i_up_limit; i>=i_low_limit; i--){
                matrix[i][j_low_limit] = arr[count];
                count++;
            }
            j_low_limit++;
        }

        // Printing the array
        for(int[] ar : matrix){
            System.out.println(Arrays.toString(ar));
        }
    }
}
