
// Given an array nums of integers, return how many of them contain an even number of digits.

// Example 1:

// Input: nums = [12,345,2,6,7896]
// Output: 2
// Explanation: 
// 12 contains 2 digits (even number of digits). 
// 345 contains 3 digits (odd number of digits). 
// 2 contains 1 digit (odd number of digits). 
// 6 contains 1 digit (odd number of digits). 
// 7896 contains 4 digits (even number of digits). 
// Therefore only 12 and 7896 contain an even number of digits.

public class FindEvenNumberOfDigits {
    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };

        int totalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            StringBuilder str = new StringBuilder();
            str.append(nums[i]);
            int count = -1;
            for (int j = 0; j < str.length(); j++) {
                count = 0;
                count += j + 1;
            }
            if (count % 2 == 0) {
                totalCount += 1;
            }
        }

        System.out.println(totalCount);
    }
}
