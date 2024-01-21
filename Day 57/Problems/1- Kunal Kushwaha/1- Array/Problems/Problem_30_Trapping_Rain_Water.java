public class Problem_30_Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        long ans = waterTrapped(arr);
        System.out.println(ans);
    }
    public static long waterTrapped(int[] arr){
        int[] lmax = new int[arr.length];
        int[] rmax = new int[arr.length];

        // Finding what is the left greatest element at every index
        lmax[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        rmax[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }

        long water = 0;
        // Ignoring the boundaries
        for(int i=1; i<arr.length-1; i++){
            water += Math.min(lmax[i],rmax[i])-arr[i];
        }
        return water;
    }
}
