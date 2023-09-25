import java.util.Arrays;

public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 6, 8, 10};
        int[] nums2 = {2, 4, 6, 8, 10};

        int[] absDifference = new int[nums1.length];
        long sumOfAbsoluteDifference = 0L;
        for (int i = 0; i < nums1.length; i++) {
            absDifference[i] = Math.abs(nums1[i] - nums2[i]);
            sumOfAbsoluteDifference += absDifference[i];
        }

        // Find the lower bounds for each number of nums2 in nums1
        int[] lowerBounds = findLowerBounds(nums2, nums1);

        int max = -1;
        for (int i = 0; i < lowerBounds.length; i++) {
            max = Math.max(max, absDifference[i] - lowerBounds[i]);
        }
        long ans = sumOfAbsoluteDifference - max;
        System.out.println((int) (ans % 1_000_000_007));
    }

    public static int[] findLowerBounds(int[] base, int[] source) {
        int[] ans = new int[base.length];
        Arrays.sort(source);

        for (int i = 0; i < base.length; i++) {
            int element = base[i];

            int start = 0;
            int end = base.length - 1;
            int ansIndex = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (ansIndex == -1) {
                    ansIndex = mid;
                }
                if (element == source[mid]) {
                    ansIndex = mid;
                    break;
                } else if (element > source[mid]) {
                    int min = Math.min(Math.abs(source[mid] - element), Math.abs(source[ansIndex] - element));
                    if (min != Math.abs(source[ansIndex] - element)) {
                        ansIndex = mid;
                    }
                    start = mid + 1;
                } else if (element < source[mid]) {
                    int min = Math.min(Math.abs(source[mid] - element), Math.abs(source[ansIndex] - element));
                    if (min != Math.abs(source[ansIndex] - element)) {
                        ansIndex = mid;
                    }
                    end = mid - 1;
                }
            }
            ans[i] = Math.abs(source[ansIndex] - element);
        }
        return ans;
    }
}
