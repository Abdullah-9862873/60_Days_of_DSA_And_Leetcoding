import java.util.ArrayList;
import java.util.Arrays;

// Given two arrays of integers nums and index. Your task is to create target array under the following rules:

// Initially target array is empty.
// From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
// Repeat the previous step until there are no elements to read in nums and index.
// Return the target array.

// It is guaranteed that the insertion operations will be valid.

// Example 1:

// Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
// Output: [0,4,1,3,2]
// Explanation:
// nums       index     target
// 0            0        [0]
// 1            1        [0,1]
// 2            2        [0,1,2]
// 3            2        [0,1,3,2]
// 4            1        [0,4,1,3,2]

public class CreateTargetArrayInGivenOrder {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[] index = { 0, 1, 2, 2, 1 };

        ArrayList<Integer> ansList = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            // I have got the value to enter in the target
            int finalIndex = index[i];
            ansList.add(finalIndex, val);
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ansList.get(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
