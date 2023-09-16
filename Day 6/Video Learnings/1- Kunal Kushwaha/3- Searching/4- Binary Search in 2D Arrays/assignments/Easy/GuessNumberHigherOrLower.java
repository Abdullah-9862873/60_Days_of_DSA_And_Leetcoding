import java.util.Scanner;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {

    }

    static int binarySearch(int[] arr, int start, int end) {
        start = 0;
        end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(start) == true) {
                ans = start;
                break;
            }
            if (isBadVersion(mid) == true) {
                ans = mid;
                if (mid > start) {
                    end = mid - 1;
                } else {
                    break;
                }
            }
            if (isBadVersion(mid) == false) {
                if (isBadVersion(mid + 1) == true) {
                    ans = mid + 1;
                    end = mid - 1;
                }
                if (isBadVersion(mid - 1) == true) {
                    ans = mid - 1;
                    end = mid - 2;
                }
            } else {
                int ans1 = binarySearch(arr, 0, mid - 1);
                int ans2 = binarySearch(arr, mid + 1, arr.length - 1);
                if (ans1 < ans2) {
                    ans = ans1;
                } else {
                    ans = ans2;
                }
            }
        }
        return ans;
    }
}
