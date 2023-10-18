import java.util.ArrayList;
import java.util.Scanner;

public class HCF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = input.nextInt();
        System.out.println("Enter second number: ");
        int num2 = input.nextInt();
        input.close();

        ArrayList<Integer> factorsOfNum1 = new ArrayList<>();
        ArrayList<Integer> factorsOfNum2 = new ArrayList<>();

        factorsOfNum1 = factorsFinder(num1, factorsOfNum1);
        factorsOfNum2 = factorsFinder(num2, factorsOfNum2);

        System.out.println(factorsOfNum1);
        System.out.println(factorsOfNum2);

        int max = 1;
        int i=0;
        int j=0;

        for(int k=0; k<Math.max(factorsOfNum1.size(), factorsOfNum2.size()); k++){
            
            if(i < factorsOfNum1.size() && i < factorsOfNum2.size()){
                int first = factorsOfNum1.get(i);
                int second = factorsOfNum2.get(i);
                if(first == second){
                    if(first > max){
                        max = first;
                    }
                    i++;
                    j++;
                }else if(first < second){
                    i++;
                }else{
                    j++;
                }
            }
        }
        System.out.println("HCF: " + max);

    }

    public static ArrayList<Integer> factorsFinder(int num, ArrayList<Integer> arr){
        if(num == 0){
            return arr;
        }

        arr.add(1);

        for(int i=2; i<=num; i++){
            if(num % i == 0){
                arr.add(i);
            }
        }
        return arr;
    }
}
