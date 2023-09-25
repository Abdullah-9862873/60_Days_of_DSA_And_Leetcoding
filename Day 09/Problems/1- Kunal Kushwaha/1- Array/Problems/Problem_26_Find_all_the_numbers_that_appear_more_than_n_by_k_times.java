import java.util.*;
public class Problem_26_Find_all_the_numbers_that_appear_more_than_n_by_k_times {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 9, 2, 9, 7};
        int k = 3;
        int n = arr.length;

        System.out.println(findAns(arr, k, n));
    }
    public static ArrayList<Integer> findAns(int[] arr, int k, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                map.remove(arr[i]);
                val+=1;
                map.put(arr[i], val);
            }else{
                map.put(arr[i],1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n/k){
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}
