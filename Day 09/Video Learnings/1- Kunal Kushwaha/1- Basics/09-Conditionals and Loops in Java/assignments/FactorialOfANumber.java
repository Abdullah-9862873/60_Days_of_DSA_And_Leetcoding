import java.util.Scanner;

public class FactorialOfANumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = input.nextInt();
        input.close();

        int ans = factorialCalculator(num);
        System.out.println(ans);
    }
    public static int factorialCalculator(int num){
        if(num == 0 || num == 1){
            return 1;
        }
        
        return num * factorialCalculator(num-1);
    }
}
