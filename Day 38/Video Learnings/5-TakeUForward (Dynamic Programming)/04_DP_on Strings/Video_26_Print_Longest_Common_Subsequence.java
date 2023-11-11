//___________________________________________________________________
// Using Tabulation from the previous lecture

public class Video_26_Print_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        String ans = getLongestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }

    public static String getLongestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    sb.insert(0, s1.charAt(i));
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);

                }
            }
        }
        // My answer lies in the dp[0][0]
        String ans = sb.toString();
        return ans;
    }
}

// __________________________________________________________________
// Using Space optimization

public class Video_26_Print_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";

        String ans = getLongestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }

    public static String getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    curr[j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = 1 + front[j + 1];
                    sb.insert(0, s1.charAt(i));
                } else {
                    curr[j] = Math.max(front[j], curr[j + 1]);
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }
        // My answer lies in the dp[0][0]
        String ans = sb.toString();
        return ans;
    }
}