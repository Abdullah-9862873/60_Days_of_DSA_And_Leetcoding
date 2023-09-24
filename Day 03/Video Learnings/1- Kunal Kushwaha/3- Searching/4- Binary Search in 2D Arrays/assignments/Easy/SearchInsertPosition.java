public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;

        int ans = binarySearch(nums, target);
        if(ans != -1){
            System.out.println(ans);
        }else{
            int justSmallerNum = findJustSmallerNumber(nums, target);
            System.out.println(justSmallerNum+1);
        }

    }

    public static int findJustSmallerNumber(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int potentialAns = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(target > arr[mid]){
                potentialAns = mid;
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }
        }
        return potentialAns;
    }
    public static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(target > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
