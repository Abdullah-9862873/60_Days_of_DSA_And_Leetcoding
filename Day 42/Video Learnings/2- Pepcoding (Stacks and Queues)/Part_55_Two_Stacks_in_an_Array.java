import java.util.Scanner;

public class Part_55_Two_Stacks_in_an_Array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the capacity of both stacks collectively: ");
        int capacity = input.nextInt();
        TwoStackArray tsa = new TwoStackArray(capacity);
        while (true) {
            printInstructions();

            int userInput = input.nextInt();
            if (userInput == 0) {
                break;
            } else if (userInput == 1) {
                System.out.println("___________________________");
                System.out.println("Size of Stack1 is: " + tsa.size1());
                System.out.println("___________________________");
            } else if (userInput == 2) {
                System.out.println("___________________________");
                System.out.println("Size of Stack2 is: " + tsa.size2());
                System.out.println("___________________________");
            } else if (userInput == 3) {
                int output = tsa.display1();
                if (output == -1) {
                    break;
                }
            } else if (userInput == 4) {
                int output = tsa.display2();
                if (output == -1) {
                    break;
                }
            } else if (userInput == 5) {
                System.out.println("Enter value to push in stack1: ");
                int in = input.nextInt();
                int output = tsa.push1(in);
                if (output == -1) {
                    break;
                }
            } else if (userInput == 6) {
                System.out.println("Enter value to push in stack2: ");
                int in = input.nextInt();
                int output = tsa.push2(in);
                if (output == -1) {
                    break;
                }
            } else if (userInput == 7) {
                int output = tsa.pop1();
                if(output == -1){
                    break;
                }
                System.out.println("______________________________");
                System.out.println("Popped value from Stack1 is: " + output);
                System.out.println("______________________________");
            } else if (userInput == 8) {
                int output = tsa.pop2();
                if(output == -1){
                    break;
                }
                System.out.println("______________________________");
                System.out.println("Popped value from Stack2 is: " + output);
                System.out.println("______________________________");
            } else if (userInput == 9) {
                int output = tsa.peek1();
                if(output == -1){
                    break;
                }
                System.out.println("____________________________");
                System.out.println("Peek of Stack1 is: " + output);
                System.out.println("____________________________");
            } else if (userInput == 10) {
                int output = tsa.peek2();
                if(output == -1){
                    break;
                }
                System.out.println("____________________________");
                System.out.println("Peek of Stack2 is: " + output);
                System.out.println("____________________________");
            }

        }
        input.close();
    }

    public static void printInstructions(){
            System.out.println();
            System.out.println("Choose one of the following: (1/2/3/4/5/6/7/8/9/10) or Enter 0 to Exit");
            System.out.println("1- size1()");
            System.out.println("2- size2()");
            System.out.println("3- display1()");
            System.out.println("4- display2()");
            System.out.println("5- push1()");
            System.out.println("6- push2()");
            System.out.println("7- pop1()");
            System.out.println("8- pop2()");
            System.out.println("9- peek1()");
            System.out.println("10- peek2()");
            System.out.println();
    }

    public static class TwoStackArray {
        int[] data;
        int fs; // firstStack
        int ss; // secondStack

        public TwoStackArray(int capacity) {
            data = new int[capacity];
            fs = -1;
            ss = capacity;
        }

        public int size1() {
            return fs + 1;
        }

        public int size2() {
            return data.length - ss;
        }

        public int display1() {
            if (fs == -1) {
                System.out.println("_________________________");
                System.out.println("Stack1 Underflow Error");
                System.out.println("_________________________");
                return -1;
            }
            String str = "";
            for(int i=fs; i>=0; i--){
                str = str + "-" + data[i];
            }
            System.out.println("___________________________");
            System.out.println("Stack1 Display is: " + str.substring(1));
            System.out.println("___________________________");
            return 0;
        }

        public int display2() {
            if (fs == data.length) {
                System.out.println("_________________________");
                System.out.println("Stack2 Underflow Error");
                System.out.println("_________________________");
                return -1;
            }
            String str = "";
            for(int i=ss; i<data.length; i++){
                str = str + "-" + data[i];
            }
            System.out.println("___________________________");
            System.out.println("Stack2 Display is: " + str.substring(1));
            System.out.println("___________________________");
            return 0;
        }

        public int push1(int val) {
            if (fs + 1 == ss) {
                System.out.println("________________________");
                System.out.println("Stack Overflow Error");
                System.out.println("________________________");
                return -1;
            }
            fs++;
            data[fs] = val;
            return val;
        }

        public int push2(int val) {
            if (ss - 1 == fs) {
                System.out.println("________________________");
                System.out.println("Stack Overflow Error");
                System.out.println("________________________");
                return -1;
            }
            ss--;
            data[ss] = val;
            return val;
        }

        public int pop1() {
            if (fs == -1) {
                System.out.println("________________________");
                System.out.println("Stack1 Underflow Error");
                System.out.println("________________________");
                return -1;
            }
            int removedVal = data[fs];
            fs--;
            return removedVal;
        }

        public int pop2() {
            if (ss == data.length) {
                System.out.println("________________________");
                System.out.println("Stack2 Underflow Error");
                System.out.println("________________________");
                return -1;
            }
            int removedVal = data[ss];
            ss++;
            return removedVal;
        }

        public int peek1() {
            if (fs == -1) {
                System.out.println("________________________");
                System.out.println("Stack1 Underflow Error");
                System.out.println("________________________");
                return -1;
            }
            return data[fs];
        }

        public int peek2() {
            if (ss == data.length) {
                System.out.println("________________________");
                System.out.println("Stack2 Underflow Error");
                System.out.println("________________________");
                return -1;
            }
            return data[ss];
        }
    }
}
