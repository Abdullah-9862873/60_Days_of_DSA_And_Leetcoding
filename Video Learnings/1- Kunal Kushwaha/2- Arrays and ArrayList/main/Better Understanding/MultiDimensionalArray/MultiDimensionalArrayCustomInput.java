package MultiDimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArrayCustomInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 },
        };

        // Output the whole array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        // Output the whole array
        // for (int[] a : arr) {
        // System.out.println(Arrays.toString(a));
        // }

        // Ouput a single element of the multidimensional array
        System.out.println("Enter the row: ");
        int row = input.nextInt();

        System.out.println("Enter the col: ");
        int col = input.nextInt();

        int ans = arr[row - 1][col - 1];

        System.out.println("The element at row " + (row) + " and column " + (col) + " is: " + ans);

        input.close();
    }

}
