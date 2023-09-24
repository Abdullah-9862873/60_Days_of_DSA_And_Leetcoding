import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrayII {
    public static void main(String[] args) {
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5,9};

        List<Integer> arr = new ArrayList<>();
        for(int i=0; i< nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    arr.add(nums1[i]);
                    nums2[j] = -1; 
                    break;
                }
            }
        }

        int[] arr1 = new int[arr.size()];

        for(int i=0; i<arr1.length; i++){
            arr1[i] = arr.get(i);
        }
        System.out.println(Arrays.toString(arr1));
    }
}
