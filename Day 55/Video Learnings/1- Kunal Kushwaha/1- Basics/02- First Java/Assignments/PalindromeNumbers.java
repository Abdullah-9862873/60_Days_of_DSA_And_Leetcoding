/*
An integer is a palindrome when it reads the same backward as forward.
*/

import java.util.Scanner;

public class PalindromeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = input.nextInt();
        input.close();

        boolean check = isPalindrome(num);
        if(check){
            System.out.println("The number you entered is a Palindrome");
        }else{
            System.out.println("The number you entered is not a Palindrome");
        }
        
    }
    public static boolean isPalindrome(int num){
        if(num == 0){
            return true;   
        }
        if(num / 10 == 0){
            return true;
        }

        int copyNum = num;
        int reverse = 0;

        while(copyNum != 0){
            reverse = (reverse * 10) + (copyNum % 10);
            copyNum /= 10;
        }

        if(reverse == num){
            return true;
        }
        return false;
    }
}
