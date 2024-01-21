

public class Problem_08_Find_Largest_Sum_Continguous_Subarray{
    public static void main(String[] args) {
        int[] arr = {1,2,-4,2,3};
        long sum = 0;
        long maxi = arr[0];
    
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
    
        System.out.println(maxi);
    }
}