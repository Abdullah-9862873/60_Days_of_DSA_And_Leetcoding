public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,1};
        
        int peak = findPeak(arr);
        int ans = -1;
        if(peak < arr.length-1){
            ans = peak + 1;
        }else {
            ans = 0;
        }
        System.out.println(arr[ans]);
    }

    public static int findPeak(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid > start && arr[mid] < arr[mid-1]){
                ans = mid-1;
                return ans;
            }
            if(mid < end && arr[mid] > arr[mid+1]){
                ans = mid;
                return ans;
            }
            if(arr[mid] >= arr[start]){
                start = mid + 1;
            }
            else if(arr[mid] < arr[start]){
                end = mid-1;
            }
        }
        return ans;
    }
}