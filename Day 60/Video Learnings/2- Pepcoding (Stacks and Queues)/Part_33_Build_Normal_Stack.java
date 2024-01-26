import java.util.*;

public class Part_33_Build_Normal_Stack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the capacity of Stack: ");
        int capacity = input.nextInt();

        CustomStack st = new CustomStack(capacity);
        while (true) {
            System.out.println();
            System.out.println("Choose between the following: (1/2/3/4/5) or enter 0 to exit");
            System.out.println("1- size()");
            System.out.println("2- display()");
            System.out.println("3- push()");
            System.out.println("4- pop()");
            System.out.println("5- peek()");
            System.out.println();

            int userInput = input.nextInt();
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                int size = st.size();
                System.out.println(size);
            } else if (userInput == 2) {
                st.display();
            } else if (userInput == 3) {
                System.out.println("Enter the value to push: ");
                int val = input.nextInt();
                int output = st.push(val);
                if(output == -1){
                    break;
                }
            } else if (userInput == 4) {
                int val = st.pop();
                if(val == -1){
                    break;
                }
            } else if (userInput == 5) {
                System.out.println("______________________________________");
                System.out.println("Peek of the Stack is: " + st.peek());
                System.out.println("______________________________________");
            }
        }
        input.close();
    }

    public static class CustomStack {
        int[] data;

        public CustomStack(int capacity) {
            data = new int[capacity];
        }

        private int index = 0;

        public int size() {
            return index;
        }

        public void display() {
            String str = "";
            for (int i = index - 1; i >= 0; i--) {
                str = str + '-' + data[i];
            }
            System.out.println("______________________________________");
            System.out.println("Stack is: " + str.substring(1));
            System.out.println("______________________________________");
        }

        public int push(int val) {
            if (index < data.length) {
                data[index] = val;
                index++;
            } else if (index >= data.length) {
                System.out.println("______________________________________");
                System.out.println("Stack Overflow Error");
                System.out.println("______________________________________");
                return -1;
            }
            return 1;
        }

        public int pop() {
            if (index <= 0) {
                System.out.println("______________________________________");
                System.out.println("Stack underflow error");
                System.out.println("______________________________________");
                return -1;
            }
            int val = data[index - 1];
            index--;
            return val;
        }

        public int peek() {
            if (index <= 0 || index > data.length) {
                return -1;
            }
            return data[index - 1];
        }
    }
}
