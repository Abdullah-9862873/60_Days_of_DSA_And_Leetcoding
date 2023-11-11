import java.util.*;
public class Video_23_Return_All_Indices {
    public static void main(String[] args) {
        int[] arr = {2,6,9,8,2,6,4};
        System.out.println(findAllIndices(arr,0,3));
    }
    public static ArrayList<Integer> findAllIndices(int[] arr, int idx, int target){
        if(idx == arr.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = findAllIndices(arr, idx+1, target);
        if(arr[idx] == target){
            ans.add(0, idx);
        }
        return ans;
    }
}
