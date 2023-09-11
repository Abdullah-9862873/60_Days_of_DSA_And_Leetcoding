import java.util.Arrays;

public class RemoveElement{
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int val = 3;

        int p1 = 0;
        int p2 = arr.length-1;

        while(p1 != p2){
            if(arr[p2] == val){
                p2--;
            }else if(arr[p1] != val){
                p1++;
            }else{
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
            }
        }

        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val){
                break;
            }
            ans += 1;
        }
        System.out.println(ans);
    }
}