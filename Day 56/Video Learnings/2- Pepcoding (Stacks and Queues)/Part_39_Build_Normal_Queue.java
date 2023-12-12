import java.util.*;

public class Part_39_Build_Normal_Queue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the Queue: ");
        int capacity = input.nextInt();
        CustomQueue que = new CustomQueue(capacity);

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
                int size = que.size();
                System.out.println(size);
            } else if (userInput == 2) {
                que.display();
            } else if (userInput == 3) {
                System.out.println("Enter the value to add: ");
                int val = input.nextInt();
                int output = que.add(val);
                if (output == -1) {
                    break;
                }
            } else if (userInput == 4) {
                int val = que.remove();
                if (val == -1) {
                    break;
                }
                System.out.println("Removed element: " + val);
            } else if (userInput == 5) {
                int val = que.peek();
                if (val == -1) {
                    break;
                }
                System.out.println("Peek of the Queue is: " + val);
            }
        }
        input.close();
    }

    public static class CustomQueue {
        int[] data;
        int capacity;
        int size;
        int front;
        int rear;

        public CustomQueue(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.size = 0;
            this.front = 0;
            this.rear = -1;
        }

        public void display() {
            String ans = "";
            for (int k = 0; k < size; k++) {
                ans = ans + "-" + data[(front + k) % capacity];
            }
            System.out.println("___________________________");
            System.out.println("Queue is: " + ans.substring(1));
            System.out.println("___________________________");
        }

        public int size() {
            return size;
        }

        public int add(int val) {
            if (size >= capacity) {
                System.out.println("___________________________");
                System.out.println("Queue is full. Cannot add more elements.");
                System.out.println("___________________________");
                return -1;
            } else {
                rear = (rear + 1) % capacity;
                data[rear] = val;
                size++;
            }
            return val;
        }

        public int peek() {
            if (size == 0) {
                System.out.println("___________________________");
                System.out.println("Queue is Empty");
                System.out.println("___________________________");
                return -1;
            }
            return data[front];
        }

        public int remove() {
            if (size == 0) {
                System.out.println("___________________________");
                System.out.println("NoSuchElementException");
                System.out.println("___________________________");
                return -1;
            }
            int removedVal = data[front];
            front = (front + 1) % capacity;
            size--;
            return removedVal;
        }
    }
}
