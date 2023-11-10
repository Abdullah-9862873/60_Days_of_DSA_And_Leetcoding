//_____________________Start________________________________
// import java.util.HashMap;

// public class Extra_Problem_3_Longest_Subarray_with_Sum_k {
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
//         int k = 3;

//         int prefixSum = 0;
//         int longestSum = 0;

//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < arr.length; i++) {
//             prefixSum += arr[i];
            
//             // If prefixSum is equal to k, the entire subarray from the beginning to i has sum k.
//             if (prefixSum == k) {
//                 longestSum = i + 1; // Update longestSum
//             }
            
//             // If prefixSum - k is in the map, it means there's a subarray with sum k in between.
//             if (map.containsKey(prefixSum - k)) {
//                 longestSum = Math.max(longestSum, i - map.get(prefixSum - k));
//             }
            
//             // Put the current prefixSum into the map if it's not already present.
//             if (!map.containsKey(prefixSum)) {
//                 map.put(prefixSum, i);
//             }
//         }
        
//         System.out.println("Longest subarray with sum " + k + " has length: " + longestSum);
//     }
// }

//_____________________End________________________________

// This approach is best if the input contains both positives and the negatives...

// But if the input only contains the positives and the zeros then there is an optimal way using two pointer approach

//_____________________Start________________________________
public class Extra_Problem_3_Longest_Subarray_with_Sum_k {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int k = 6;

        int prefixSum = 0;
        int longestSum = 0;

        int pt1 = 0;
        int pt2 = 0;
        while(pt2 <= pt1){
            prefixSum += arr[pt1];
            if(prefixSum == k){
                longestSum = Integer.max(longestSum, pt2-pt1+1);
                pt1++;
            }else if(prefixSum < k){
                pt1++;
            }else{
                pt2++;
            }
        }
        
        System.out.println("Longest subarray with sum " + k + " has length: " + longestSum);
    }
}
//_____________________End________________________________