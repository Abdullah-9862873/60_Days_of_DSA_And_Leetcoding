
public class CapacityToShipPackageWithindDays {
    public static void main(String[] args) {
        int[] weights = { 1,2,3,1,1};
        int days = 4;

        int ans = findLeastCapacityToShip(weights, days);
        System.out.println(ans);
    }

    public static int findLeastCapacityToShip(int[] weights, int days) {

        int start = findMax(weights);
        int end = findEnd(weights);
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int daysCount = findDays(weights, mid);
            if (daysCount <= days){
                end = mid - 1;
                ans = mid;
            } else if (daysCount > days) {
                start = mid + 1;
            }
        }
        return ans;
    }
    public static int findMax(int[] arr){
        int max = -1;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static int findDays(int[] arr, int mid) {
        int days = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                days += 1;
                sum = 0;
                i--;
            }
        }
        days += 1;
        return days;
    }

    public static int findEnd(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

}
