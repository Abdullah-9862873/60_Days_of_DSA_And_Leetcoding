/*
Uses following three variables  ----> (Inspired by Netherland flag containing three colors)
1) Low
2) Mid
3) High


Following are the ranges
1) 0 till low-1
2) low till mid-1
3) high+1 till n-1


Explanation:
1) From "0" till "low-1", the elements are all 0
2) From "low" till "mid-1", the elements are all 1
3) From "mid" till "high-1", the elements are all unordered (Can be 0, 1, 2)... Initially your array will be like (mid will be at first position), (high will be at last) ... Because initially all the array is unsorted
4) From "high" till "n-1", the elements are all 2

Intuition
Case 1) if arr[mid] == 0
-------------> swap(arr[low], arr[mid]) mid++
Case 2) if arr[mid] == 1
-------------> No swapping required... It is at its original postiion i-e after 0's.... mid ++
Case 3) if arr[mid] == 2
-------------> swap(arr[mid], arr[high]), high--,
 */


// ________________________________________________________________
// Used to solve questions like sort an array containing three numbers 0's, 1's and 2's
// ________________________________________________________________
// Solved Problem_5_Move_all_negative_numbers_to_beginning_and_positive_to_end

import java.util.Arrays;

public class Dutch_National_Flag_Algorithm{
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};
        dnf(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void dnf(int[] arr){
        int low, mid, high;
        low = 0;
        mid = 0;
        high = arr.length-1;

        while(mid <= high){
            if(mid <= high && arr[mid] == 0){
                swap(arr, mid, low);
                low++;
                mid++;
            }
            if(mid <= high && arr[mid] == 1){
                mid++;
            }
            if(mid <= high && arr[mid] == 2){
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