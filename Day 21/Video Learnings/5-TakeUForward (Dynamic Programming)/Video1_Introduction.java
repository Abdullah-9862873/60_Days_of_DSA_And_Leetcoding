// --------------------Memoization--------------------
import java.util.*;
public class Video1_Introduction{
    public static void main(String[] args) {
        int n = 5;
        // Find the nth fibonacci number
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = fib(n, dp);
        System.out.println(ans);
    }
    public static int fib(int n, int[] dp){
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }
}
/*
Notes----> The dynamic programming is divided into memoization and tabulation... 
Memoization ----> Top Down
Tabulatioin ----> Bottom Up

The upper method is of memoization... 
Space Complexity ---> O(n) + O(n)
Time Complexity ---> O (n)

----> For the memoization, we are gonna use the extra space and store the sub problem's answers in the array and then use it in the overlapping subproblems...

----> For the tabulation, we dont use any extra array, we try to avoid it in order to improve the space optimization...
 */

 // -------------------------TABULATION------------------
public class Video1_Introduction{
    public static void main(String[] args) {
        int n = 5;
        // Find the nth fibonacci number
        int ans = fib(n);
        System.out.println(ans);
    }
    public static int fib(int n){
        int prev = 1;
        int prev2 = 0;

        for(int i=2; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

/*
Notes----->
Time Complexity---> O(n)
Space Complexity--> O(n)  // More optimized because we dont have to initialise new array of size n
 */