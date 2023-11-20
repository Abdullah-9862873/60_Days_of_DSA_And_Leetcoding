import java.util.Stack;

public class Part_12_Largest_Area_Histogram {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int ans = getLargestArea(arr);
        System.out.println(ans);
    }
    public static int getLargestArea(int[] arr){
        int[] nextSmaller = new int[arr.length];
        int[] prevSmaller = new int[arr.length];

        findNextSmaller(arr,nextSmaller);
        findPrevSmaller(arr, prevSmaller);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int value = (arr[i])*(nextSmaller[i]-prevSmaller[i] + 1);
            max = Math.max(max,value);
        }

        return max;
    }
    public static void findNextSmaller(int[] arr, int[] nextSmaller){
        Stack<Integer> st = new Stack<>();
        nextSmaller[arr.length-1] = arr[arr.length-1];
        st.push(arr.length-1);
        int i = arr.length-2;
        while(i >= 0){
            if(st.size() > 0){
                if(arr[st.peek()] < arr[i]){
                    nextSmaller[i] = st.peek() - 1;
                    st.push(i);
                    i--;
                }else if(arr[st.peek()] > arr[i]){
                    st.pop();
                }
            }else if(st.size() == 0){
                nextSmaller[i] = arr[arr.length-1];
                st.push(i);
                i--;
            }
        }

    }
    public static void findPrevSmaller(int[] arr, int[] prevSmaller){
        Stack<Integer> st = new Stack<>();
        prevSmaller[0] = 0;
        st.push(0);
        int i = 1;
        while(i < arr.length){
            if(st.size() > 0){
                if(arr[st.peek()] < arr[i]){
                    prevSmaller[i] = st.peek()+1;
                    st.push(i);
                    i++;
                }else if(arr[st.peek()] > arr[i]){
                    st.pop();
                }
            }else{
                prevSmaller[i] = 0;
                st.push(i);
                i++;
            }
        }
    }
}