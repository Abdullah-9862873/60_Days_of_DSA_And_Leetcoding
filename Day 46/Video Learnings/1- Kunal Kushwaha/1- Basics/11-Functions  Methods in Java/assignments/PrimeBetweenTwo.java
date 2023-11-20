import java.util.*;

public class PrimeBetweenTwo{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = input.nextInt();

        input.close();

        for(int i=num1; i<=num2; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num %i == 0){
                return false;
            }
        }
        return true;
    }
}