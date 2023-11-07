package neww;

public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int k = 0;

        int pivot = findPivot(arr);
        k = pivot + 1;
        System.out.println(k);
    }

    // Finding pivot in array with distinct values
    static int findPivot(int[] arr) {
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

}
