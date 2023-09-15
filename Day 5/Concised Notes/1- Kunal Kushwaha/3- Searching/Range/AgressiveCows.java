/*
You are given an array of length ‘N,’ where each element denotes the position of a stall. These ‘N’ stalls are located along a straight line at positions x1, x2, x3…, xn. The integer ‘K’ represents the number of cows that are aggressive. You need to assign the cows to the stalls such that they don’t hurt each other. This can be done by maximizing the minimum distance between them. What is the largest minimum distance?

Example
Input
N = 5
K = 3
X  = [ 1, 3, 5, 6, 10]

Where ‘N’ is the number of stalls, ‘K’ represents the number of aggressive cows and ‘X’ is the positions array.

Output
4

*/

/*
-----> Tip: Whenever there is a question like find max of the min or find min of the max... Use Binary Search
 */

import java.util.*;

public class AgressiveCows {
    public static void main(String[] args) {
        int[] stallPos = {0,3,4,7,10,9};
        int totalCows = 4;
        int ans = findMinDistance(stallPos, totalCows);
        System.out.println(ans);
    }
    public static int findMinDistance(int[] arr, int totalCows){
        int ans = -1;
        Arrays.sort(arr);       
        int min = findMin(arr);
        int max = findMax(arr);
        int start = min;
        int end = max;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(canWePlace(arr,mid,totalCows)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }
    public static boolean canWePlace(int[] arr, int mid, int totalCows){
        int cowsPlaced = 1;
        int lastCowPlacedAtPosition = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] - arr[lastCowPlacedAtPosition] >= mid){
                lastCowPlacedAtPosition = i;
                cowsPlaced++;
            }else{
                continue;
            }
        }
        if(cowsPlaced >= totalCows){
            return true;
        }
        return false;
    }
    public static int findMin(int[] arr){
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            minimum = Math.min(minimum, arr[i]);
        }
        return minimum;
    }
    public static int findMax(int[] arr){
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            maximum = Math.max(maximum, arr[i]);
        }
        return maximum;
    }
}
