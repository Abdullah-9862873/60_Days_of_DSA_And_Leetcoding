import java.util.Arrays;
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the values of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        // Swapping
        System.out.print("Enter the position of which element you want to replace: ");
        int index1 = input.nextInt();
        index1 -= 1;

        System.out.print("Enter the position of which element you want to replace it with: ");
        int index2 = input.nextInt();
        index2 -= 1;

        swap(arr, index1, index2);

        System.out.println(Arrays.toString(arr));
        input.close();
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
