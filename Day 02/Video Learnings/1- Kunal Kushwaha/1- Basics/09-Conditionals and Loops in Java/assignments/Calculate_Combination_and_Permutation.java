import java.util.Scanner;

public class Calculate_Combination_and_Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = input.nextInt();

        System.out.println("Enter the value of r: ");
        int r = input.nextInt();

        input.close();

        double combination = (factorial(n)) / ((factorial(r) * (factorial(n-r))));
        double permuation = factorial(n)/((factorial(n-r)));

        System.out.println("Combination is: " + combination);
        System.out.println("Permuation is: " + permuation);
    }

    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * factorial(n-1);
    }
}
