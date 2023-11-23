import java.util.*;

public class Part_53_Stack_to_Queue_Adapter_Add_Efficient {
    public static void main(String[] args) {
        StackToQueueAdapter st = new StackToQueueAdapter();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Choose between the following: (1/2/3/4/5) or enter 0 to exit");
            System.out.println("1- size()");
            System.out.println("2- display()");
            System.out.println("3- add()");
            System.out.println("4- remove()");
            System.out.println("5- peek()");
            System.out.println();

            int userInput = input.nextInt();
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                int size = st.size();
                System.out.println("_____________________________");
                System.out.println("Size of the Queue is: " + size);
                System.out.println("_____________________________");
            } else if (userInput == 2) {
                st.display();
            } else if (userInput == 3) {
                System.out.println("Enter the value to add: ");
                int val = input.nextInt();
                st.add(val);
            } else if (userInput == 4) {
                int val = st.remove();
                if (val == -1) {
                    break;
                }
                System.out.println("Removed element: " + val);
            } else if (userInput == 5) {
                int val = st.peek();
                if (val == -1) {
                    break;
                }
                System.out.println("Peek of the Stack is: " + val);
            }
        }
        input.close();
    }

    public static class StackToQueueAdapter {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        public void display() {
            if (main.size() == 0) {
                System.out.println("________________________");
                System.out.println("Queue is Empty");
                System.out.println("________________________");
                return;
            }
            String str = "";
            int[] arr = new int[main.size()];
            int j = main.size() - 1;
            while (!main.isEmpty()) {
                arr[j] = main.pop();
                j--;
            }
            for (int i = 0; i < arr.length; i++) {
                str = str + "-" + arr[i];
                main.push(arr[i]);
            }
            System.out.println("________________________");
            System.out.println("Display is: " + str.substring(1));
            System.out.println("________________________");
        }

        public int size() {
            return main.size();
        }

        public void add(int val) {
            main.push(val);
        }

        public int remove() {
            if (main.size() == 0) {
                System.out.println("_____________________________");
                System.out.println("NoSuchElementException");
                System.out.println("_____________________________");
                return -1;
            }
            while (main.size() != 1) {
                helper.push(main.pop());
            }
            int removedVal = main.pop();
            while (!helper.isEmpty()) {
                main.push(helper.pop());
            }
            return removedVal;
        }

        public int peek() {
            if (main.size() == 0) {
                System.out.println("_____________________________");
                System.out.println("NoSuchElementException");
                System.out.println("_____________________________");
                return -1;
            }
            while (main.size() != 1) {
                helper.push(main.pop());
            }
            int peekVal = main.peek();
            while (!helper.isEmpty()) {
                main.push(helper.pop());
            }
            return peekVal;
        }
    }
}
