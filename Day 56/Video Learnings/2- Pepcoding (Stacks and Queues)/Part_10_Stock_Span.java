import java.util.*;

public class Part_10_Stock_Span {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] ans = new int[arr.length];
        computeStockSpans(arr, ans);
        System.out.println(Arrays.toString(ans));
    }

    public static void computeStockSpans(int[] arr, int[] ans) {
        Stack<Integer> st = new Stack<>();
        ans[0] = 1;
        st.push(0);
        int i = 1;
        while (i < arr.length) {
            if (st.size() > 0) {
                if (arr[st.peek()] < arr[i]) {
                    while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                        st.pop();
                    }
                } else if (arr[st.peek()] > arr[i]) {
                    ans[i] = i - st.peek();
                    st.push(i);
                    i++;
                }
            } else if (st.size() == 0) {
                ans[i] = i + 1;
                st.push(i);
                i++;
            }
        }
    }
}
