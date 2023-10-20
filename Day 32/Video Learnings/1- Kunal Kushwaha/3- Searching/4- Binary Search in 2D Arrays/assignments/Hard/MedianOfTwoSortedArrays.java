import java.util.*;

public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        float ans = findMedian(nums1, nums2);
        System.out.println(ans);
    }
    public static float findMedian(int[] nums1, int[] nums2){
        float ans = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
            list.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        if(list.size() == 1){
            return list.get(0);
        }
        else if(list.size() % 2 == 0){
            int mid1Index = (list.size()-1)/2;
            int mid2Index = mid1Index+1;
            ans = (float)(list.get(mid1Index) + list.get(mid2Index))/2;
            return ans;
        }else{
            int midIndex = (list.size()-1)/2;
            ans = list.get(midIndex);
            return ans;
        }
    }
}