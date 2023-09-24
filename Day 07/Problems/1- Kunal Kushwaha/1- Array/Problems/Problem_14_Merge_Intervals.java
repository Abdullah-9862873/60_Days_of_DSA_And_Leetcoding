import java.util.*;

public class Problem_14_Merge_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {
                { 2, 6 },
                { 1, 3 },
                { 8, 10 },
                { 15, 18 },
        };
        // Sorting it with respect to the first 
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> ans = new ArrayList<>();
        int[] currentInterval = intervals[0];
        ans.add(currentInterval);

        for(int[] interval : intervals){
            // int curr_begin = currentInterval[0];
            int curr_end = currentInterval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if(curr_end > next_begin){
                // I have to merge
                currentInterval[1] = Math.max(curr_end, next_end);
            }else{
                currentInterval = interval;
                ans.add(interval);
            }
        }

        // Converting the list of arrays to array
        int[][] ansArray = new int[ans.size()][2]; 
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i); 
        }
        for(int[] aa: ansArray){
            System.out.println(Arrays.toString(aa));
        }
    }
}
