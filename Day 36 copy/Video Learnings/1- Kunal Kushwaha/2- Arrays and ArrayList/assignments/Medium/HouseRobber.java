import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int[] maxTillNow = new int[nums.length];

        
        maxTillNow[0] = nums[0];
        maxTillNow[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            maxTillNow[i] = findMaxTillNow(nums, i-2, maxTillNow) + nums[i];
        }

        System.out.println(Arrays.toString(maxTillNow));
        
        int ans = maxTillNow[0];
        for(int i=1; i<maxTillNow.length; i++){
            ans = Math.max(ans, maxTillNow[i]);
        }
        System.out.println(ans);
    }
    public static int findMaxTillNow(int[] nums, int index, int[] maxTillNow){
        if(index < 0){
            return Math.max(nums[0], nums[index+2]);
        }
        int max = 0;
        for(int i=0; i<=index; i++){
            max = Math.max(max, maxTillNow[i]);
        }
        return max;
    }
}
