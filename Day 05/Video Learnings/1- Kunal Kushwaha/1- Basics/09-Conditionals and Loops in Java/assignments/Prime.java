import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int num = input.nextInt();
        input.close();
        
        if(isPrime(num)){
            System.out.println("Yes its prime");
        }else{
            System.out.println("Not its not prime");
        }
    }

    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
