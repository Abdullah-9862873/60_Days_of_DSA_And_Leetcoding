public class FindMinInRotatedSortedArrayContainingDuplicates {
    public static void main(String[] args) {
        int[] arr = {3,3,3,1};
        int min = findMin(arr);
        System.out.println(arr[min]);
    }
    public static int findMin(int[] arr){
        int peak = findPeak(arr);
        int start = 0;
        int end = arr.length-1;
        if(peak == start && start < arr.length-1){
            return start+1;
        }else if(peak == end && end > 0){
            return 0;
        }else{
            return peak + 1;
        }
    }
    public static int findPeak(int[] arr){
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        if(arr[end] > arr[start]){
            return end;
        }

        while(start <= end){
            int mid = start + (end-start)/2;
            // Case 1
            if(mid > 0 && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            // Case 2
            else if(mid < arr.length-1 && arr[mid] > arr[mid+1]){
                return mid;
            }
            // Case 3
            else if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(start < arr.length-1 && arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                if(end > 0 && arr[end-1] > arr[end]){
                    return end-1;
                }
                end--;
            }
            // Case 4
            else if(arr[start] < arr[mid]){
                start = mid + 1;
            }else if(arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }
}
