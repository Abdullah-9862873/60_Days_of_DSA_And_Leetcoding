// The idea is to find the maximum element and replace it with the last element
import java.util.*;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = {-7, -1, 3, 2, 0, -22};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int lastElement = arr.length-1-i;
            int max = findMaxElement(arr, 0, lastElement);
            swap(arr, max, lastElement);
        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static int findMaxElement(int[] arr, int start, int end){
        int max = 0;
        for(int i=start; i<=end; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}
