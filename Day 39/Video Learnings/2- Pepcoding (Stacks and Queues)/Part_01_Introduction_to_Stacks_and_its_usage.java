import java.util.Stack;

public class Part_01_Introduction_to_Stacks_and_its_usage {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println("______________________________");
        System.out.println("Peek of stack is: " + st.peek());
        System.out.println("Size of stack is: " + st.size());
        System.out.println("______________________________");
        st.pop();
        System.out.println("_____________Popping_________________");
        System.out.println("Peek of stack is: " + st.peek());
        System.out.println("Size of stack is: " + st.size());
        System.out.println("______________________________");
        st.pop();
        System.out.println("_____________Popping_________________");
        System.out.println("Peek of stack is: " + st.peek());
        System.out.println("Size of stack is: " + st.size());
        System.out.println("______________________________");
        st.pop();
        System.out.println("_____________Popping_________________");
        System.out.println("Peek of stack is: " + st.peek());
        System.out.println("Size of stack is: " + st.size());
        System.out.println("______________________________");
        System.out.println("_____________Popping_________________");
        st.pop();
        System.out.println("Size of Stack is: " + st.size());
    }
}