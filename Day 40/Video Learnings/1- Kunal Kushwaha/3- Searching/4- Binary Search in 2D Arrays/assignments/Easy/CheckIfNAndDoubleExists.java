
import java.util.HashSet;

public class CheckIfNAndDoubleExists {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 5, 3 };
        boolean ans = false;
        
        HashSet<Integer> set1 = new HashSet<>();
        int zeroCount = 0;
        for(int i=0; i<arr.length; i++){
            set1.add(arr[i]);

            if(arr[i] == 0){
                zeroCount++;
            }
            if(zeroCount == 2){
                ans = true;
                System.out.println(ans);
                break;
            }
        }
        if(!ans){
            for(int i=0; i<arr.length; i++){
                if(set1.contains(arr[i]*2)){
                    if(arr[i]*2 != arr[i]){
                        ans = true;
                        System.out.println(ans);
                        break;
                    }
                }
            }
        }else{
            System.out.println(ans);
        }

    }
}