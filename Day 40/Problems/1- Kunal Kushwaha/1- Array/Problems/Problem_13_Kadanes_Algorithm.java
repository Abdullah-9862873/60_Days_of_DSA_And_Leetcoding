public class Problem_13_Kadanes_Algorithm{
    public static void main(String[] args){
        int[] arr = {1,2,3,-2,5};
        long ans = maxSubarraySum(arr);
        System.out.println(ans);
    }
    public static long maxSubarraySum(int[] arr){
        long sum = 0;
        long maxSum = arr[0];
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);

            if(sum <0){
                sum = 0;
            }
        }
        return maxSum;
    }
}