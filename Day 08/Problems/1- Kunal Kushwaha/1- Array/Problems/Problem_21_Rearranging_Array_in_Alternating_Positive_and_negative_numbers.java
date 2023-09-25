import java.util.Arrays;

public class Problem_21_Rearranging_Array_in_Alternating_Positive_and_negative_numbers {
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        findAns(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void findAns(int[] arr){
        int pt1 = 0;
        int pt2 = 0;
        Arrays.sort(arr);

        while(arr[pt2] < 0){
            pt2++;
        }

        while((pt1 < arr.length) && (pt2 < arr.length) && (arr[pt1] < 0) && (arr[pt2] >= 0)){
            if((arr[pt1] < 0) && (isEven(pt1))){
                pt1++;
            }
            if((pt1 < arr.length) && (pt2 < arr.length) && (arr[pt1] < 0) && (arr[pt2] >= 0)){
                swap(arr, pt1, pt2);
                pt1++;
                pt2++;
            }
            if((pt1 < arr.length) && (pt2 < arr.length) && (arr[pt1] >= 0) && (arr[pt2] >= 0)){
                break;
            }
        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static boolean isEven(int num){
        if(num == 0 || num%2 == 0){
            return true;
        }
        return false;
    }
}
