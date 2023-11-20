import java.util.*;
public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {7,3,6,5,2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // Now the pivot is at its exact position
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}

/*
Time Complexity ---> Best Case ---> O(nlogn)
                     Worst Case ---> O(n*2)
1) Worst Case                     
---->Worst case is if the pivot is at the last index or first index because in that case all the elements will get sorted on one side only
---->In that case the relation would be something like
    T(n-1) + T(0) + O(n)
---->where (n-1) are the elements on one side... 0 are the elements on the other side to sort and O(n) is the time taken to put the pivot to its correct position

2) Best Case
T(N/2) + T(N/2) + O(n)


Notes---->
----> It is not stable
----> It is preffered over merge sort as it is done in in-Place rather than allocating O(n) extra space to a new array
----> Merge sort is preffered with linked list as they dont have continuous memory allocations like what we have in the arrays


----> Hybrid sorting algorithms ----> Insertion and Merge Sort

*/
