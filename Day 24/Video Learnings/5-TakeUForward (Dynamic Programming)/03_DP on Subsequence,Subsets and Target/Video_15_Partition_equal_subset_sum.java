/*
Problem Statement
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.

For example, let's say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

Constraints:
Time Limit: 1 sec

Sample Input 1:
2
6
5
311221
5 6 5 11 6

Sample Output 1:
true
false

*/

/*
Thinking---->
The question is stating to partition the array into exactly two subsets and then it is requiring from us that the sum must be equal... So that means if the total Sum of the array is "S" then we have to find "S/2" in the array because then only the remaining S/2 will be equal to it and the answer will be true.... 

So can I not say this that this question is exactly same aas the previous one in which we have to find a target in the subset sums of the array... 
 */

public class Video_15_Partition_equal_subset_sum {
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum += arr[i];
        }
        int target = totalSum/2;
        boolean ans = isSubsetSumEqualsK(arr, 0, target);
        System.out.println(ans);
    }
    public static boolean isSubsetSumEqualsK(int[] arr, int index, int k) {
        int[] front = new int[k + 1];
        int[] curr = new int[k + 1];

        if (arr[0] <= k) {
            front[0] = 1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int target = 1; target <= k; target++) {
                boolean ans1 = false;
                if (arr[i] <= target) {
                    ans1 = (front[target - arr[i]] == 1);
                }
                boolean ans2 = front[target] == 1;
                curr[target] = (ans1 || ans2) ? 1 : 0;
            }
            front = curr;
        }
        return curr[k] == 1;
    }
}
