import java.util.*;

public class Part_45_Minimum_Stack_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the capacity of Stack: ");
        int capacity = input.nextInt();

        CustomStack st = new CustomStack(capacity);
        while (true) {
            System.out.println();
            System.out.println("Choose between the following: (1/2/3/4/5/6) or enter 0 to exit");
            System.out.println("1- size()");
            System.out.println("2- display()");
            System.out.println("3- push()");
            System.out.println("4- pop()");
            System.out.println("5- peek()");
            System.out.println("6- min()");
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
                if (output == -1) {
                    break;
                }
            } else if (userInput == 4) {
                int val = st.pop();
                if (val == -1) {
                    break;
                }
            } else if (userInput == 5) {
                System.out.println("______________________________________");
                System.out.println("Peek of the Stack is: " + st.peek());
                System.out.println("______________________________________");
            } else if (userInput == 6) {
                int min = st.getMinimum();
                if (min == -1) {
                System.out.println("______________________________________");
                System.out.println("Stack Overflow Error");
                System.out.println("______________________________________");
                }else{
                    System.out.println("______________________________________");
                    System.out.println("Minimum of the Stack is: " + min);
                    System.out.println("______________________________________");
                }
            }
        }
        input.close();
    }

    public static class CustomStack {
        int[] data;
        int min;

        public CustomStack(int capacity) {
            data = new int[capacity];
            min = -1;
        }

        private int index = 0;

        public int size() {
            return index;
        }

        public void display() {
            String str = "";
            int tempMin = min;
            for (int i = index - 1; i >= 0; i--) {
                if(data[i] < tempMin){
                    str = str + "-" + tempMin;
                    tempMin = 2*tempMin - data[i];
                }else{
                    str = str + "-" + data[i];
                }
            }
            System.out.println("______________________________________");
            System.out.println("Stack is: " + str.substring(1));
            System.out.println("______________________________________");
        }

        public int push(int val) {
            if (index >= data.length) {
                System.out.println("______________________________________");
                System.out.println("Stack Overflow Error");
                System.out.println("______________________________________");
                return -1;
            }
            if (index == 0) {
                data[index] = val;
                min = val;
                index++;
            } else {
                if (val < min) {
                    int newVal = val + (val - min);
                    min = val;
                    data[index] = newVal;
                    index++;
                } else {
                    data[index] = val;
                    index++;
                }
            }
            return val;
        }

        public int pop() {
            if (index <= 0) {
                System.out.println("______________________________________");
                System.out.println("Stack underflow error");
                System.out.println("______________________________________");
                return -1;
            }
            if (data[index-1] < min) {
                int removedVal = min;
                min = 2 * min - data[index-1];
                index--;
                return removedVal;
            } else if (peek() > min) {
                int removedVal = data[index - 1];
                index--;
                return removedVal;
            }
            min = -1;
            int removedVal = data[index - 1];
            index--;
            return removedVal;
        }

        public int peek() {
            if (index <= 0 || index > data.length) {
                return -1;
            }
            return data[index - 1];
        }

        public int getMinimum() {
            if (index == 0) {
                return -1;
            }
            return min;
        }
    }
}



/*
The CustomStack class uses a single variable min to keep track of the minimum value in the stack, and this approach is more memory-efficient and can lead to more efficient push, pop, and display operations compared to using a separate array (min[]). Here's how the single variable min is leveraged in each method:

Push Method (push(int val)):

When pushing a new element onto the stack:

If the stack is empty (index == 0), set both data[index] and min to the new value (val).
If the new value (val) is smaller than the current minimum (min):
Calculate the adjusted value (newVal) to be stored in data[index] (this helps in reconstructing the original value during display).
Update min to the new minimum (val).
If the new value is not smaller than the current minimum, simply store the new value in data[index].
This approach ensures that the minimum value is always tracked efficiently, and adjustments in the data array allow for easy reconstruction during display and pop operations.

Pop Method (pop()):

When popping an element from the stack:

If the top element in data is less than the current minimum (min), it means an adjusted value is stored.
Return the current minimum (min) and update it using the adjusted value.
If the top element is not less than the current minimum, return it directly.
This approach efficiently handles the pop operation, and the min variable is updated accordingly without requiring a separate array.

Display Method (display()):

During the display operation, the display() method efficiently reconstructs the original values from the adjusted values stored in the data array.
The tempMin variable is used to reconstruct the original values.
In summary, by using a single variable (min) to keep track of the minimum value and adjusting values in the data array, the second code achieves more memory-efficient push, pop, and display operations compared to the first code that uses a separate array (min[]). The adjustments in the data array allow the algorithm to keep track of the minimum value without using additional space for a separate minimum array. This approach results in more efficient utilization of memory and potentially faster operations
*/