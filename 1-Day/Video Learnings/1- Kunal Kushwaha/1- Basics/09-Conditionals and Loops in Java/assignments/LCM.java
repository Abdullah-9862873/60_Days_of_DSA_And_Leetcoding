import java.util.Scanner;

public class LCM{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter second number: ");
        int num2 = input.nextInt();
        input.close();

        int max = Math.max(num1, num2);
        
        while(true){
            if(max % num1 == 0 && max % num2 == 0){
                System.out.println("LCM: " + max);
                break;
            }
            else{
                max++;
            }
        }
        
    }
}