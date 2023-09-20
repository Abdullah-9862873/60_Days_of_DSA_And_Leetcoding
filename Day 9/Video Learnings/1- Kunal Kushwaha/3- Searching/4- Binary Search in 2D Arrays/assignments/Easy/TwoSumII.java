import java.util.*;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = { 11, 13, 17, 19, 22, 24, 30 };
        int target = 28;

        int[] ans = findAns(numbers, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findAns(int[] arr, int target) {
        int[] ans = new int[2];
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];
            int findTarget = binarySearch(arr, complement, i + 1, n - 1);

            if (findTarget != -1) {
                ans[0] = i + 1; // 1-based index
                ans[1] = findTarget + 1; // 1-based index
                break;
            }
        }
        
        return ans;
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
