import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to check: ");;
        int num = input.nextInt();

        input.close();

        if(isArmstrong(num)){
            System.out.println("The number you entered is an armstrong number");
        }else{
            System.out.println("The number you entered is not an armstrong number");
        }
    }

    public static boolean isArmstrong(int num){
        if(num == 0 || num == 1){
            return true;
        }
        int copyNum = num;

        int ans = 0;
        while(copyNum != 0){
            int lastDigit = copyNum % 10;
            copyNum /= 10;
            ans = ans + lastDigit*lastDigit*lastDigit;
        }
        if(ans == num){
            return true;
        }
        return false;
    }
}
