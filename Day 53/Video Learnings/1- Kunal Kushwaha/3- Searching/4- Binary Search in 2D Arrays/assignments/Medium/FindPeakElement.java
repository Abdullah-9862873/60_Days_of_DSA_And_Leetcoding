public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        int peak = findPeak(arr);
        System.out.println(arr[peak]);
    }
    public static int findPeak(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if((mid < arr.length-1) && (arr[mid] <= arr[mid+1])){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
