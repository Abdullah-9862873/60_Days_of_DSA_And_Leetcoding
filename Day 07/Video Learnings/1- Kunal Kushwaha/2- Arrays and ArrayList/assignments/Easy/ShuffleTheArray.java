
// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

// Return the array in the form [x1,y1,x2,y2,...,xn,yn].

// Example 1:

// Input: nums = [2,5,1,3,4,7], n = 3
// Output: [2,3,5,4,1,7] 
// Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

import java.util.ArrayList;
import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;

        int endStartedHere = n;
        ArrayList<Integer> ansList = new ArrayList<>(nums.length);

        int i = 0;

        while (i != endStartedHere) {
            int start = nums[i];
            int end = nums[i + n];

            ansList.add(start);
            ansList.add(end);

            i += 1;
        }

        int[] ans = new int[nums.length];
        for (int j = 0; j < ansList.size(); j++) {
            ans[j] = ansList.get(j);
        }

        System.out.println(Arrays.toString(ans));
    }
}
