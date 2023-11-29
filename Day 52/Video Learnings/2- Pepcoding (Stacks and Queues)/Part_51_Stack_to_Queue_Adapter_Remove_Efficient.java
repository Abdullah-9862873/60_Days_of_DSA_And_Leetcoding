import java.util.*;

public class Part_51_Stack_to_Queue_Adapter_Remove_Efficient {
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
    public static class StackToQueueAdapter{
        Stack<Integer> main = new Stack<>();
        Stack<Integer> helper = new Stack<>();

        public void display(){
            if(main.size() == 0){
                System.out.println("________________________");
                System.out.println("Queue is Empty");
                System.out.println("________________________");
                return;
            }
            String str = "";
            while(!main.isEmpty()){
                int val = main.pop();
                str = str + "-" + val;
                helper.add(val);
            }
            while(!helper.isEmpty()){
                main.push(helper.pop());
            }
            System.out.println("_______________________________");
            System.out.println("Display is: " + str.substring(1));
            System.out.println("_______________________________");
        }
        public int size(){
            return main.size();
        }
        public void add(int val){
            if(main.size() == 0){
                main.push(val);
                return;
            }
            while(!main.isEmpty()){
                helper.push(main.pop());
            }
            main.push(val);
            while(!helper.isEmpty()){
                main.push(helper.pop());
            }
        }
        public int remove(){
            if(main.size() == -1){
                return -1;
            }
            return main.pop();
        }
        public int peek(){
            if(main.size() == 0){
                return -1;
            }
            return main.peek();
        }
    }
}
