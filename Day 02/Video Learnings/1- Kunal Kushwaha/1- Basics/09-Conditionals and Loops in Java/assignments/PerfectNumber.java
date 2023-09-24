import java.util.ArrayList;
import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = input.nextInt();

        input.close();

        ArrayList<Integer> properDivisors = new ArrayList<>();
        properDivisors = factorsFinder(num, properDivisors);

        // Adding all the proper divisors
        if(checkForPerfectNumber(num, properDivisors)){
            System.out.println("Yes it is a perfect number");
        }else{
            System.out.println("No its not a perfect number");
        }
    }

    public static boolean checkForPerfectNumber( int num, ArrayList<Integer> properDivisors){
        int sum = 0;
        for(int i=0; i<properDivisors.size(); i++){
            sum += properDivisors.get(i);
        }
        if(sum == num){
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> factorsFinder(int num, ArrayList<Integer> arr){
        if(num == 0){
            return arr;
        }

        arr.add(1);

        for(int i=2; i<num; i++){
            if(num % i == 0){
                arr.add(i);
            }
        }
        return arr;
    }
}
