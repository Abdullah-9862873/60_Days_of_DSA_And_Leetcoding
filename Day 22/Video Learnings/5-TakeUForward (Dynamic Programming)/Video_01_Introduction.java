
// --------------------Memoization--------------------
import java.util.*;

public class Video1_Introduction {
    public static void main(String[] args) {
        int n = 5;
        // Find the nth fibonacci number
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = fib(n, dp);
        System.out.println(ans);
    }

    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
}

// _____________________________________________________________________
/*
 * Notes----> The dynamic programming is divided into memoization and
 * tabulation...
 * Memoization ----> Top Down
 * Tabulatioin ----> Bottom Up
 * 
 * The upper method is of memoization...
 * Space Complexity ---> O(n) + O(n)
 * Time Complexity ---> O (n)
 * 
 * ----> For the memoization, we are gonna use the extra space and store the sub
 * problem's answers in the array and then use it in the overlapping
 * subproblems...
 * 
 * ----> For the tabulation, we dont use any extra array, we try to avoid it in
 * order to improve the space optimization...
 */
// _____________________________________________________________________
// -------------------------TABULATION------------------
public class Video1_Introduction {
    public static void main(String[] args) {
        int n = 5;
        // Find the nth fibonacci number
        int ans = fib(n);
        System.out.println(ans);
    }

    public static int fib(int n) {
        int prev = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

/*
 * Notes----->
 * Time Complexity---> O(n)
 * Space Complexity--> O(n) // More optimized because we dont have to initialise
 * new array of size n
 */

// __________________________________________________________________
/*
 * To Convert from Recursion to Memoization
 * Step1------> Look at the changing parameters in the function... If the total
 * of (m-1) changes can be seen in the code while running then dp of size m must
 * be used... Similarly in 2D matrix if the (m-1) x (n-1) changes can be seen in
 * the variables while completion of code... Then dp[m][n] must be declared and
 * used...
 * Step2------> Pass it as argument in the calculation function
 * Step3------> Add the following as base case
 * if(dp[index] != -1){
 * return dp[index];
 * }
 * Step4-----> Whatever you were returning from the recursion function lets say
 * you were returning Math.max(ans1, ans2) then do something like
 * return dp[index] = Math.max(ans1, ans2);
 * 
 * _____________________________________________________________________
 * To Convert from Memoization to Tabulation
 * Step1------> Make the dp array in the calculation function and remove it from
 * the main function and remove it from the parameters and arguments
 * 
 * Step2------> The base cases that you were having in the recursion function...
 * Write them with respect to the dp array... Like if the base case is
 * if(index == 0){
 * Doing some operation
 * }
 * Then write it as dp[0] = stuff
 * 
 * Step3------> Make a for loop to iterate from the index 1 till end and try to
 * store the previous results in the dp array
 * 
 * Step4------> Return the last value of the dp array
 * 
 */