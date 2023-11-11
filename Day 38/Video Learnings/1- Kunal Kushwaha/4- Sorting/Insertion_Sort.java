// The idea is to find if arr[j] > arr[j-1] and keep swapping till this condition gets false... So we keep the smaller elements to the left and the greater to the right
import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 3, 4 };

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}

/*
 * Time Complexity__________________________________________
 * Worst Case---------> O(n^2) _________________IN DECREASING SORTED ARRAY
 * -----------> This is bacause the number of comparisons being made are 1, 2,
 * 3, 4, ---, (n-1)
 * -----------> Sum of n number is----------> n(n+1)/2
 * -----------> Here n is (n-1) so----------> ((n-1)(n-1+1))/2
 * ------------------------------------------> (n-1)(n)/2
 * ------------------------------------------> (n^2 - n)/2
 * ------------------------------------------> O(n^2)
 * 
 * Best Case-----------> O(n)___________________IN ALREADY SORTED ARRAY
 * ------------> This is because the number of comparisons being made are (n-1)
 * 
 * 
 * Why Use It??
 * ----------> Adaptive: As the number of swaps reduce as compared to Bubble
 * sort
 * ----------> Stable
 * ----------> Used for smaller values of n... Works good when the array is
 * partially sorted... This is the reason it takes part in hybrid sorting
 * algorithms
 */
