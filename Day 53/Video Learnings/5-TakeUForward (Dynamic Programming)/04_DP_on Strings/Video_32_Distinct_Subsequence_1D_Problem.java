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

// public class Video_32_Distinct_Subsequence_1D_Problem{
// public static void main(String[] args) {
// String s1 = "babgbag";
// String s2 = "bag";

// int ans = getAllSubsequenceOccurence(s1,s2, 0,0);
// System.out.println(ans);
// }

// public static int getAllSubsequenceOccurence(String s1, String s2, int i, int
// j){
// if(j==s2.length() || i == s1.length() && j == s2.length()){
// return 1;
// }
// if(i == s1.length() && j < s2.length()){
// return 0;
// }

// int count = 0;

// if(s1.charAt(i) == s2.charAt(j)){
// count += getAllSubsequenceOccurence(s1, s2, i+1, j+1);
// }
// count += getAllSubsequenceOccurence(s1, s2, i+1, j);
// return count;
// }
// }

// _________________________________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_32_Distinct_Subsequence_1D_Problem {
//     public static void main(String[] args) {
//         String s1 = "babgbag";
//         String s2 = "bag";

//         int[][] dp = new int[s1.length()][s2.length()];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }
//         int ans = getAllSubsequenceOccurence(s1, s2, 0, 0, dp);
//         System.out.println(ans);
//     }

//     public static int getAllSubsequenceOccurence(String s1, String s2, int i, int j, int[][] dp) {
//         if (j == s2.length() || i == s1.length() && j == s2.length()) {
//             return 1;
//         }
//         if (i == s1.length() && j < s2.length()) {
//             return 0;
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         int count = 0;

//         if (s1.charAt(i) == s2.charAt(j)) {
//             count += getAllSubsequenceOccurence(s1, s2, i + 1, j + 1, dp);
//         }
//         count += getAllSubsequenceOccurence(s1, s2, i + 1, j, dp);
//         return dp[i][j] = count;
//     }
// }

// _________________________________________________________________________
// Using Tabulation

// public class Video_32_Distinct_Subsequence_1D_Problem {
//     public static void main(String[] args) {
//         String s1 = "babgbag";
//         String s2 = "bag";

//         int ans = getAllSubsequenceOccurence(s1, s2, 0, 0);
//         System.out.println(ans);
//     }

//     public static int getAllSubsequenceOccurence(String s1, String s2, int i, int j) {
//         int[][] dp = new int[s1.length() + 1][s2.length() + 1];

//         // Base Cases
//         for (int k = 0; k <= s1.length(); k++) {
//             dp[k][s2.length()] = 1;
//         }
//         dp[s1.length()][s2.length()] = 1;

//         for (int k = s1.length() - 1; k >= 0; k--) {
//             for (int l = s2.length() - 1; l >= 0; l--) {
//                 int count = 0;
//                 if (k == s1.length() && l < s2.length()) {
//                     dp[k][l] = 0;
//                 } else if (s1.charAt(k) == s2.charAt(l)) {
//                     count += dp[k + 1][l + 1];
//                 }
//                 count += dp[k + 1][l];

//                 dp[k][l] = count;
//             }
//         }
//         return dp[0][0];
//     }
// }

// _________________________________________________________________________
// Using Space optimization

public class Video_32_Distinct_Subsequence_1D_Problem {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        int ans = getAllSubsequenceOccurence(s1, s2, 0, 0);
        System.out.println(ans);
    }

    public static int getAllSubsequenceOccurence(String s1, String s2, int i, int j) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        // Base Cases
        curr[s2.length()] = 1;
        front[s2.length()] = 1;

        for (int k = s1.length() - 1; k >= 0; k--) {
            for (int l = s2.length() - 1; l >= 0; l--) {
                int count = 0;
                if (k == s1.length() && l < s2.length()) {
                    curr[l] = 0;
                } else if (s1.charAt(k) == s2.charAt(l)) {
                    count += front[l + 1];
                }
                count += front[l];

                curr[l] = count;
            }
            int[] temp = front;
            front = curr;
            curr = temp;             
        }
        return front[0];
    }
}