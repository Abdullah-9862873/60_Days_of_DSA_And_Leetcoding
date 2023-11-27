import java.util.Stack;

public class Part_03_Duplicate_Brackets {
    public static void main(String[] args) {
        // String input = "((a+b) + (c+d))";
        String input = "(a+b) + ((c+d))";
        boolean ans = checkDuplicacy(input);
        System.out.println(ans);
    }

    public static boolean checkDuplicacy(String input) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) != ')') {
                st.push(input.charAt(i));
                i++;
            } else if (input.charAt(i) == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.size() > 0 && st.peek() != '(') {
                        st.pop();
                    }
                    if (st.size() > 0) {
                        st.pop();
                    }
                    i++;
                }
            }
        }
        return false;
    }
}
