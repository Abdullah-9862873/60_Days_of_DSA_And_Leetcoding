import java.util.Arrays;

public class Problem_4_Sort_an_array_of_0s_1s_and_2s{
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        dnf(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void dnf(int[] arr){
        // Using Dutch National Flag Algorithm
        int low, mid, high;
        low = 0;
        mid = 0;
        high = arr.length-1;

        while(mid <= high){
            if(mid < high && arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }
            if(mid < high && arr[mid] == 1){
                mid++;
            }
            if(mid < high && arr[mid] == 2){
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}