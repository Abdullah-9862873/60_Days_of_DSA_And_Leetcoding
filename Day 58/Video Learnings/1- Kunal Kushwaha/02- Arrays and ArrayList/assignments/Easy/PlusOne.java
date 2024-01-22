/* You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

*/

package newAssignments;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        int k = 1;

        // Converting array to list
        ArrayList<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < digits.length; i++) {
            list.add(digits[i]);
        }

        int newKVal = k;

        ArrayList<Integer> ansList = new ArrayList<>(10);

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

        // Converting the list to array
        int[] finalAns = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            finalAns[i] = ansList.get(i);
        }

        System.out.println(Arrays.toString(finalAns));

    }
}
