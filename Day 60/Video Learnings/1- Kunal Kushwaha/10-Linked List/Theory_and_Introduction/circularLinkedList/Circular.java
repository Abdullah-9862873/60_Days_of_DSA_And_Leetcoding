public class Circular{
    private Node head;
    private Node tail;

    private int size;
    public Circular(){
        this.size = 0;
    }

    // Insert at last
    public void insertAtLast(int value){
        if(size == 0){
            Node node = new Node(value);
            head = node;
            tail = node;
            head.next = node;
            tail.next = node;
            size++;
            return;
        }
        Node node = new Node(value);
        node.next = head;
        tail.next = node;
        tail = node;
        size++;
        return;
    }

    // Insert At first
    public void insertAtFirst(int value){
        if(size == 0){
            insertAtLast(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        node.next = head;
        head = node;
        size++;
        return;
    }

    // Delete First
    public int deleteFirst(){
        if(size == 0){
            return -1;
        }
        if(size == 1){
            int val = head.value;
            head = null;
            tail = null;
            size--;
            return val;
        }

        int val = head.value;
        tail.next = head.next;
        head = tail.next;
        size--;
        return val;
    }

    // Delete last
    public int deleteLast(){
        if(size == 0){
            return -1;
        }
        if(size == 1){
            return deleteFirst();
        }

        int val = tail.value;
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
        size--;
        return val;
    }

    // Insert At Index
    public void insertAtIndex(int value, int index){
        if(index == 0){
            insertAtFirst(value);
            return;
        }
        if(index == size-1){
            insertAtLast(value);
            return;
        }

        Node node = new Node(value);
        Node temp = head;
        int myIndex = 0;
        while(myIndex != index-1){
            temp = temp.next;
            myIndex++;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
        return;
    }

    // Display
    public void display(){
        if(size == 0){
            return;
        }


        Node temp = head;
        System.out.print(temp.value + " -> ");
        temp = temp.next;
        while(temp != head){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
        return;
    }

    public class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Circular cl = new Circular();
        cl.insertAtLast(1);
        cl.display();
        cl.insertAtLast(2);
        cl.display();
        cl.insertAtLast(3);
        cl.display();

        cl.insertAtFirst(20);
        cl.display();

        cl.insertAtIndex(30, 2);
        cl.display();

        cl.deleteFirst();
        cl.display();
        
        cl.deleteLast();
        cl.deleteLast();
        cl.deleteLast();
        cl.display();
    }
}