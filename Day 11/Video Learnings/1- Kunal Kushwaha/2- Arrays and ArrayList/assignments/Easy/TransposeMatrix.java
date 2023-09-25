import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] new_matrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                new_matrix[j][i] = matrix[i][j];
            }
        }

        for (int[] arr : new_matrix) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
