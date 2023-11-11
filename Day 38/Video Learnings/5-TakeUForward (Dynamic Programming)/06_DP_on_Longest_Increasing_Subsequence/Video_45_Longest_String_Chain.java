import java.util.Arrays;
import java.util.Comparator;

public class Video_45_Longest_String_Chain {
    public static void main(String[] args) {
        String[] arr = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int ans = getMaxChainLength(arr);
        System.out.println(ans);
    }

    public static int getMaxChainLength(String arr[]) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];

        // Sort the array based on string length in ascending order.
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        int maxi = Integer.MIN_VALUE;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (compare(arr[i], arr[prev]) && (1 + dp[prev] > dp[i])) {
                    dp[i] = 1 + dp[prev];
                    if (dp[i] > maxi) {
                        maxi = dp[i];
                        lastIndex = i;
                    }
                    hash[i] = prev;
                }
            }
        }

        String[] ans = new String[maxi];
        for (int i = 0; i < ans.length; i++) {
            String val = arr[lastIndex];
            ans[i] = val;
            lastIndex = hash[lastIndex];
        }

        int start = 0;
        int end = ans.length-1;
        while(start < end){
            String temp = ans[start];
            ans[start] = ans[end];
            ans[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(ans));

        return maxi;
    }

    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}
