package old;

public class PeakElementInAnArray {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 6, 9, 10, 2, 3, 1 };
        // int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

        int ans = findPeak(nums);
        System.out.println(ans);

    }

    static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // I might be in decreasing part of the array and there might be a chance that
                // the answer lies on the left side so I don't have to take the mid+1 element
                // inside the array and also that end might be the answer so I can't lose it by
                // mid-1
                end = mid;
            } else {
                // Here I know that the previous element is smaller so I don't have to include
                // that in the final array
                start = mid + 1;
            }
        }
        return start;
    }
}
