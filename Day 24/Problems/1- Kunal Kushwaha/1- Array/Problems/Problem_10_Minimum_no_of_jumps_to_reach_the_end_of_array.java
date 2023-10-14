public class Problem_10_Minimum_no_of_jumps_to_reach_the_end_of_array {
    public static void main(String[] args) {
        int[] arr = {2,0,0,0};
        int ans = minJumps(arr);
        System.out.println(ans);
    }
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1){
            return 0;
        }
        if(arr[0] == 0){
            return -1;
        }

        int steps = arr[0];
        int maxReach = arr[0];
        int jumps = 1;
        for(int i=1; i<n; i++){
            if(i == n-1){
                return jumps;
            }

            maxReach = Integer.max(maxReach, i+arr[i]);
            steps--;
            if(steps == 0){
                jumps++;
                if(i >= maxReach){
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return jumps;
    }
}
