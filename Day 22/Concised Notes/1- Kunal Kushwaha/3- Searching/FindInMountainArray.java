package neww;

public class FindinMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 1};
        int target = 2;

        int peak = findPeakElement(arr);
        if(target != arr[peak]){
            int first = binarySearch(arr, target, 0, peak-1);
            int second = binarySearch(arr, target, peak+1, arr.length-1);
            int finalAns = Math.min(first, second);
            System.out.println(finalAns);
        }else{
            System.out.println(peak);
        }
        
    }

    // Finding the peak element
    public static int findPeakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start) /2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }


    // Binary Search the element target
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
// Algorithm is simply to find the peak element and then apply the binary search on its left and right side and find the answers then the answer that is small is your answer