
public class Video_46_Longest_Bitonic_Subsequence {
    public static void main(String[] args) {
        int[] arr = { 1, 11, 2, 10, 4, 5, 2, 1 };
        int ans = getLongestBitonicSubsequence(arr);
        System.out.println(ans);
    }

    public static int getLongestBitonicSubsequence(int[] arr) {
        // The idea is to get the longest increasing subsequence from the start till end
        // And get the longest increasing subsequence end to start
        // And make the bitonic array... dp[i] indicates that till i i-e including ith
        // index what was the increasing subsequence till then whether from start or
        // whether from end
        // So ith index of bitonic array indicates what will be the increasing lis from
        // start till ith index + what will be the increasing lis from end till ith
        // As we have included the ith index twice in the bitonic ith index... So we
        // have to reduce it to once... That is why we are doing -1

        int[] dpStartTillEnd = getLongestIncreasingSubsequence(arr, 0, arr.length - 1);
        int[] dpEndTillStart = getLongestIncreasingSubsequence(arr, arr.length-1, 0);
        int[] bitonicArr = new int[arr.length];

        int maxi = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            bitonicArr[i] = dpStartTillEnd[i] + dpEndTillStart[i] - 1;
            maxi = Integer.max(maxi, bitonicArr[i]);
        }
        return maxi;
        
    }

    public static int[] getLongestIncreasingSubsequence(int[] arr, int startIndex, int endIndex) {
        int[] dp = new int[arr.length];
        if (startIndex > endIndex) {
            // Reverse The Array
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    maxi = Math.max(maxi, dp[i]);
                }
            }
        }

        if (startIndex > endIndex) {
            // Reverse the dp
            int start = 0;
            int end = dp.length - 1;
            while (start < end) {
                int temp = dp[start];
                dp[start] = dp[end];
                dp[end] = temp;
                start++;
                end--;
            }
        }
        return dp;
    }
}
