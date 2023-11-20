/*
Subtract the Product and Sum of Digits of an Integer
*/

public class ProductSubtractSum{
    public static void main(String[] args){
        int n = 234;

        int product = 1;;
        product = calcProduct(n, product);

        int sum = 0;
        sum = calcSum(n, sum);

        int ans = product - sum;
        System.out.println(ans);
    }
    public static int calcProduct(int n, int product){
        while(n != 0){
            int lastDigit = n % 10;
            n /= 10;
            product *= lastDigit;
        }
        return product;
    }
    public static int calcSum(int n, int sum){
        while(n != 0){
            int lastDigit = n % 10;
            n /= 10;
            sum += lastDigit;
        }
        return sum;
    }
}