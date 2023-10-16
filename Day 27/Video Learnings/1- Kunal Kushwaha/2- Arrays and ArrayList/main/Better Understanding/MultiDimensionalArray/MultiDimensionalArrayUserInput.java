package MultiDimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArrayUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = input.nextInt();

        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.println("Enter how many columns you want for row " + (i + 1) + ": ");
            int col = input.nextInt();

            // Initialising the ith indexes of two Dimensional array
            arr[i] = new int[col];

            for (int j = 0; j < col; j++) {
                System.out.println("Enter the values for row " + (i + 1) + " col " + (j + 1) + ": ");
                arr[i][j] = input.nextInt();
            }
        }

        // output all the array
        // One individual item of arr is an array int[]
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        // output a particular element of 2D array
        System.out.print("Enter a row in which the element you want in your output is present: ");
        int outputRow = input.nextInt();

        System.out.print("Enter the col of the element you want to print in the row " + outputRow + ": ");
        int outputColumns = input.nextInt();

        System.out.println("The element present at position row " + outputRow + " and column " + outputColumns + " : "
                + arr[outputColumns - 1][outputColumns - 1]);

        input.close();
    }
}
