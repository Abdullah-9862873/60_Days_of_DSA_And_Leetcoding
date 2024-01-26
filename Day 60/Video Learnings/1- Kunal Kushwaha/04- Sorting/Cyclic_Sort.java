// The idea is to find if the element is at the correct index or not... To check that we do something like if there are numbers [3,2,1] then the element 3 must be at the index 2 in order to be sorted... i-e the element 3 must be at index 3-1
import java.util.*;

public class Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,4,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void cyclicSort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }
    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

/*
 * When there is range given like [1 to n] or there is a requirement to sort in O(n) time complexity and constant space complexity like O(1) then use Cyclic sort
 * Questions like "Find the missing number" "Numbers are given from 1 to N find the duplicate number" ----> Apply Cyclic Sort
 * When the range is given from 1 to N then one thing to notice is -------->
 * Index = value - 1
 * 
 * In the worst case lets say in (3,5,2,1,4) ------> First it will make (n-1)
 * comparisons to make it sorted
 * -------------> After that for the last time it will check for every number
 * whether it is at the right position so it will make (n) comparisons
 * -------------> Total = (n-1) + n
 * -------------> 2n - 1
 * -------------> O(n)
 */