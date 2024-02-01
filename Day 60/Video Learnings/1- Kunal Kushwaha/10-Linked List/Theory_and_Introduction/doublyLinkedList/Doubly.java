public class Doubly {
    private Node head;
    private Node tail;

    private int size;
    public Doubly(){
        this.size = 0;
    }

    // Insert At First
    public void insertAtFirst(int value){
        Node node = new Node(value);
        if(size > 0){
            node.next = head;
            head.prev = node;
        }else{
            tail = node;
        }
        head = node;
        size++;
        return;
    }

    // Insert at Last
    public void insertAtLast(int value){
        if(size == 0){
            insertAtFirst(value);
            return;
        }
        
        Node node = new Node(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        return;
    }

    // Insert At Index
    public void insertAtIndex(int idx, int value){
        if(idx == 0){
            insertAtFirst(value);
            return;
        }
        if(idx == size-1 || idx == size){
            insertAtLast(value);
            return;
        }
        if(idx > size || idx < 0){
            System.out.println("Invalid Index");
            return;
        }

        Node node = new Node(value);
        Node temp = head;
        int count = 0;
        while(count != idx-1){
            temp = temp.next;
            count++;
        }
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
        size++;
        return;
    }

    // Delete first
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
        head = head.next;
        head.prev = null;
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
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    // Delete a particular index
    public int deleteIdx(int idx){
        if(idx == 0){
            return deleteFirst();
        }
        if(idx < 0 || idx > size-1){
            return -1;
        }
        if(idx == size-1){
            return deleteLast();
        }

        Node temp = head;
        int counter = 0;
        while(counter != idx-1){
            temp = temp.next;
            counter++;
        }
        int val = temp.next.value;
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    // Find Node
    public Node findNode(int value){
        if(size == 0){
            return null;
        }
        if(size == 1 && head.value == value){
            return head;
        }

        Node temp = head;
        while(temp!= null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display
    public void display(){
        if(size == 0){
            return;
        }
        System.out.print("null <- ");
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.value + " <--> ");
            temp = temp.next;
        }
        System.out.print(temp.value + " -> null");
        System.out.println();
        return;
    }

    // Get Index
    public int getIndex(Node node){
        if(size == 0){
            return -1;
        }
        if(size == 1 && head.value == node.value){
            return 0;
        }

        Node temp = head;
        int idx = 0;
        while(temp != null){
            if(temp.value == node.value){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }
    
    private class Node{
        public int value;
        public Node next;
        public Node prev;

        public Node(int value){
            this.value = value;
        }  

        @Override
        public String toString() {
            // "this" will refer to Node
            return "Node {\n\tNode-Index: " + getIndex(this) + " Node-value: " + this.value + "\n}";
        }
    }

    public static void main(String[] args) {
        Doubly dl = new Doubly();
        // dl.insertAtFirst(3);
        // dl.insertAtLast(4);
        // dl.insertAtLast(5);
        // dl.display();
        // dl.insertAtIndex(1,6);
        // dl.display();
        // dl.insertAtIndex(0,7);
        // dl.display();
        // dl.insertAtIndex(5, 20);
        // dl.display();
        // dl.insertAtIndex(2, 9);
        // dl.display();

        // dl.insertAtFirst(1);
        // dl.insertAtLast(2);
        // dl.insertAtLast(3);
        // dl.insertAtLast(4);
        // dl.insertAtLast(5);
        // dl.display();
        // System.out.println();
        // System.out.println();
        // dl.deleteFirst();
        // dl.display();
        // System.out.println();
        // System.out.println();
        // dl.deleteFirst();
        // dl.display();
        // System.out.println();
        // System.out.println();
        // dl.deleteLast();
        // dl.display();
        // System.out.println();
        // System.out.println();
        // dl.deleteLast();
        // dl.display();
        // System.out.println();
        // System.out.println();
        // dl.deleteLast();


        // dl.insertAtFirst(1);
        // dl.insertAtLast(2);
        // dl.insertAtLast(3);
        // dl.insertAtLast(4);
        // dl.insertAtLast(5);
        // dl.display();
        // dl.deleteIdx(2);
        // dl.display();
        // dl.deleteIdx(2);
        // dl.display();
        // dl.deleteIdx(1);
        // dl.display();
        // dl.deleteIdx(1);
        // dl.display();
        // dl.deleteIdx(0);
        // dl.display();

        dl.insertAtFirst(1);
        dl.insertAtLast(2);
        dl.insertAtLast(3);
        dl.insertAtLast(4);
        dl.insertAtLast(5);
        dl.display();
        Node node = dl.findNode(5);
        System.out.println(node);
    }
}