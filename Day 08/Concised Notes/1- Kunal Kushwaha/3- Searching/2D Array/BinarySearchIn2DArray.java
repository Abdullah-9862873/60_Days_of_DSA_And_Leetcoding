import java.util.Arrays;

public class BinarySearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 },
        };

        int[] ans = search(arr, 28);
        System.out.println(Arrays.toString(ans));

    }

    static int[] search(int[][] arr, int target) {
        int r = 0;
        int c = arr.length - 1;

        while (r <= arr.length - 1 && c >= 0) {
            if (arr[r][c] == target) {
                return new int[] { r, c };
            }
            if (arr[r][c] < target) {
                r++;
            }
            if (arr[r][c] > target) {
                c--;
            }
        }
        return new int[] { -1, -1 };
    }
}