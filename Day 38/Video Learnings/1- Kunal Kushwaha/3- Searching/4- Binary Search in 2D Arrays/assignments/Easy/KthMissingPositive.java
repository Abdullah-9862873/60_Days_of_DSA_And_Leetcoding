

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2};
        int k = 1;
        int ans = findMissingPositive(arr, k);
        System.out.println(ans);
    }
    public static int findMissingPositive(int[] arr, int k){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            int missingNumber = arr[mid] - (mid+1);
            if(missingNumber < k){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        // whatMoreToAdd = (k - (arr[end]-(end+1)));
        // ans = arr[end] + whatMoreToAdd
        // ans = arr[end] + k - arr[end] + end + 1
        // ans = k + end + 1
        int ans = k + end + 1;
        return ans;
    }
}
