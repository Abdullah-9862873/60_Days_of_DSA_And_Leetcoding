
//_______________________________________________________________
// Using Binary Search 
import java.util.*;

public class Video_43_Longest_Increasing_Subsequence_Using_Binary_Search {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 8, 4, 5, 6, -1, 9 };
        int ans = getLongestIncreasingSubsequence(arr);
        System.out.println(ans);
    }

    public static int getLongestIncreasingSubsequence(int[] arr) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arraylist.size() == 0) {
                arraylist.add(arr[i]);
            } else {
                if (arraylist.get(arraylist.size() - 1) < arr[i]) {
                    arraylist.add(arr[i]);
                } else {
                    int lowerBound = findLowerBound(arraylist, arr[i]);
                    arraylist.set(lowerBound, arr[i]);
                }
            }
        }
        return arraylist.size();
    }

    public static int findLowerBound(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr.get(mid)) {
                return mid;
            } else if (target > arr.get(mid)) {
                start = mid + 1;
            } else if (target < arr.get(mid)) {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
