/*
 * Problem Statement:
 * You are given two strings:
 * s1 = "babgbag", s2 = "bag"
 * 
 * You have to tell how many times does the s2 appeared in s1...
 * The answer to this problem in this case is 5
 */
// ________________________________________________________________________
// Using Recursion

public class Video_33_Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int ans = getMinimalEditDistance(s1, s2, 0, 0);
        System.out.println(ans);
    }

    public static int getMinimalEditDistance(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j < s2.length()) {
            return s2.length() - j; 
        } else if (j >= s2.length() && i < s1.length()) {
            return s1.length() - i; 
        } else if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return getMinimalEditDistance(s1, s2, i + 1, j + 1);
        }

        int mini = Integer.MAX_VALUE;

        // Insert Operation
        int ans1 = 1 + getMinimalEditDistance(s1, s2, i, j + 1);

        // Remove Operation
        int ans2 = 1 + getMinimalEditDistance(s1, s2, i + 1, j);

        // Replace Operation
        int ans3 = 1 + getMinimalEditDistance(s1, s2, i + 1, j + 1);

        mini = Math.min(ans1, Math.min(ans2, ans3));
        return mini;
    }
}

// _________________________________________________________________________
// Using Memoization

import java.util.Arrays;

public class Video_33_Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        int ans = getMinimalEditDistance(s1, s2, 0, 0, dp);
        System.out.println(ans);
    }

    public static int getMinimalEditDistance(String s1, String s2, int i, int j,
            int[][] dp) {
        if (i == s1.length()) {
            return s2.length() - j;
        } else if (j == s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = getMinimalEditDistance(s1, s2, i + 1, j + 1, dp);
        }

        int insert = 1 + getMinimalEditDistance(s1, s2, i, j + 1, dp);
        int remove = 1 + getMinimalEditDistance(s1, s2, i + 1, j, dp);
        int replace = 1 + getMinimalEditDistance(s1, s2, i + 1, j + 1, dp);

        dp[i][j] = Math.min(Math.min(insert, remove), replace);
        return dp[i][j];
    }
}

// _________________________________________________________________________
// Using Tabulation

public class Video_33_Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int ans = getMinimalEditDistance(s1, s2);
        System.out.println(ans);
    }

    public static int getMinimalEditDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Base Cases
        for (int j = 0; j <= s2.length(); j++) {
            dp[s1.length()][j] = s2.length() - j;
        }

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][s2.length()] = s1.length() - i;
        }

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int mini = Integer.MAX_VALUE;

                    // Insert Operation
                    int ans1 = 1 + dp[i][j + 1];

                    // Remove Operation
                    int ans2 = 1 + dp[i + 1][j];

                    // Replace Operation
                    int ans3 = 1 + dp[i + 1][j + 1];

                    mini = Math.min(ans1, Math.min(ans2, ans3));
                    dp[i][j] = mini;
                }
            }
        }
        return dp[0][0];
    }
}

// _________________________________________________________________________
// Using Space optimization

public class Video_33_Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int ans = getMinimalEditDistance(s1, s2);
        System.out.println(ans);
    }

    public static int getMinimalEditDistance(String s1, String s2) {
        int[] front = new int[s2.length() + 1];
        int[] curr = new int[s2.length() + 1];
    
        // Base Cases
        for (int j = 0; j <= s2.length(); j++) {
            front[j] = s2.length() - j;
        }
        
        for (int i = s1.length() - 1; i >= 0; i--) {
            curr[s2.length()] = s1.length() - i;
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = front[j + 1];
                } else {
                    int mini = Integer.MAX_VALUE;
    
                    // Insert Operation
                    int ans1 = 1 + curr[j + 1];
    
                    // Remove Operation
                    int ans2 = 1 + front[j];
    
                    // Replace Operation
                    int ans3 = 1 + front[j + 1];
    
                    mini = Math.min(ans1, Math.min(ans2, ans3));
                    curr[j] = mini;
                }
            }
    
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        return front[0];
    }
}
