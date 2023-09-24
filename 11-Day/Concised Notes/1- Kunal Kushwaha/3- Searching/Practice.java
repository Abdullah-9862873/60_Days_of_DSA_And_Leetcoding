public class Practice {
    public static void main(String[] args) {
        int x = 16;
        boolean ans = false;
        ans = findAns(x);
        System.out.println(ans);
    }
    public static boolean findAns(int x){
        long start = 0L;
        long end = Integer.MAX_VALUE;

        while(start <= end){
            long mid = start + (end - start)/2;
            if(mid * mid == x){
                return true;
            }
            else if(mid * mid < x){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
