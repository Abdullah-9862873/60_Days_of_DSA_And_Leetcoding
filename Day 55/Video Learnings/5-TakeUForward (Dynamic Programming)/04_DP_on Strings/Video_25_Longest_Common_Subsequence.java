/*
Problem Statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'. For a string 'str' (per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K. 
Example :
Subsequences of string "abc" are: "" (empty string), a, b, c, ab, bc, ac, abc.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3
Time Limit: 1 sec

Sample Input 1 :
adebc
dcadb

Sample Output 1 :
3

Explanation Of The Sample Output 1 :

Both the strings contain a common
subsequence 'adb', which is the longest
common subsequence with length 3.
*/
//__________________________________________________________
// Using Recursion

// public class Video_25_Longest_Common_Subsequence{
//     public static void main(String[] args) {
//         String s1 = "adebc";
//         String s2 = "dcadb";

//         int ans = getLongestCommonSubsequence(s1,s2,0,0);
//         System.out.println(ans);
//     }
//     public static int getLongestCommonSubsequence(String s1, String s2, int ind1, int ind2){
//         if(ind1 >= s1.length() || ind2 >= s2.length()){
//             return 0;
//         }

//         // If Match
//         if(s1.charAt(ind1) == s2.charAt(ind2)){
//             return 1 + getLongestCommonSubsequence(s1, s2, ind1+1, ind2+1);
//         }

//         // If not match
//         return 0 + Math.max(getLongestCommonSubsequence(s1, s2, ind1+1, ind2), getLongestCommonSubsequence(s1, s2, ind1, ind2+1));
//     }
// }

//__________________________________________________________
// Using Memoization
// import java.util.*;
// public class Video_25_Longest_Common_Subsequence{
//     public static void main(String[] args) {
//         String s1 = "adebc";
//         String s2 = "dcadb";

//         int[][] dp = new int[s1.length()][s2.length()];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }

//         int ans = getLongestCommonSubsequence(s1,s2,0,0, dp);
//         System.out.println(ans);
//     }
//     public static int getLongestCommonSubsequence(String s1, String s2, int ind1, int ind2, int[][] dp){
//         if(ind1 >= s1.length() || ind2 >= s2.length()){
//             return 0;
//         }
//         if(dp[ind1][ind2] != -1){
//             return dp[ind1][ind2];
//         }

//         // If Match
//         if(s1.charAt(ind1) == s2.charAt(ind2)){
//             return dp[ind1][ind2] = 1 + getLongestCommonSubsequence(s1, s2, ind1+1, ind2+1,dp);
//         }

//         // If not match
//         return dp[ind1][ind2] = 0 + Math.max(getLongestCommonSubsequence(s1, s2, ind1+1, ind2,dp), getLongestCommonSubsequence(s1, s2, ind1, ind2+1,dp));
//     }
// }

//___________________________________________________________________
// Using Tabulation

// public class Video_25_Longest_Common_Subsequence {
//     public static void main(String[] args) {
//         String s1 = "adebc";
//         String s2 = "dcadb";
        
//         int ans = getLongestCommonSubsequence(s1, s2);
//         System.out.println(ans);
//     }

    // public static int getLongestCommonSubsequence(String s1, String s2) {
    //     int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
    //     // Base Cases
    //     for (int i = s1.length(); i >= 0; i--) {
    //         for (int j = s2.length(); j >= 0; j--) {
    //             if(i == s1.length() || j == s2.length()){
    //                 dp[i][j] = 0;
    //             }
    //             else if (s1.charAt(i) == s2.charAt(j)) {
    //                 dp[i][j] = 1 + dp[i + 1][j + 1];
    //             } else {
    //                 dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
    //             }
    //         }
    //     }
        
    //     return dp[0][0];
    // }
// }
//___________________________________________________________________
// Using Space Optimization

public class Video_25_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        
        int ans = getLongestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }

    public static int getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];
        
        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if(i == s1.length() || j == s2.length()){
                    curr[j] = 0;
                }
                else if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = 1 + front[j + 1];
                } else {
                    curr[j] = Math.max(front[j], curr[j + 1]);
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        
        return front[0];

    }
}