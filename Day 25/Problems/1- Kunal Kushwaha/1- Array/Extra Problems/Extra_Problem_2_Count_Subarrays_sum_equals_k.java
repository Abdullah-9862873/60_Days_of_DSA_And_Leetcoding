// Concept used is prefix sum

import java.util.HashMap;

public class Extra_Problem_2_Count_Subarrays_sum_equals_k{
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        map.put(0, 1);
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            int val = prefixSum - k;
            if(map.containsKey(val)){
                count += map.get(val);
                if(map.containsKey(prefixSum)){
                    int itsValue = map.get(prefixSum);
                    map.remove(prefixSum);
                    map.put(prefixSum, itsValue+1);
                }else{
                    map.put(prefixSum, 1);
                }
            }else{
                map.put(prefixSum, 1);
            }
        }
        System.out.println(count);
    }
}