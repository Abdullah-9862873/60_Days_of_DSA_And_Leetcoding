package old;

class FloorOfANumber {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };
        int target = 10;

        // Floor is the greatest element that is smaller than or equal to the target
        int start = 0;
        int end = arr.length - 1;
        int ans = Integer.MIN_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target == arr[mid]) {
                ans = mid;
                break;
            }
        }
        if (start > end) {
            ans = end;
        }
        System.out.println(ans);
    }
}