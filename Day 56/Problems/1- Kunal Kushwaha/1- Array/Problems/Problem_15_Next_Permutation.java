import java.util.*;

public class Problem_15_Next_Permutation {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 1};
        System.out.println(Arrays.toString(findNextPermutation(arr)));
    }

    public static int[] findNextPermutation(int[] arr) {
        // Step 1 find the rightmost number that has larger number to its right
        int n = arr.length;
        int A = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i + 1] > arr[i]) {
                A = i;
                break;
            }
        }       // O(n)
        // A ---> index ---> That has larger number to its rightmost
        if (A == -1) {
            // Its the last permutation
            // Reverse it
            reverse(arr, 0, n-1);
            return arr;
        }

        // Step 2
        int min = Integer.MAX_VALUE;
        for (int i = A + 1; i < n; i++) {
            if (arr[i] > arr[A]) {
                if (min == Integer.MAX_VALUE) {
                    min = i;
                } else if (arr[i] < arr[min]) {
                    min = i;
                }else if(arr[min] == arr[i]){
                    if(min < i){
                        min = i;
                    }
                }
            }
        }

        // Step 3--- > Swap A and B
        swap(arr, A, min);

        // Step 4 ---> Reverse the order to the right of A
        arr = reverse(arr, A+1, n-1);

        return arr;
    }
    public static int[] reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
