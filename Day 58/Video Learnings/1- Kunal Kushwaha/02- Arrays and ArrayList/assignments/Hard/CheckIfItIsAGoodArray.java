public class CheckIfItIsAGoodArray{
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        int ans = find_GCD_of_Array(nums);
        if(ans == 1){
            return true;
        }else{
            return false;
        }
    }

    // Find GCD of array of numbers
    public static int find_GCD_of_Array(int[] arr){
        int ans = 1;
        for(int i=0; i<arr.length-1; i++){
            if(i == 0){
                ans = findgcd(arr[i], arr[i+1]);
            }else{
                ans = findgcd(ans, arr[i+1]);
            }
        }
        return ans;
    }

    // Find GCD of two numbers
    // Remember a must be less than b
    public static int findgcd(int a, int b){
        if(b == 0){
            return a;
        }

        return findgcd(b, a%b);
    }
}