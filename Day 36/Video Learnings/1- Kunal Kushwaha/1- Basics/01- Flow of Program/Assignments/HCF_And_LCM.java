/*
Take 2 numbers as inputs and find their HCF and LCM.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class HCF_And_LCM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter second number: ");
        int num2 = input.nextInt();

        input.close();

        int LCM = findLCM(num1, num2);
        System.out.println("LCM is: " + LCM);

        // int HCF = findHCF(num1, num2);
        // System.out.println("HCF is: " + HCF);

        ArrayList<Integer> arr = new ArrayList<>();
        factorsGenerator(arr, 20);
        System.out.println(arr);


    }

    // Finding LCM
    public static int findLCM(int num1, int num2){
        int max = Math.max(num1, num2);

        while(true){
            if((max % num1 == 0) && (max % num2 == 0)){
                return max;
            }
            else{
                max++;
            }
        }
    }

    // Finding HCF
    public static int findHCF(int num1, int num2){
        ArrayList<Integer> factorsOfNum1 = new ArrayList<>();
        ArrayList<Integer> factorsOfNum2 = new ArrayList<>();

        factorsGenerator(factorsOfNum1, num1);
        factorsGenerator(factorsOfNum2, num2);

        // Traversing both the factors
        int ans = -1;
        int i = 0;
        int j = 0;
        while((i<factorsOfNum1.size()) && (j<factorsOfNum2.size())){
            if(factorsOfNum1.get(i) == factorsOfNum2.get(j)){
                if(ans == -1){
                    ans = factorsOfNum1.get(i);
                }else{
                    ans *= factorsOfNum1.get(i);
                }
                i++;
                j++;
            }else if(factorsOfNum1.get(i) < factorsOfNum2.get(j)){
                i++;
            }else{
                j++;
            }
        }   
        return ans;
    }

    public static void factorsGenerator(ArrayList<Integer> arr, int num1){
        int i = 2;
        int copyNum = num1;

        while((i <= num1) && (num1 > 1)){
            if(copyNum % i == 0){
                arr.add(i);
                copyNum /= i;
            }else{
                i++;
            }
        }
        return;
    }
}
