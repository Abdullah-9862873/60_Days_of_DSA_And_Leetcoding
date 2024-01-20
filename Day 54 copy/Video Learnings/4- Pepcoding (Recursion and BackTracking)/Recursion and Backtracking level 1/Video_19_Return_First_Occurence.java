public class Video_19_Return_First_Occurence {
    public static void main(String[] args) {
        int[] arr = {2,3,9,8,7,6,4,12,7,3,8};
        int ans = returnFirstOccurence(arr, 0, 7);
        System.out.println(ans);
    }
    public static int returnFirstOccurence(int[] arr, int idx, int target){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == target){
            return idx;
        }else{
            int ans = returnFirstOccurence(arr, idx+1, target);
            return ans;
        }
    }
}
