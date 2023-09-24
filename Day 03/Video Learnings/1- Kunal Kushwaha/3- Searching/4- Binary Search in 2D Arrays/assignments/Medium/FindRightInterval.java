import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindRightInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] ans = findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> intervalStarts = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            intervalStarts.put(intervals[i][0], i);
        }

        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = intervalStarts.ceilingEntry(intervals[i][1]);
            ans[i] = (entry != null) ? entry.getValue() : -1;
        }

        return ans;
    }
}
