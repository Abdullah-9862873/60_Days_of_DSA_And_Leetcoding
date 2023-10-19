import java.util.ArrayList;

// The array-form of an integer num is an array representing its digits in left to right order.

// For example, for num = 1321, the array form is [1,3,2,1].
// Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

// Example 1:

// Input: num = [1,2,0,0], k = 34
// Output: [1,2,3,4]
// Explanation: 1200 + 34 = 1234

// Constraints:

// 1 <= num.length <= 104
// 0 <= num[i] <= 9
// num does not contain any leading zeros except for the zero itself.
// 1 <= k <= 104

/*
 * Constraints are showing that the value can exceed 10^4 which means even long cannot store the answer properly so we'll use alternative approach
 */

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        int[] num = { 9, 9 };
        int k = 1;

        // converting array to list
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < num.length; i++) {
            list.add(i, num[i]);
        }

        ArrayList<Integer> ansList = new ArrayList<>(10);

        int newKVal = k;

        while (list.size() != 0 || newKVal != 0) {
            int lastVal = list.size() == 0 ? 0 : list.get(list.size() - 1);
            lastVal = lastVal + newKVal;
            int rem = lastVal % 10;
            ansList.add(0, rem);
            newKVal = lastVal / 10;

            if (list.size() != 0) {
                list.remove(list.size() - 1);
            }
        }

        System.out.println(ansList);

    }
}