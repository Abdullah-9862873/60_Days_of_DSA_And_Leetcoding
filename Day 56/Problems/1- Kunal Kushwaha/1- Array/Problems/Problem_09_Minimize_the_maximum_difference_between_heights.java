import java.util.Arrays;

public class Problem_09_Minimize_the_maximum_difference_between_heights {
    public static void main(String[] args){
        int[] arr = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
        int k = 3;

        Arrays.sort(arr);
        
        int max, min;
        max = arr[arr.length-1];
        min = arr[0];

        int difference = max-min;

        for(int i=1; i<arr.length; i++){
            if(arr[i]-k < 0){
                continue;
            }
            max = Math.max(arr[i-1]+k,arr[arr.length-1]-k);
            min = Math.min(arr[0]+k, arr[i]-k);
            difference = Math.min(difference, max-min);
        }
        System.out.println(difference);
    }
}
