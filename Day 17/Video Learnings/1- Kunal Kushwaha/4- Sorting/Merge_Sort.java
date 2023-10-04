import java.util.*;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,9,5,10,3,6};
        int n = arr.length;
        mergeSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        int i = low; 
        int left = low;
        int right = mid + 1; 
    
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[i] = arr[left];
                i++;
                left++;
            } else {
                temp[i] = arr[right];
                i++;
                right++;
            }
        }
    
        while (left <= mid) {
            temp[i] = arr[left];
            i++;
            left++;
        }
        while (right <= high) {
            temp[i] = arr[right];
            i++;
            right++;
        }
        
        for (int j = low; j <= high; j++) {
            arr[j] = temp[j];
        }
    }
    
}
