public class Video_17_Maximum_of_an_Array {
    public static void main(String[] args) {
        int[] arr = {10,40,20,30,50,5};
        int ans = findMax(arr, 0);
        System.out.println(ans);
    }
    public static int findMax(int[] arr, int idx){
        if(idx == arr.length-1){
            return arr[idx];
        }
        
        int max = findMax(arr, idx+1);
        if(arr[idx] > max){
            return arr[idx];
        }
        return max;
    }
}
