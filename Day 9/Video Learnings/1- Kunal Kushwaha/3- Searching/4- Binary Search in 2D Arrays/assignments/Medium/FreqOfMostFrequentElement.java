import java.util.Arrays;

public class FreqOfMostFrequentElement {
    public static void main(String[] args) {
        int[] nums = {3,9,6};
        int k = 2;
        int ans = findFreq(nums, k);
        System.out.println(ans);
    }
    public static int findFreq(int[] arr, int k){
        int ans = 1;
        Arrays.sort(arr);
        int start = 0;
        int end = 0;

        long sum = 0;

        while(end < arr.length){
            sum += arr[end];
            end++;
            if(sum+k < ((long)arr[end-1]*(end-start))){
                sum -= arr[start];
                start++;
                
            }else{
                ans = Math.max(ans, (end-start));
            }
        }
        return ans;
    }
}
