import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the values of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("The reverse of this array will be: ");
        reverse(arr, 0, (arr.length - 1));
        System.out.print(Arrays.toString(arr));

        input.close();
    }

    static void reverse(int[] arr, int start, int end) {
        while (start != end) {
            if (start > end) {
                break;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start += 1;
                end -= 1;
            }
        }
    }
}
