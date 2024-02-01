public class Singly{
    private Node head;
    private Node tail;

    private int size;
    public Singly(){
        this.size = 0;
    }

    // Insert At First
    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    // Insert At Last
    public void insertAtLast(int value){
        if(tail == null){
            insertAtFirst(value);
            return;
        }
        
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    // Insert At Index
    public void insertAtIndex(int idx, int value){
        if(idx < 0){
            System.out.println("Invalid index");
            return;
        }
        if(idx == 0){
            insertAtFirst(value);
            return;
        }
        if(idx == size){
            insertAtLast(value);
            return;
        }
        if(idx > size){
            System.out.println("Cannot insert at this index because size is lesser than that");
            return;
        }
        Node temp = head;
        int count = 0;
        while(count != idx-1){
            temp = temp.next;
            count++;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
        return;
    }

    // Delete First
    public int deleteFirst(){
        if(head == null){
            return -1;
        }
        int val = head.value;
        if(size == 1){
            head = head.next;
            tail = tail.next;
            size--;
            return val;
        }
        head = head.next;
        size--;
        return val;
    } 

    // Delete Last
    public int deleteLast(){
        if(size <= 1){
            deleteFirst();
        }
        
        Node secondLast = get(size-2);
        int val = tail.value;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return val;
    }

    // Delete a particular index
    public int deleteIndex(int idx){
        if(idx == 0){
            return deleteFirst();
        }
        if(idx == size-1){
            return deleteLast();
        }
        if(idx < 0){
            return -1;
        }

        Node temp = get(idx-1);
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;

    }

    // Find Node
    public Node findNode(int value){
        if(size == 0){
            return null;
        }

        Node temp = head;
        if(temp.value == value){
            return temp;
        }
        while(temp.next != null){
            temp = temp.next;
            if(temp.value == value){
                return temp;
            }
        }
        return null;
    }

    // Get Method
    public Node get(int idx){
        if(idx < 0 || idx >= size){
            return null;
        }

        Node temp = head;
        int count = 0;
        while(count != idx){
            temp = temp.next;
            count++;
        }
        return temp;
    }

    // Display
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // Get Index
    private int getIndex(Node node) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.value == node.value) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            // "this" will refer to Node
            return "Node {\n\tNode-Index: " + getIndex(this) + " Node-value: " + this.value + "\n}";
        }
    }

    public static void main(String[] args) {
        Singly sl = new Singly();
        sl.insertAtFirst(3);
        sl.insertAtLast(8);
        sl.insertAtLast(7);
        sl.insertAtLast(6);
        sl.insertAtLast(5);

        sl.display();

        sl.insertAtIndex(2,9);

        sl.display();

        sl.deleteFirst();
        sl.deleteFirst();

        sl.display();

        Node node = sl.get(3);
        System.out.println(node.value);
        System.out.println(sl.size);


        sl.deleteLast();
        sl.display();

        sl.deleteIndex(1);
        sl.display();

        sl.insertAtLast(5);
        sl.insertAtLast(3);
        sl.insertAtLast(1);

        sl.display();

        Node result = sl.findNode(3);
        System.out.println(result);

    }
}