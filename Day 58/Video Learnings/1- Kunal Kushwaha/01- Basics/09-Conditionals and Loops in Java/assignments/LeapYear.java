import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the year: ");
        int year = input.nextInt();

        input.close();

        if(checkLeap(year)){
            System.out.println("Yes it is a leap year");
        }else{
            System.out.println("No its not a leap year");
        }
    }

    public static boolean checkLeap(int year){
        if(year % 4 == 0){
            // Check if year is divisible by 100 if it is then it must be divisible by 400
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
