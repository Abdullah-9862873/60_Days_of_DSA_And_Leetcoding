// Reverse Linked List within Boundaries
public class Question2 {
    private Node head;
    private Node tail;

    private int size;

    public Question2() {
        this.size = 0;
    }

    // Display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // Insert At First
    public void insertAtFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    // Insert At Last
    public void insertAtLast(int value) {
        if (tail == null) {
            insertAtFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    // Get Node
    public Node getNode(Question2 obj, int val) {
        Node temp = obj.head;
        Node result = new Node();
        while (temp != null) {
            if (temp.value == val) {
                result = temp;
                return result;
            }
            temp = temp.next;
        }
        return null;
    }

    // Get Previous
    public static Node getPrevious(Question2 obj, int val) {
        Node temp = obj.head;
        while (temp != null && temp.next != null) {
            if (temp.next.value == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Linked List
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {

        }
    }

    public static void main(String[] args) {
        Question2 list1 = new Question2();

        list1.insertAtFirst(1);
        list1.insertAtLast(2);
        list1.insertAtLast(3);
        list1.insertAtLast(4);
        list1.insertAtLast(5);
        list1.display();

        reverse(list1, 1, 5);
        list1.display();
    }

    public static Node reverse(Question2 obj, int first, int second) {
        Node prev = getPrevious(obj, first);
        Node pres = obj.getNode(obj, first);
        Node next = pres.next;
        Node newNext = null;
        if (next != null) {
            newNext = next.next;
        }

        Node left = prev;
        Node nodeOfSecond = obj.getNode(obj,second);
        Node nodeOfFirst = obj.getNode(obj, first);
        if (left == null) {
            left = obj.head;
        }
        while (pres.value != second && next != null) {
            next.next = pres;
            prev = pres;
            pres = next;
            next = newNext;
            if (next != null) {
                newNext = next.next;
            }
        }

        if(left.value == first){
            left.next = next;
            obj.head = nodeOfSecond;
            return obj.head;
        }else if(left.value != first && nodeOfSecond.next != null){
            // No head change
            left.next.next = next;
            left.next = pres;
            if(next != null){
                next.next = null;
            }
            return left;
        }else if(left.value != first && nodeOfSecond.next == null){
            left.next = nodeOfSecond;
            nodeOfFirst.next = null;
            return left;
        }
        return null;
    }

}
