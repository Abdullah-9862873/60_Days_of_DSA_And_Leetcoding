import java.util.*;
public class Problem_28_Array_Subset_of_another_array {
    public static void main(String[] args) {
        long a1[] = {10, 5, 2, 23, 19};
        long a2[] = {19, 5, 3};

        String ans = isSubset(a1, a2);
        System.out.println(ans);
    }
    public static String isSubset(long[] a1, long[] a2){
        HashMap<Long, Integer> map = new HashMap<>();
        // I have to put the a1 in the map 
        for(int i=0; i<a1.length; i++){
            if(map.containsKey(a1[i])){
                int val = map.get(a1[i]);
                map.remove(a1[i]);
                val += 1;
                map.put(a1[i], val);
            }else{
                map.put(a1[i], 1);
            }
        }

        // Traversing a2 and checking in the map
        for(int i=0; i<a2.length; i++){
            if(map.containsKey(a2[i])){
                int val = map.get(a2[i]);
                map.remove(a2[i]);
                val -= 1;
                if(val < 0){
                    return "No";
                }
                map.put(a2[i], val);
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
