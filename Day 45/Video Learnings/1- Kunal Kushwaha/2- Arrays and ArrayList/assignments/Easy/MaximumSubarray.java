package newAssignments;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -1 };

        int currSum = 0;
        int maxSum = -999999;
        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println(maxSum);
    }
}