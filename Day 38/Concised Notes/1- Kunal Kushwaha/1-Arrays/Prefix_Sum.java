/*
The idea is to find prefix sum till a particular portion of an array... And then just observe the reverse... 

Observation is take that prefix sum and subtract the K value from it... So lets say uptil a particular point the sum was "x" (prefixSum)... The K value given as something like "s"... Then you have to observe the "x-k" of the array...
*/

// Question solved ----> Extra_Problem_3_Longest_Subarray_with_Sum_k

// Question Solved 2 ----> Extra_Problem_2_Count_Subarrays_sum_equals_k

import java.util.HashMap;

public class Prefix_Sum {
    public static void main(String[] args) {
        // Longest Subarray Sum
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;

        int prefixSum = 0;
        int longestSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // If prefixSum is equal to k, the entire subarray from the beginning to i has sum k.
            if (prefixSum == k) {
                longestSum = i + 1; // Update longestSum
            }
            
            // If prefixSum - k is in the map, it means there's a subarray with sum k in between.
            if (map.containsKey(prefixSum - k)) {
                longestSum = Math.max(longestSum, i - map.get(prefixSum - k));
            }
            
            // Put the current prefixSum into the map if it's not already present.
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        System.out.println("Longest subarray with sum " + k + " has length: " + longestSum);
    }
}

/*
Tip ----> When to use?
Description ----> If you are given some sort of k value like sum, product, division, subtract then you can consider this
 */
