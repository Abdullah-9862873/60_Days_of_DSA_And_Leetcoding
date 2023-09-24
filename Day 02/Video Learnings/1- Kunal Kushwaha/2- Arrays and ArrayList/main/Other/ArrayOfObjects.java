
import java.util.Scanner;

public class ArrayOfObjects {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size;
        System.out.println("How many strings you wanna enter: ");
        size = input.nextInt();

        String[] str = new String[size];

        for (int i = 0; i < str.length; i++) {
            System.out.println("Enter the string: ");
            String userInput = input.next();
            str[i] = userInput;
        }

        // For Each loop || Enhanced for loop
        for (String str1 : str) {
            System.out.print(str1 + " ");
        }
        input.close();
    }
}
