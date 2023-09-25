import java.math.*;
import java.util.*;

public class Problem_24_Find_Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(findFactorial(n));
    }

    public static ArrayList<Integer> findFactorial(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Reversing
        while (!factorial.equals(BigInteger.ZERO)) { 
            int rem = factorial.mod(BigInteger.TEN).intValue();
            arr.add(rem);
            factorial = factorial.divide(BigInteger.TEN);
        }
        Collections.reverse(arr);
        return arr;
    }
}
