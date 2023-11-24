// ___________________________________________________________
// Using Recursion

// public class Video_34_Wildcard_Matching {
//     public static void main(String[] args) {
//         String str1 = "aa";
//         String str2 = "*";
//         boolean ans = isWildCardMatching(str1, str2, 0, 0);
//         System.out.println(ans);
//     }

//     public static boolean isWildCardMatching(String s1, String s2, int i, int j) {
//         if (i == s1.length() && j == s2.length()) {
//             return true;
//         }
//         if (i == s1.length()) {
//             for (int k = j; k < s2.length(); k++) {
//                 if (s2.charAt(k) != '*') {
//                     return false;
//                 }
//             }
//             return true;
//         } else if (j == s2.length()) {
//             return false;
//         }

//         if ((i < s1.length() && j < s2.length()) && ((s1.charAt(i) == s2.charAt(j) ||
//                 s1.charAt(i) == '?' || s2.charAt(j) == '?'))) {
//             return isWildCardMatching(s1, s2, i + 1, j + 1);
//         }

//         if ((i < s1.length() && j < s2.length()) && ((s1.charAt(i) == '*') ||
//                 (s2.charAt(j) == '*'))) {
//             // Taking the star as against 0 length character
//             boolean ans1 = isWildCardMatching(s1, s2, i + 1, j);
//             // Taking the star as character of length 1
//             boolean ans2 = isWildCardMatching(s1, s2, i, j + 1);
//             return ans1 || ans2;
//         }
//         return false;
//     }
// }

// _________________________________________________________
// Using Memoization
// import java.util.*;

// public class Video_34_Wildcard_Matching {
//     public static void main(String[] args) {
//         String str1 = "aa";
//         String str2 = "*";
//         int[][] dp = new int[str1.length()+1][str2.length()+1];
//         for(int[] temp: dp){
//             Arrays.fill(temp,-1);
//         }
//         boolean ans = isWildCardMatching(str1, str2, 0, 0, dp);
//         System.out.println(ans);
//     }

//     public static boolean isWildCardMatching(String s1, String s2, int i, int j,int[][] dp) {
//         if (i == s1.length() && j == s2.length()) {
//             return true;
//         }
//         if (i == s1.length()) {
//             for (int k = j; k < s2.length(); k++) {
//                 if (s2.charAt(k) != '*') {
//                     dp[i][j] = 0;
//                     return false;
//                 }
//             }
//             dp[i][j] = 1;
//             return true;
//         } else if (j == s2.length()) {
//             dp[i][j] = 0;
//             return false;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j] == 1;
//         }

//         if ((i < s1.length() && j < s2.length()) && ((s1.charAt(i) == s2.charAt(j) ||
//                 s1.charAt(i) == '?' || s2.charAt(j) == '?'))) {
//             boolean ans =  isWildCardMatching(s1, s2, i + 1, j + 1, dp);
//             dp[i][j] = ans ? 1 : 0;
//             return ans;
//         }

//         if ((i < s1.length() && j < s2.length()) && ((s1.charAt(i) == '*') ||
//                 (s2.charAt(j) == '*'))) {
//             // Taking the star as against 0 length character
//             boolean ans1 = isWildCardMatching(s1, s2, i + 1, j, dp);
//             // Taking the star as character of length 1
//             boolean ans2 = isWildCardMatching(s1, s2, i, j + 1, dp);
//             boolean ans = ans1 || ans2;
//             dp[i][j] = ans ? 1 : 0;
//             return ans;
//         }
//         return false;
//     }
// }

// _________________________________________________________
// Using Tabulation

// public class Video_34_Wildcard_Matching {
//     public static void main(String[] args) {
//         String str1 = "acdcb";
//         String str2 = "a*c?b";
//         boolean ans = isWildCardMatching(str1, str2);
//         System.out.println(ans);
//     }

//     public static boolean isWildcardMatching(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         int[][] dp = new int[m + 1][n + 1];
    
//         // Base Cases
//         dp[m][n] = 1;
//         for (int j = n - 1; j >= 0; j--) {
//             if (s2.charAt(j) != '*') {
//                 dp[m][j] = 0;
//             } else {
//                 dp[m][j] = dp[m][j + 1];
//             }
//         }
    
//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 0; j--) {
//                 if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {
//                     dp[i][j] = dp[i + 1][j + 1];
//                 } else if (s2.charAt(j) == '*') {
//                     // Taking the star as against 0 length character
//                     int ans1 = dp[i + 1][j];
//                     // Taking the star as character of length 1
//                     int ans2 = dp[i][j + 1];
//                     dp[i][j] = (ans1 == 1 || ans2 == 1) ? 1 : 0;
//                 }
//             }
//         }
//         return dp[0][0] == 1;
//     }    
// }

// _______________________________________________________
// Using space optimization


public class Video_34_Wildcard_Matching {
    public static void main(String[] args) {
        String str1 = "acdcb";
        String str2 = "a*c?b";
        boolean ans = isWildcardMatching(str1, str2);
        System.out.println(ans);
    }

    public static boolean isWildcardMatching(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] curr = new int[n + 1];
    
        // Base Cases
        curr[n] = 1;
        for (int j = n - 1; j >= 0; j--) {
            if (s2.charAt(j) != '*') {
                curr[j] = 0;
            } else {
                curr[j] = curr[j + 1];
            }
        }
    
        for (int i = m - 1; i >= 0; i--) {
            int[] front = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {
                    front[j] = curr[j + 1];
                } else if (s2.charAt(j) == '*') {
                    int ans1 = curr[j];
                    int ans2 = front[j + 1];
                    front[j] = (ans1 == 1 || ans2 == 1) ? 1 : 0;
                }
            }
            curr = front;
        }
        return curr[0] == 1;
    }
}
