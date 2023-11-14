// public class MedianOfTwoSortedArray{
//     public static void main(String[] args){
//         int[] nums1 = {7,12,14,15};
//         int[] nums2 = {1,2,3,4,9,11};

//         double ans = findMedian(nums1, nums2);
//         System.out.println(ans);
//     }
//     public static double findMedian(int[] nums1, int[] nums2){
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         if(n1 > n2){
//             return findMedian(nums2, nums1);
//         }
//         // Now n1 is always the smaller array
//         int low = 0;
//         int high = n1;
//         int left = (n1 + n2 + 1)/2;
//         while(low <= high){
//             int mid1 = (low + high)/2;
//             int mid2 = left - mid1;
//             int l1 = Integer.MIN_VALUE;
//             int l2 = Integer.MIN_VALUE;
//             int r1 = Integer.MAX_VALUE;
//             int r2 = Integer.MAX_VALUE;

//             int n = n1 + n2;

//             if(mid1 < n1){
//                 r1 = nums1[mid1];
//             }
//             if(mid2 < n2){
//                 r2 = nums2[mid2];
//             }
//             if(mid1-1 > 0){
//                 l1 = nums1[mid1-1];
//             }
//             if(mid2-1 > 0){
//                 l2 = nums2[mid2-1];
//             }

//             if(l1<=r2 && l2 <= r1){
//                 if(n % 2 == 0){
//                     return ((double)(Math.max(l1,l2) + Math.min(r1,r2)) / 2.0);
//                 }else{
//                     return Math.max(l1,l2);
//                 }
//             }else if(l1 > r2){
//                 high = mid1-1;
//             }else{
//                 low = mid1 + 1;
//             }
//         }
//         return 0;
        
//     }
// }
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = median(nums1, nums2);
        return ans;
    }
public static double median(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return median(nums2, nums1);
        }
        // Now n1 is always the smaller array
        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1)/2;
        int n = n1 + n2;
        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1<=r2 && l2 <= r1){
                if(n % 2 == 0){
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2)) / 2.0);
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1 + 1;
            }
        }
        return 0;
        
    }
}