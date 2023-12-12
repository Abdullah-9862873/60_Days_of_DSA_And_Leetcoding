import java.util.*;

public class Part_47_Queue_to_Stack_Adapter{
    public static void main(String[] args) {
        QueueToStackAdapter qsa = new QueueToStackAdapter();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Choose between the following: (1/2/3/4/5) or enter 0 to exit");
            System.out.println("1- size()");
            System.out.println("2- display()");
            System.out.println("3- add()");
            System.out.println("4- pop()");
            System.out.println("5- peek()");
            System.out.println();

            int userInput = input.nextInt();
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                int size = qsa.size();
                System.out.println("_____________________________");
                System.out.println("Size of the Stack is: " + size);
                System.out.println("_____________________________");
            } else if (userInput == 2) {
                qsa.display();
            } else if (userInput == 3) {
                System.out.println("Enter the value to add: ");
                int val = input.nextInt();
                qsa.push(val);
            } else if (userInput == 4) {
                int val = qsa.pop();
                if (val == -1) {
                    break;
                }
                System.out.println("Removed element: " + val);
            } else if (userInput == 5) {
                int val = qsa.peek();
                if (val == -1) {
                    break;
                }
                System.out.println("Peek of the Stack is: " + val);
            }
        }
        input.close();
    }
    public static class QueueToStackAdapter{
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter(){
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        public int size(){
            return mainQ.size();
        }
        public void display(){
            if(mainQ.size() == 0){
                System.out.println("____________________________");
                System.out.println("Stack Underflow Error");
                System.out.println("____________________________");
                return;
            }
            String str = "";
            while(!mainQ.isEmpty()){
                int removedVal = mainQ.remove();
                helperQ.add(removedVal);
                str = str + "-" + String.valueOf(removedVal);
            }
            while(!helperQ.isEmpty()){
                mainQ.add(helperQ.remove());
            }
            System.out.println("____________________________");
            System.out.println("Display is: " + str.substring(1));
            System.out.println("____________________________");
        }
        public void push(int val){
            if(mainQ.size() == 0){
                mainQ.add(val);
                return;
            }
            while(!mainQ.isEmpty()){
                helperQ.add(mainQ.remove());
            }
            mainQ.add(val);
            while(!helperQ.isEmpty()){
                mainQ.add(helperQ.remove());
            }
        }
        public int pop(){
            if(mainQ.size() == 0){
                System.out.println("____________________________");
                System.out.println("Stack Underflow Error");
                System.out.println("____________________________");
                return -1;
            }
            return mainQ.remove();
        }
        public int peek(){
            if(mainQ.size() == 0){
                System.out.println("____________________________");
                System.out.println("Stack Underflow Error");
                System.out.println("____________________________");
                return -1;
            }
            return mainQ.peek();
        }
    }
}