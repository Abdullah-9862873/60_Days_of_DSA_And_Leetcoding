public class ValidPerfectSquare{
    public static void main(String[] args){
        int num = 14;
        boolean ans = isPerfectSquare(num);
        System.out.println(ans);
    }

    public static boolean isPerfectSquare(int num){
        int upper_bound = (int)Math.sqrt(num);

        int lower_bound = 1;

        int[] arr = new int[upper_bound];

        for(int i=lower_bound; i<=upper_bound; i++){
            arr[i-1] = i;
        }

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] * arr[mid] == num){
                return true;
            }else if(arr[mid] * arr[mid] > num){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}