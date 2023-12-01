import java.util.*;

public class Part_07_Next_Greater_Element_to_the_right {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,1,12,6,8,7};
        // Answer expected = [5,9,12,12,12,-1,8,-1,-1]

        int[] ans = new int[arr.length];
        computeAns(arr,ans);
        System.out.println(Arrays.toString(ans));
    }
    public static void computeAns(int[] arr, int[] ans){
        Stack<Integer> st = new Stack<>();
        int i = arr.length-1;
        while(i >= 0){
            if(st.empty()){
                ans[i] = -1;
                st.push(arr[i]);
                i--;
            }else{
                if(st.peek() > arr[i]){
                    ans[i] = st.peek();
                    st.push(arr[i]);
                    i--;
                }else if(st.peek() < arr[i]){
                    st.pop();
                }
            }
        }
    }
}
