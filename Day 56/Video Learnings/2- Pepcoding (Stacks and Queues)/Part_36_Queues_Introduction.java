import java.util.*;
public class Part_36_Queues_Introduction {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        que.add(20);
        que.add(30);
        System.out.println("Whole queue is: " + que);
        System.out.println("Peek of the queue is: " + que.peek());
        que.remove();
        System.out.println("After one remove peek of the queue is: " + que.peek());
    }
}
