import java.util.HashSet;

public class Problem_25_Find_longest_Consecutive_SubSequence{
    public static void main(String[] args) {
        int[] arr = {34, 2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6};
        int ans = findLongestSubsequenceCount(arr);
        System.out.println(ans);
    }
    public static int findLongestSubsequenceCount(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            if(!set.contains(num-1)){
                int curr_val = num;
                int count = 0;
                while(set.contains(curr_val)){
                    curr_val++;
                    count++;
                }
                maxi = Math.max(maxi, count);
            }
        }
        return maxi;
    }
}