import java.util.Arrays;

public class Problem_01_ReverseTheArray{
    public static void main(String[] args) {
        int[] arr = {4,5,1,2};

        arr = reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverse(int[] arr){
        int pt1 = 0;
        int pt2 = arr.length-1;

        while(pt1 < pt2){
            swap(arr, pt1, pt2);
            pt1++;
            pt2--;
        }
        return arr;
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}