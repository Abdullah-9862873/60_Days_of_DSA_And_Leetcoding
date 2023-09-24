
import java.util.Scanner;
import java.util.Arrays;

public class ArrayOfPrimitives {
    public static void main(String[] args) {
        // int[] arr = new int[5];
        // arr[0] = 2;
        // arr[1] = 3;
        // arr[2] = 4;
        // arr[3] = 25;
        // arr[4] = 26;

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }

        // ---------------------------------------
        // int size;
        // Scanner input = new Scanner(System.in);

        // System.out.println("Enter the number of values you wanna store: ");
        // size = input.nextInt();

        // int[] arr = new int[size];

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println("Enter " + (i + 1) + " value: ");
        // int userInput = input.nextInt();
        // arr[i] = userInput;
        // }

        // System.out.println("The values you entered are: ");
        // System.out.print("[");
        // for (int i = 0; i < arr.length; i++) {

        // // If there is last value
        // if (i + 1 == arr.length) {
        // System.out.print(arr[i]);
        // } else {
        // System.out.print(arr[i] + ", ");
        // }
        // }
        // System.out.print("]");
        // input.close();

        // -------------------------------------------------------------
        // Enhanced for loop || For Each loop

        // int[] arr = new int[5];
        // arr[0] = 24;
        // arr[1] = 32;
        // arr[2] = 65;
        // arr[3] = 2;
        // arr[4] = 240;

        // For every element in array print the element

        // for (int num : arr) {
        // System.out.print(num + " ");
        // }

        // ---------------------------------------------------------------
        // You can do the above thing as the following

        int size;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        size = input.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the values of array: ");
        for (int i = 0; i < arr.length; i++) {
            int userInput = input.nextInt();
            arr[i] = userInput;
        }

        System.out.println(Arrays.toString(arr));
        input.close();
    }
}
