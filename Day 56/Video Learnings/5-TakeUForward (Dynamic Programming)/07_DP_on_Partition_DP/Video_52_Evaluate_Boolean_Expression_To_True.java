//_________________________________________________________
// Using Recursion

// public class Video_52_Evaluate_Boolean_Expression_To_True {
//     public static void main(String[] args) {
//         String str = "t^f|t&f^t|f";
//         Long ans = getNoOfTrueExpressions(str, 0, str.length() - 1, false);
//         System.out.println(ans);
//     }
//     public static int mod = 1000000007;

//     public static Long getNoOfTrueExpressions(String str, int i, int j, boolean isTrue) {
//         if (i > j) {
//             return 0L;
//         }
//         if (i == j) {
//             if (isTrue) {
//                 if (str.charAt(i) == 't' || str.charAt(i) == 'T') {
//                     return 1L;
//                 } else {
//                     return 0L;
//                 }
//             } else {
//                 if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
//                     return 1L;
//                 } else {
//                     return 0L;
//                 }
//             }
//         }

//         Long ways = 0L;

//         for(int ind=i+1; ind<=j; ind+=2){
//             Long leftTrue = getNoOfTrueExpressions(str, i, ind-1, true);
//             Long leftFalse = getNoOfTrueExpressions(str, i, ind-1, false);
//             Long rightTrue = getNoOfTrueExpressions(str, ind+1, j, true);
//             Long rightFalse = getNoOfTrueExpressions(str, ind+1, j, false);

//             if(str.charAt(ind) == '|'){
//                 if(isTrue){
//                     ways = (ways + (leftTrue * rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse * rightTrue)%mod)%mod;
//                     ways = (ways + (leftTrue * rightFalse)%mod)%mod;
//                 }else{
//                     ways = (ways + (leftFalse * rightFalse)%mod)%mod;
//                 }
//             }else if(str.charAt(ind) == '&'){
//                 if(isTrue){
//                     ways = ways + (leftTrue * rightTrue)%mod;
//                 }else{
//                     ways = (ways + (leftFalse * rightFalse)%mod)%mod;
//                     ways = (ways + (leftFalse * rightTrue)%mod)%mod;
//                     ways = (ways + (leftTrue * rightFalse)%mod)%mod;
//                 }
//             }else if(str.charAt(ind) == '^'){
//                 if(isTrue){
//                     ways = (ways + (leftFalse*rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse*rightFalse)%mod)%mod;
//                 }else{
//                     ways = (ways + (leftTrue*rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse*rightFalse)%mod)%mod;
//                 }
//             }
//         }
//         return ways;
//     }
// }

//_________________________________________________________
// Using Memoization
// import java.util.*;

// public class Video_52_Evaluate_Boolean_Expression_To_True {
//     public static void main(String[] args) {
//         String str = "t^f|t&f^t|f";
//         Long[][][] dp = new Long[str.length()][str.length()][2];
//         for(Long[][] temp: dp){
//             for(Long[] temp2: temp){
//                 Arrays.fill(temp2, -1L);
//             }
//         }
//         Long ans = getNoOfTrueExpressions(str, 0, str.length() - 1, false,dp);
//         System.out.println(ans);
//     }
//     public static int mod = 1000000007;
//     public static Long getNoOfTrueExpressions(String str, int i, int j, boolean isTrue, Long[][][] dp) {
//         if (i > j) {
//             return 0L;
//         }
//         if (i == j) {
//             if (isTrue) {
//                 if (str.charAt(i) == 't' || str.charAt(i) == 'T') {
//                     return 1L;
//                 } else {
//                     return 0L;
//                 }
//             } else {
//                 if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
//                     return 1L;
//                 } else {
//                     return 0L;
//                 }
//             }
//         }
//         int val = 1;
//         if(!isTrue){
//             val = 0;
//         }
//         if(dp[i][j][val] != -1L){
//             return dp[i][j][val];
//         }

//         Long ways = 0L;

