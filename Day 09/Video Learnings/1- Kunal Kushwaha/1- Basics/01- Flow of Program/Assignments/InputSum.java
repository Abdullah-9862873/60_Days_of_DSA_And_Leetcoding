/*
Keep taking numbers as inputs till the user enters ‘x’, after that print sum of all.
 */

import java.util.Scanner;

public class InputSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans = 0;
        while(true){
            System.out.println("Enter the number if you want to add... Press X if you want to print the sum till now: ");
            String str = input.next();
            if(str.charAt(0) == 'x' || str.charAt(0) == 'X'){
                input.close();
                break;
            }
            int num = Integer.parseInt(str);
            ans += num;
            str = "";
        }
        System.out.println("The sum of numbers is: " + ans);
    }
}
