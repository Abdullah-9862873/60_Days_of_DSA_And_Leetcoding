public class Video_21_Last_Occurence {
    public static void main(String[] args) {
        int[] arr = {2,3,6,9,8,3,2,6,4};
        int ans = findLastOccurence(arr, 0, 3);
        System.out.println(ans);
    }
    public static int findLastOccurence(int[] arr, int idx, int target){
        if(idx == arr.length){
            return -1;
        }
        
        int ans = findLastOccurence(arr, idx+1, target);
        if(ans != -1){
            return ans;
        }else if(arr[idx] == target){
            ans = idx;
        }
        return ans;
    }
}
