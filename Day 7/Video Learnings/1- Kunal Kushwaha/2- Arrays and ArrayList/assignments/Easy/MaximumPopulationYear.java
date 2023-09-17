/*  You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

*/

package newAssignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear {
    public static void main(String[] args) {
        int[][] logs = { { 2008, 2026 }, { 2004, 2008 }, { 2034, 2035 }, { 1999, 2050 }, { 2049, 2050 }, { 2011, 2035 },
                { 1966, 2033 }, { 2044, 2049 } };

        // First traverse the logs and add the range in the list
        // Then traverse the list and see what are the values that are repeating in the
        // list
        // Count each values and see which value is repeating in the maximum
        // Now grab the maximum repeating values and see which is the smallest of them
        // all
        // That is your answer

        Map<Integer, Integer> countMap = new HashMap<>();

        int maximumValueInMap = 1;

        for (int i = 0; i < logs.length; i++) {
            int j = 0;
            int start = logs[i][j];
            int end = logs[i][j + 1];

            // As the year they die will not gets counted
            end = end - 1;

            for (int k = start; k <= end; k++) {
                if (countMap.containsKey(k)) {
                    int count = countMap.get(k);
                    count = count + 1;
                    countMap.put(k, count);
                } else {
                    countMap.put(k, 1);
                }
                int val = countMap.get(k);
                maximumValueInMap = Math.max(maximumValueInMap, val);
            }
        }

        // Get all the keys that has maximumValueInMap and store them in a seperate list

        ArrayList<Integer> checkList = new ArrayList<>(10);

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == maximumValueInMap) {
                checkList.add(key);
            }
        }

        // Find the minimum value in this checklist
        int minimumValInCheckList = checkList.get(0);
        for (int i = 0; i < checkList.size(); i++) {
            int val = checkList.get(i);
            minimumValInCheckList = Math.min(minimumValInCheckList, val);
        }

        System.out.println(minimumValInCheckList);
    }

}