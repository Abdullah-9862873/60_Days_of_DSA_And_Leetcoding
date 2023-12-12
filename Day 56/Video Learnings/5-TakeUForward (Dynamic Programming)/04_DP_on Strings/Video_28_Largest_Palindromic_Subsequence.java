/*
Problem Statement:
If you are given one strings 

str = "bbabcbcab"

Then you have to give what is the largest subsequence in the given string that is palindrome...

//_______________________________________________________________________________
Thought Process:

This question is exactly similar to Longest Common Subsequence... Look what are we looking for... We are looking for the subsequence that is palindrome... And by palindrome it means that from whatever side you read it, it sounds or written as same...  So 

s1 = "bbabcbcab"
s2 = Reverse of the s1 = "bacbcbabb"

we can look at  the longest commom subsequence in both the strings are "babcbab" which gives 7

Can we use the tabulation method of the Longest common subsequence?? 
The answer is yes
*/

//__________________________________________________________________
// Using Tabulation method of the Longest Common Subsequence

// public class Video_28_Largest_Palindromic_Subsequence {
    //     public static void main(String[] args) {
        //         String str = "bbabcbcab";
        
        //         int ans = getLargestPalindromicSubsequence(str);
        //         System.out.println(ans);
        //     }
    //         public static int getLargestPalindromicSubsequence(String str){
    //                 // Finding the reverse of the string
            
    //                 StringBuilder sb = new StringBuilder();
    //                 for(int i=str.length()-1; i>=0; i--){
    //                         sb.append(str.charAt(i));
    //                     }
    //     String str2 = sb.toString();
    //     int ans = getLongestCommonSubsequence(str, str2);
    //     return ans;
    // }
    // public static int getLongestCommonSubsequence(String s1, String s2) {
    //     int[][] dp = new int[s1.length() + 1][s2.length() + 1];

    //     // Base Cases
    //     for (int i = s1.length(); i >= 0; i--) {
    //             for (int j = s2.length(); j >= 0; j--) {
    //                     if(i == s1.length() || j == s2.length()){
    //                             dp[i][j] = 0;
    //             }
    //             else if (s1.charAt(i) == s2.charAt(j)) {
    //                     dp[i][j] = 1 + dp[i + 1][j + 1];
    //             } else {
    //                     dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
    //             }
    //         }
    //     }

    //     return dp[0][0];
    // }
// }

//__________________________________________________________________
// Using Space optimization

public class Video_28_Largest_Palindromic_Subsequence {
    public static void main(String[] args) {
        String str = "bbabcbcab";

        int ans = getLargestPalindromicSubsequence(str);
        System.out.println(ans);
    }
    public static int getLargestPalindromicSubsequence(String str){
        // Finding the reverse of the string

        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        String str2 = sb.toString();
        int ans = getLongestCommonSubsequence(str, str2);
        return ans;
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
