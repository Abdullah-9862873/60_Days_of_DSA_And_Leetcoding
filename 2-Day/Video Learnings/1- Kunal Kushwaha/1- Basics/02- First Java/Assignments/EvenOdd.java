import java.util.Scanner;

public class EvenOdd{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = input.nextInt();
        input.close();

        if(isEven(num)){
            System.out.println("The number you entered is Even");
        }else{
            System.out.println("The number you entered is Odd");
        }
    }
    public static boolean isEven(int num){
        if(num == 0){
            return true;
        }
        if(num % 2 == 0){
            return true;
        }
        return false;
    }
}