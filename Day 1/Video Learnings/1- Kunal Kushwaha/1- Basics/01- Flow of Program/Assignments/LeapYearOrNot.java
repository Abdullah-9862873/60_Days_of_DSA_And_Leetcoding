import java.util.Scanner;

public class LeapYearOrNot{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year please: ");
        int year = input.nextInt();
        input.close();

        // Checking if the year is leap or not
        if(year % 4 == 0){
            if(year % 100 == 0){
                // It is a century year
                if(year % 400 == 0){
                    System.out.println("It is a leap year");
                }else{
                System.out.println("It is not a leap year");
                }
            }else{
                System.out.println("It is a leap year");
            }
        }else{
            System.out.println("It is not a leap year");
        }
    }
}

/*
Pseudo Code
----> If the year is divisible by 4 then it is a leap year except for the century years... For example 2100 is not a leap year but it is divisible by 4

----> So we have to check if the year is a centry year or not... If it is then it must be divisible by 400 otherwise its not a leap year...
 */