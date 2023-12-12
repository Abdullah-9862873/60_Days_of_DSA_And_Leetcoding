public class Problem_23_Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr = {6,-3,-10,0,2};
        int N = arr.length;
        long ans = findAns(arr, N);
        System.out.println(ans);
    }
    public static long findAns(int[] arr,int N){
        long prefix = 1;
        long suffix = 1;
        long ans = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix = prefix*arr[i];
            suffix = suffix*arr[N-i-1];
            ans = Math.max(ans, Math.max(prefix,suffix));
        }
        return ans;
    }
}