//         for(int ind=i+1; ind<=j; ind+=2){
//             Long leftTrue = getNoOfTrueExpressions(str, i, ind-1, true,dp);
//             Long leftFalse = getNoOfTrueExpressions(str, i, ind-1, false,dp);
//             Long rightTrue = getNoOfTrueExpressions(str, ind+1, j, true,dp);
//             Long rightFalse = getNoOfTrueExpressions(str, ind+1, j, false,dp);

//             if(str.charAt(ind) == '|'){
//                 if(isTrue){
//                     ways = (ways + (leftTrue * rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse * rightTrue)%mod)%mod;
//                     ways = (ways + (leftTrue * rightFalse)%mod)%mod;
//                 }else{
//                     ways = (ways + (leftFalse * rightFalse)%mod)%mod;
//                 }
//             }else if(str.charAt(ind) == '&'){
//                 if(isTrue){
//                     ways = ways + (leftTrue * rightTrue)%mod;
//                 }else{
//                     ways = (ways + (leftFalse * rightFalse)%mod)%mod;
//                     ways = (ways + (leftFalse * rightTrue)%mod)%mod;
//                     ways = (ways + (leftTrue * rightFalse)%mod)%mod;
//                 }
//             }else if(str.charAt(ind) == '^'){
//                 if(isTrue){
//                     ways = (ways + (leftFalse*rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse*rightFalse)%mod)%mod;
//                 }else{
//                     ways = (ways + (leftTrue*rightTrue)%mod)%mod;
//                     ways = (ways + (leftFalse*rightFalse)%mod)%mod;
//                 }
//             }
//         }
//         return dp[i][j][val] = ways;
//     }
// }

//___________________________________________________________
// Using Tabulation

public class Video_52_Evaluate_Boolean_Expression_To_True {
    public static void main(String[] args) {
        String str = "t^f|t&f^t|f";
        Long ans = getNoOfTrueExpressions(str);
        System.out.println(ans);
    }

    public static int mod = 1000000007;

    public static Long getNoOfTrueExpressions(String str) {
        Long[][][] dp = new Long[str.length()][str.length()][2];

        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = 0; j <= str.length() - 1; j++) {
                if (i > j) {
                    continue;
                }
                for (int isTrue = 0; isTrue < 2; isTrue++) {
                    if (i == j) {
                        if (isTrue == 1) {
                            if (str.charAt(i) == 't' || str.charAt(i) == 'T') {
                                dp[i][j][isTrue] = 1L;
                            } else {
                                dp[i][j][isTrue] = 0L;
                            }
                        } else {
                            if (str.charAt(i) == 'f' || str.charAt(i) == 'F') {
                                dp[i][j][isTrue] = 1L;
                            } else {
                                dp[i][j][isTrue] = 0L;
                            }
                        }
                        continue;
                    }
                    Long ways = 0L;

                    for (int ind = i + 1; ind <= j-1; ind += 2) {
                        Long leftTrue = dp[i][ind - 1][1];
                        Long leftFalse = dp[i][ind - 1][0];
                        Long rightTrue = dp[ind + 1][j][1];
                        Long rightFalse = dp[ind + 1][j][0];

                        if (str.charAt(ind) == '|') {
                            if (isTrue==1) {
                                ways = (ways + (leftTrue * rightTrue) % mod) % mod;
                                ways = (ways + (leftFalse * rightTrue) % mod) % mod;
                                ways = (ways + (leftTrue * rightFalse) % mod) % mod;
                            } else {
                                ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                            }
                        } else if (str.charAt(ind) == '&') {
                            if (isTrue==1) {
                                ways = ways + (leftTrue * rightTrue) % mod;
                            } else {
                                ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                                ways = (ways + (leftFalse * rightTrue) % mod) % mod;
                                ways = (ways + (leftTrue * rightFalse) % mod) % mod;
                            }
                        } else if (str.charAt(ind) == '^') {
                            if (isTrue==1) {
                                ways = (ways + (leftFalse * rightTrue) % mod) % mod;
                                ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                            } else {
                                ways = (ways + (leftTrue * rightTrue) % mod) % mod;
                                ways = (ways + (leftFalse * rightFalse) % mod) % mod;
                            }
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][str.length()-1][0];
    }
}