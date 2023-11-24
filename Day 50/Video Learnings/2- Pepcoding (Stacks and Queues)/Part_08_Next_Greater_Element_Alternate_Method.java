import java.util.Arrays;
import java.util.Stack;

public class Part_08_Next_Greater_Element_Alternate_Method {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3,1,12,6,8,7};
        int[] ans = new int[arr.length];
        computeNextGreaterElements(arr, ans);
        System.out.println(Arrays.toString(ans));
    }
    public static void computeNextGreaterElements(int[] arr, int[] ans){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int i = 1;
        while(i < arr.length){
                while(st.size() > 0 && arr[st.peek()] < arr[i]){
                    ans[st.peek()] = arr[i];
                    st.pop();
                }
                st.push(i);
                i++;
        }
        while(st.size() > 0){
            ans[st.peek()] = -1;
            st.pop();
        }
    }
}
