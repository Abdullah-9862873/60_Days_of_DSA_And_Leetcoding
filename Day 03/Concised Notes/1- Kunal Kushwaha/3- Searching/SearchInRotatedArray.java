package neww;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        int pivot = pivotWithDuplicates(nums);

        int ans = binarySearch(nums, target, 0, pivot);
        if (ans != -1) {
            System.out.println(ans);
        } else {
            int ans2 = binarySearch(nums, target, pivot + 1, nums.length - 1);
            System.out.println(ans2);
        }
    }

    // Find the pivot or the greatest element in array
    // This will not work for duplicate values
    static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Case 1
            if (mid < end && arr[mid] > arr[mid + 1]) {
                ans = mid;
            }
            // Case 2
            if (mid > start && arr[mid] < arr[mid - 1]) {
                ans = mid - 1;
            }
            // Case 3
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            }
            // Case 4
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int pivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // Case 1
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
            }
            if (arr[mid] < arr[mid - 1]) {
                ans = mid - 1;
            }

            // Checking for the duplicates
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // But what if the start or end are the pivots
                if (arr[start] > arr[start + 1]) {
                    ans = start;
                }
                start++;
                if (arr[end - 1] > arr[end]) {
                    ans = end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else if (arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    // Binary search
    static int binarySearch(int[] arr, int target, int start, int end) {
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = start + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
