/*
Problem Statement
Ninja is planing this 'N' days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can't do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn? You are given a 2D array of size N*3 'POINTS' with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

Constraints:
1 ‹= T ‹= 10
1 <= N <= 100000.
1 <= values of POINTS arrays <= 100 •
Time limit: 1 sec


Sample Input 1:
2
3
1 2 5
3 1 1
3
33
3
10 40 70
20 50 80
30 60 90

Sample Output 1:
11
210

https://www.codingninjas.com/studio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

*/
//______________________________________________________________________
public class Video_07_Ninja_Training {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 50, 1 },
                { 5, 100, 11 },
                { 1, 5, 6 },
                { 2, 12, 24 }
        };
        boolean[] availability = new boolean[arr[0].length];

        printAllCombinations(arr, availability, 0, "");
    }

    public static void printAllCombinations(int[][] arr, boolean[] availability, int days, String asf) {
        if (days >= arr.length) {
            if (days == arr.length) {
                System.out.println(asf);
            }
            return;
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (availability[i] == false) {
                boolean[] newAvailability = new boolean[availability.length];
                newAvailability[i] = true;
                printAllCombinations(arr, newAvailability, days + 1,
                        asf.isEmpty() ? asf + arr[days][i] : asf + "-" + arr[days][i]);
                newAvailability[i] = false;
            }
        }
    }
}
//______________________________________________________________________
// Other Recursion Method

public class Video_07_Ninja_Training {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 50, 1 },
                { 5, 100, 11 },
                { 1, 5, 6 }
        };
        int days = arr.length-1;
        int last = arr[0].length;

        int ans = getMaxNinjaTrainingScore(arr, days, last);
        System.out.println(ans);
    }
    public static int getMaxNinjaTrainingScore(int[][] arr, int days, int last){
        if(days == 0){
            int maxi = 0;
            for(int i=0; i<arr[0].length; i++){
                if(i!=last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;

        for(int i=0; i<arr[0].length; i++){
            if(i != last){
                int point = arr[days][i] + getMaxNinjaTrainingScore(arr, days-1, i);
                maxi = Math.max(maxi, point);
            }
        }
        return maxi;
    }
}

//_________________________________________________________________________
// Using memoization
import java.util.*;
public class Video_07_Ninja_Training {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 50, 1 },
                { 5, 100, 11 },
                { 1, 5, 6 }
        };
        int days = arr.length-1;
        int last = arr[0].length;

        int[][] dp = new int[arr.length][arr[0].length+1];
        for(int[] temp: dp){
            Arrays.fill(temp,-1);
        }

        int ans = getMaxNinjaTrainingScore(arr, days, last, dp);
        System.out.println(ans);
    }
    public static int getMaxNinjaTrainingScore(int[][] arr, int days, int last, int[][] dp){
        if(days == 0){
            int maxi = 0;
            for(int i=0; i<arr[0].length; i++){
                if(i!=last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }
        if(dp[days][last] != -1){
            return dp[days][last];
        }

        int maxi = 0;

        for(int i=0; i<arr[0].length; i++){
if(i != last){
    int point = arr[days][i] + getMaxNinjaTrainingScore(arr, days-1, i,dp);
    maxi = Math.max(maxi, point);
}
        }
        return dp[days][last] = maxi;
    }
}

//_________________________________________________________________________
// Using Tabulation

public class Video_07_Ninja_Training {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 50, 1 },
                { 5, 100, 11 },
                { 1, 5, 6 }
        };
        int days = arr.length - 1;
        int last = arr[0].length;

        int ans = getMaxNinjaTrainingScore(arr, days, last);
        System.out.println(ans);
    }

    public static int getMaxNinjaTrainingScore(int[][] arr, int days, int last) {
        if (days == 0) {
            int maxi = 0;
            for (int i = 0; i < arr[0].length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        int[][] dp = new int[arr.length][arr[0].length + 1];
        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(Math.max(arr[0][0], arr[0][1]), arr[0][2]);

        for (int day = 1; day < arr.length; day++) {
            for (int i = 0; i < 4; i++) {
                dp[day][i] = 0; 
                for (int task = 0; task <= 2; task++) {
                    if (task != i) {
                        int activity = arr[day][task] + dp[day - 1][task];
                        dp[day][i] = Math.max(dp[day][i], activity);
                    }
                }
            }
        }
        return dp[arr.length - 1][arr[0].length];
    }
}

//_________________________________________________________________________
// Using Space Optimization

public class Video_07_Ninja_Training {
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 50, 1 },
                { 5, 100, 11 },
                { 1, 5, 6 }
        };
        int days = arr.length - 1;
        int last = arr[0].length;

        int ans = getMaxNinjaTrainingScore(arr, days, last);
        System.out.println(ans);
    }

    public static int getMaxNinjaTrainingScore(int[][] arr, int days, int last) {
        if (days == 0) {
            int maxi = 0;
            for (int i = 0; i < arr[0].length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        int[] prev = new int[arr[0].length+1];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(Math.max(arr[0][0], arr[0][1]), arr[0][2]);

        for (int day = 1; day < arr.length; day++) {
            int temp[] = new int[arr[0].length+1];
            for (int i = 0; i < arr[0].length+1; i++) {
                temp[i] = 0; 
                for (int task = 0; task < arr[0].length; task++) {
                    if (task != i) {
                        temp[i] = Math.max(temp[i], arr[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[prev.length-1];
    }
}
