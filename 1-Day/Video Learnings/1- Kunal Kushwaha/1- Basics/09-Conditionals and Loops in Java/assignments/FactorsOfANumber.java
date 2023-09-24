/*
Input a number and print all the factors of that number (use loops).
*/

import java.util.ArrayList;
import java.util.Scanner;

public class FactorsOfANumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = input.nextInt();
        input.close();

        ArrayList<Integer> arr = new ArrayList<>();
        arr = factorsGenerator(num, arr);
        System.out.println(arr);
        
    }

    public static ArrayList<Integer> factorsGenerator(int num, ArrayList<Integer> arr){
        arr.add(1);

        int i=2;
        while(i <= num){
            if(num % i == 0){
               arr.add(i);
               i++;
            }else{
                i++;
            }
        }
        return arr;
    }
}
