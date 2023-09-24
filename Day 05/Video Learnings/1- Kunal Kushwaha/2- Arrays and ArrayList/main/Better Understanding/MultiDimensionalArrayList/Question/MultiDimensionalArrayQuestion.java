import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArrayQuestion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int row = input.nextInt();

        int[][] arr = new int[row][];

        // input
        for (int i = 0; i < row; i++) {

            System.out.print("Enter the number of columns you want for row: " + (i + 1) + ": ");
            int col = input.nextInt();

            arr[i] = new int[col];

            for (int j = 0; j < col; j++) {
                System.out.print("Enter the value for row " + (i + 1) + " column " + (j + 1) + ": ");
                arr[i][j] = input.nextInt();
            }
        }

        input.close();

        // output
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
