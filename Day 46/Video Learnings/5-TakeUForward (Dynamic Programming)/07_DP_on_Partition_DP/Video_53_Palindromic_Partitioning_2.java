//______________________________________________________
// Using Recursion

// public class Video_53_Palindromic_Partitioning_2 {
//     public static void main(String[] args) {
//         String str = "aaccb";
//         int ans = getMinPalindromicPartitions(str, 0);
//         // We are doing ans-1 because it is doing the partition at the last of the str which is not allowed like for "abc" it is doing 3 partitions which are "a|b|c|" so have to omit the last one and it should remain "a|b|c"
//         System.out.println(ans-1);
//     }
//     public static int getMinPalindromicPartitions(String str, int i){
//         if(i == str.length()){
//             return 0;
//         }

//         int mini = Integer.MAX_VALUE;
//         for(int j=i; j<str.length(); j++){
//             if(isPalindrome(str, i, j)){
//                 int cost = 1 + getMinPalindromicPartitions(str, j+1);
//                 mini = Math.min(mini,cost);
//             }
//         }
//         return mini;
//     }
//     public static boolean isPalindrome(String str, int start, int end){
//         while(start >= 0 && start < str.length() && end >= 0 && end < str.length() && start < end){
//             if(str.charAt(start) == str.charAt(end)){
//                 start++;
//                 end--;
//             }else{
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//____________________________________________________
// Using Memoization

// import java.util.*;

// public class Video_53_Palindromic_Partitioning_2 {
//     public static void main(String[] args) {
//         String str = "aaccb";
//         int[] dp = new int[str.length()];
//         Arrays.fill(dp,-1);
//         int ans = getMinPalindromicPartitions(str, 0,dp);
//         System.out.println(ans-1);
//     }
//     public static int getMinPalindromicPartitions(String str, int i,int[] dp){
//         if(i == str.length()){
//             return 0;
//         }
//         if(dp[i] != -1){
//             return dp[i];
//         }

//         int mini = Integer.MAX_VALUE;
//         for(int j=i; j<str.length(); j++){
//             if(isPalindrome(str, i, j)){
//                 int cost = 1 + getMinPalindromicPartitions(str, j+1,dp);
//                 mini = Math.min(mini,cost);
//             }
//         }
//         return dp[i] = mini;
//     }
//     public static boolean isPalindrome(String str, int start, int end){
//         while(start >= 0 && start < str.length() && end >= 0 && end < str.length() && start < end){
//             if(str.charAt(start) == str.charAt(end)){
//                 start++;
//                 end--;
//             }else{
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//____________________________________________________
// Using Tabulation

public class Video_53_Palindromic_Partitioning_2 {
    public static void main(String[] args) {
        String str = "aaccb";
        int ans = getMinPalindromicPartitions(str);
        System.out.println(ans - 1);
    }

    public static int getMinPalindromicPartitions(String str) {
        int[] dp = new int[str.length()+1];

        for (int i = str.length() - 1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    int cost = 1 + dp[j + 1];
                    mini = Math.min(mini, cost);
                }
            }
            dp[i] = mini;
        }
        return dp[0];
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start >= 0 && start < str.length() && end >= 0 && end < str.length() && start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}