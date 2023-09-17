import java.util.Arrays;
import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the no of rows: ");
        int rows = input.nextInt();

        int[][] arr = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Enter how many columns are there for row: " + (i + 1) + ": ");
            int col = input.nextInt();

            // Initializing the ith row with these amount of columns
            arr[i] = new int[col];

            for (int j = 0; j < col; j++) {
                System.out.print("Enter the value of " + (j + 1) + " column: ");
                arr[i][j] = input.nextInt();
            }
        }

        // output
        for (int[] arr2D : arr) {
            System.out.println(Arrays.toString(arr2D));
        }
        input.close();
    }
}