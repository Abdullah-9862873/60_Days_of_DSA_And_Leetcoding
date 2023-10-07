import java.util.*;

public class Problem_18_Count_Pairs_with_Given_Sum {
    public static void main(String[] args) {
        int[] arr = {1,5,7,1};
        int k = 6;
        int ans = findPairs(arr, k);
        System.out.println(ans);
    }

    public static int findPairs(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<arr.length; i++){
            int b = k - arr[i];
            if(map.containsKey(b)){
                count += map.get(b);
            }
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else if(map.containsKey(arr[i])){
                int currVal = map.get(arr[i]);
                map.remove(arr[i]);
                currVal += 1;
                map.put(arr[i], currVal);
            }
        }
        return count;
    }
}
