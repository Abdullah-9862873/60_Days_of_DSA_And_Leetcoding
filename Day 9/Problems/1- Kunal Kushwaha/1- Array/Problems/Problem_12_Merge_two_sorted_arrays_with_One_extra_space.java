import java.util.Arrays;

// Optimal Approach is to use the Gap method
/*
Gap method is a method that used the two pointers and there is a gap between those two pointers... The gap is (arr1.length + arr2.length)/2.... And then the gap gets reduced with gap/2... Till the gap remains 1 and the last operation will be performed then...

like at first gap will be 5+3/2 ---> 8/2 ---> 4
Second time -----------------------> 4/2 ---> 2
Third time ------------------------> 2/2 ---> 1

Then when it becomes zero... Then it will get stopped
 */
public class Problem_12_Merge_two_sorted_arrays_with_One_extra_space {
    public static void main(String[] args) {
        int[] arr1 = { 3, 27, 38, 43 };
        int[] arr2 = { 9, 10, 82 };

        mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // left is in arr1 and right is in arr2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }else if(left >= n){
                    // both are in arr2
                    swapIfGreater(arr2, arr2, left-n, right-n);
                }
                 else {
                    // left and right are in arr1
                    swapIfGreater(arr1, arr1, left, right);
                } 
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
        return;
    }
}

// Better Approach to do this question
// public class Problem_12_Merge_two_sorted_arrays_with_One_extra_space {
// public static void main(String[] args) {
// int[] arr1 = {1,4,7,8,10};
// int[] arr2 = {2,3,9};

// mergeSortedArrays(arr1, arr2);
// System.out.println(Arrays.toString(arr1));
// System.out.println(Arrays.toString(arr2));
// }
// public static void mergeSortedArrays(int[] arr1, int[] arr2){
// int pt1 = 0;
// int pt2 = 0;

// // I will deal the equal case shortly !!!!!!
// while(true){
// if(pt1 < arr1.length && pt2 < arr2.length && arr1[pt1] < arr2[pt2]){
// pt1++;
// }else if(pt1 < arr1.length && pt2 < arr2.length && arr1[pt1] > arr2[pt2]){
// int temp = arr1[pt1];
// arr1[pt1] = arr2[pt2];
// arr2[pt2] = temp;
// pt1++;
// Arrays.sort(arr2);
// }
// if(pt1 == arr1.length-1){
// return;
// }
// }
// }
// }
