/*
Problem Statement:
Lets say you have two strings given:
str1 = "brute"
str2 = "groot"

Supersequence means, you have to make a string in which there are both str1 "brute" and "groot" present... like a string "brutegroot" is a supersequence which is of length 10 it has both of them... You have to make this supersequence shortest...

Shortest supersequence in this case can be "bgruoote" which is of length 8
*/

//________________________________________________________________
// Using Tabulation

public class Video_31_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";

        // _________Printing SuperSequence_________
        String ans1 = getShortestCommonSuperSequence(str1, str2);
        System.out.println(ans1);

        // _________Printing Just Length Of SuperSequence_________
        int lcs = getLongestCommonSubsequence(str1, str2);
        int ans2 = lcs + (str1.length() - lcs) + (str2.length() - lcs);
        System.out.println(ans2);
    }

    public static int getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    curr[j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
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

    public static String getShortestCommonSuperSequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    sb.append(s1.charAt(i));
                    i++;
                } else {
                    sb.append(s2.charAt(j));
                    j++;
                }
            }
        }

        while (i < s1.length()) {
            sb.append(s1.charAt(i));
            i++;
        }
        while (j < s2.length()) {
            sb.append(s2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}

// ________________________________________________________________
// Using Space optimization

public class Video_31_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        String str1 = "brute";
        String str2 = "groot";

        // _________Printing SuperSequence_________
        String ans1 = getShortestCommonSuperSequence(str1, str2);
        System.out.println(ans1);

        // _________Printing Just Length Of SuperSequence_________
        int lcs = getLongestCommonSubsequence(str1, str2);
        int ans2 = lcs + (str1.length() - lcs) + (str2.length() - lcs);
        System.out.println(ans2);
    }

    public static int getLongestCommonSubsequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    curr[j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
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

    public static String getShortestCommonSuperSequence(String s1, String s2) {
        int[] front = new int[s1.length() + 1];
        int[] curr = new int[s1.length() + 1];

        // Base Cases
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length() || j == s2.length()) {
                    curr[j] = 0;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = 1 + front[j + 1];
                } else {
                    curr[j] = Math.max(front[j], curr[j + 1]);
                }
            }
            int[] temp = front;
            front = curr;
            curr = temp;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else {
                if (front[j] > curr[j + 1]) {
                    sb.append(s1.charAt(i));
                    i++;
                } else {
                    sb.append(s2.charAt(j));
                    j++;
                }
            }
        }

        while (i < s1.length()) {
            sb.append(s1.charAt(i));
            i++;
        }
        while (j < s2.length()) {
            sb.append(s2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}