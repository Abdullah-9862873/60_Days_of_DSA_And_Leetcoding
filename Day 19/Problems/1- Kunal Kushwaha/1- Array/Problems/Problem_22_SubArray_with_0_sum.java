import java.util.*;

public class Problem_22_SubArray_with_0_sum {
    public static void main(String[] args) {
        int[] arr = {};

        boolean ans = findSubarray(arr);
        System.out.println(ans);
    }
    public static boolean findSubarray(int[] arr){
        int prefixSum = 0;
        boolean ans = false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                return true;
            }
            prefixSum += arr[i];
            if(prefixSum == 0){
                return true;
            }
            if(map.containsKey(prefixSum)){
                return true;
            }else{
                map.put(prefixSum,1);
            }
        }

        return ans;
    }
}

