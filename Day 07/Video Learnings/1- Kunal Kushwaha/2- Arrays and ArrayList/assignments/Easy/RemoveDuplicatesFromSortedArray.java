/* Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}

*/

package newAssignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { -3, -1, 0, 0, 0, 3, 3 };

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                count = count + 1;
                map.put(nums[i], count);
            } else {
                int count = 1;
                map.put(nums[i], count);
            }
        }

        // Sorting the map
        Map<Integer, Integer> sortedMap = new TreeMap<>(map);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0;
        }

        ArrayList<Integer> ansList = new ArrayList<>(10);

        for (Integer key : sortedMap.keySet()) {
            ansList.add(key);
        }

        for (int i = 0; i < ansList.size(); i++) {
            nums[i] = ansList.get(i);
        }

        int answer = sortedMap.size();

        System.out.println(answer);

    }
}
