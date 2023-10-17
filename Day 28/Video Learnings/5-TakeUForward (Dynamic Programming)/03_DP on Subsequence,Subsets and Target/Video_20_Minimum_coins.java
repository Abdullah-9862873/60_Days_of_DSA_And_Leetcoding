/*
Problem Statement
You are given an array of 'N' distinct integers and an integer 'X' representing the target sum. You have to tell the minimum number of elements you have to take to reach the target sum 'X'.
Note
You have an infinite number of elements of each type.
For Example
If N=3 and X=7 and array elements are
[1,2,3].
Way 1 - You can take 4 elements [2, 2,
2, 1] as 2 + 2 + 2 + 1 = 7.
Way 2 - You can take 3 elements [3, 3,
1] as 3 + 3 + 1 = 7.
Here, you can see in Way 2 we have used 3 coins to reach the target sum of 7. Hence the output is 3.

Constraints:
1 <= T <= 10
1 <= N <= 15
1 <= nums [i] <= (2^31) - 1
1 ‹= X <= 10000
All the elements of the "nums" array will
be unique.
Time limit: 1 sec

Sample Input 1 :
2
3 7
1 2 3
1 0
1

Sample Output 1:
3
0

*/
//___________________________________________________________________
// Using Recursion

public class Video_20_Minimum_coins {
    public static void main(String[] args) {
        int[] arr = {9,6,5,1};
        int target = 11;

        int ans = getMinimumCoins(arr,0,target);
        System.out.println(ans);
    }
    public static int getMinimumCoins(int[] arr,int index, int target){
        if(index == arr.length-1){
            if(target >= arr[index]){
                if(target % arr[index] == 0){
                    return target / arr[index];
                }
            }else{
                return 0;
            }
        }

        int ans2 = 0 + getMinimumCoins(arr, index+1, target);

        int mini = Integer.MAX_VALUE;
        int ans1 = 0;
        if(target >= arr[index]){
            int takeTimes = target / arr[index];
            for(int i=1; i<=takeTimes; i++){
                ans1 = i + getMinimumCoins(arr, index+1, target-(i*arr[index]));
                mini = Math.min(mini,ans1);
            }
        }

        return Math.min(mini,ans2);
    }
}

// ___________________________________________________________________
// Using Memoization
import java.util.*;

public class Video_20_Minimum_coins {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 5, 1 };
        int target = 11;

        int[][] dp = new int[arr.length + 1][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        int ans = getMinimumCoins(arr, 0, target, dp);
        System.out.println(ans);
    }

    public static int getMinimumCoins(int[] arr, int index, int target, int[][] dp) {
        if (index == arr.length - 1) {
            if (target >= arr[index]) {
                if (target % arr[index] == 0) {
                    return target / arr[index];
                }
            } else {
                return 0;
            }
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int ans2 = 0 + getMinimumCoins(arr, index + 1, target, dp);

        int mini = Integer.MAX_VALUE;
        int ans1 = 0;
        if (target >= arr[index]) {
            int takeTimes = target / arr[index];
            for (int i = 1; i <= takeTimes; i++) {
                ans1 = i + getMinimumCoins(arr, index + 1, target - (i * arr[index]), dp);
                mini = Math.min(mini, ans1);
            }
        }

        return dp[index][target] = Math.min(mini, ans2);
    }
}

// ______________________________________________________________
// Using Tabulation

public class Video_20_Minimum_coins {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 5, 1 };
        int target = 11;

        int ans = getMinimumCoins(arr, 0, target);
        System.out.println(ans);
    }

    public static int getMinimumCoins(int[] arr, int index, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= target; i++) {
            if (i >= arr[arr.length - 1]) {
                if (i % arr[arr.length - 1] == 0) {
                    dp[arr.length - 1][i] = i / arr[arr.length - 1];
                } else {
                    dp[arr.length - 1][i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                int ans2 = 0 + dp[i + 1][j];
                int mini = Integer.MAX_VALUE;
                int ans1 = 0;
                if (j >= arr[i]) {
                    int takeTimes = j / arr[i];
                    for (int k = 1; k <= takeTimes; k++) {
                        ans1 = k + dp[i + 1][j - (k * arr[i])];
                        mini = Math.min(mini, ans1);
                    }
                }
                dp[i][j] = Math.min(mini, ans2);
            }
        }
        return dp[0][target];
    }
}

// ______________________________________________________________
// Using space optimization

public class Video_20_Minimum_coins {
    public static void main(String[] args) {
        int[] arr = { 9, 6, 5, 1 };
        int target = 11;

        int ans = getMinimumCoins(arr, 0, target);
        System.out.println(ans);
    }

    public static int getMinimumCoins(int[] arr, int index, int target) {
        int[] front = new int[target + 1];
        int[] curr = new int[target + 1];

        front[0] = 0;
        curr[0] = 0;

        for (int i = 0; i <= target; i++) {
            if (i >= arr[arr.length - 1]) {
                if (i % arr[arr.length - 1] == 0) {
                    front[i] = i / arr[arr.length - 1];
                } else {
                    front[i] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                int ans2 = 0 + front[j];
                int mini = Integer.MAX_VALUE;
                int ans1 = 0;
                if (j >= arr[i]) {
                    int takeTimes = j / arr[i];
                    for (int k = 1; k <= takeTimes; k++) {
                        ans1 = k + front[j - (k * arr[i])];
                        mini = Math.min(mini, ans1);
                    }
                }
                curr[j] = Math.min(mini, ans2);
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return curr[target];
    }
}