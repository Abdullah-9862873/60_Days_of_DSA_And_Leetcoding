
import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        // int[][] arr = new int[3][];

        // int[][] arr2D = {
        // { 1, 2, 3 },
        // { 4, 5 },
        // { 6, 7, 8, 9 },
        // };

        // -------------------------------------------------------
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = input.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = input.nextInt();

        int[][] arr2D = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.println("Enter the values of row " + (i + 1) + " col " + (j + 1) + ": ");
                arr2D[i][j] = input.nextInt();
            }
        }

        // Output
        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < arr2D[i].length; j++) {
        // System.out.print(arr2D[i][j] + " ");
        // }
        // System.out.println();
        // }

        // _________________Another_Way_To_Output__________________________
        // for (int i = 0; i < rows; i++) {
        // System.out.println(Arrays.toString(arr2D[i]));
        // }

        // ___________________Another_Simpler_Way_To_Print_Output________
        // for (int[] arr : arr2D) {
        // System.out.println(Arrays.toString(arr));
        // }

        input.close();
    }
}

/*
 * -----------------------------Notes-------------------------
 * It is not necessary to give the number of columns while initialising the
 * multidimensional array... This is because the individual rows are arrays
 * themselves so no need to specify how many entities the individual arrays are
 * having...
 * 
 * 
 * 
 */
