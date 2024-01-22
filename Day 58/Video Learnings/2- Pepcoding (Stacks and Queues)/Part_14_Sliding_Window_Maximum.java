import java.util.*;

public class Part_14_Sliding_Window_Maximum{
    public static void main(String[] args){
        int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
        int k = 4;
        int[] nextGreater = new int[arr.length];
        findNextGreater(arr,nextGreater);
        ArrayList<Integer> ans = new ArrayList<>();
        ans = findSlidingWindowMaximum(arr, nextGreater, k);
        System.out.println(ans);
    }
    public static ArrayList<Integer> findSlidingWindowMaximum(int[] arr, int[] nextGreater, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i <= arr.length-k){
            j=i;
            int ng = nextGreater[j];
            while(ng == -1 || ng <= i+k-1){
                if(ng == -1){
                    break;
                }
                j=ng;
                ng = nextGreater[j];
            }
            ans.add(arr[j]);
            i++;
        }
        return ans;

    }
    public static void findNextGreater(int[] arr, int[] nextGreater){
        Stack<Integer> st = new Stack<>();
        nextGreater[arr.length-1] = -1;
        st.push(arr.length-1);
        int i = arr.length-2;
        while(i >= 0){
            if(st.size() > 0){
                if(arr[st.peek()] < arr[i]){
                    st.pop();
                }else if(arr[st.peek()] > arr[i]){
                    nextGreater[i] = st.peek();
                    st.push(i);
                    i--;
                }
            }else{
                nextGreater[i] = -1;
                st.push(i);
                i--;
            }
        }
    }       
}