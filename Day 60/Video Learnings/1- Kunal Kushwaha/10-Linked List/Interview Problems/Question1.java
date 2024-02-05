// Remove Duplicacy
public class Question1{
    private static Node head;
    private Node tail;

    private int size;
    public Question1(){
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

    // Insert Recursively
    public void insertRec(int index, int val){
        Node node = new Node(val);
        head = insertRecHelper(index, node, head);
        return;
    }
    public Node insertRecHelper(int index, Node node, Node currentNode){
        if(index == 0){
            node.next = currentNode;
            return node;
        }

        currentNode.next = insertRecHelper(index-1, node, currentNode.next);
        return currentNode;
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

    // Get Head
    public static Node getHead(){
        return head;
    }

    // Size fixer
    public void sizeFixer(){
        Node node = head;
        int size2 = 0;
        while(node != null){
            size2++;
            node = node.next;
        }
        size = size2;
        return;
    }


    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        
        // public Node(int value, Node next){
        //     this.value = value;
        //     this.next = next;
        // }

        @Override
        public String toString() {
            // "this" will refer to Node
            return "Node {\n\tNode-Index: " + getIndex(this) + " Node-value: " + this.value + "\n}";
        }
    }
    public static void main(String[] args) {
        Question1 sl = new Question1();
        sl.insertAtFirst(1);
        sl.insertAtLast(2);
        sl.insertAtLast(3);
        sl.insertAtLast(4);
        sl.insertAtLast(5);
        sl.insertAtLast(5);
        sl.display();

        removeDuplicacy(getHead());
        sl.display();
    }
    public static void removeDuplicacy(Node head){
        removeDuplicacyHelper(head, head.next);
        Question1 obj = new Question1();
        obj.sizeFixer();
        return;
    }
    public static void removeDuplicacyHelper(Node prev, Node current){
        if(current == null){
            return;
        }
        if(prev.value == current.value){
            if(current.next == null){
                prev.next = null;
                return;
            }
            removeDuplicacyHelper(prev, current.next);
            return;
        }
        if(prev.value != current.value){
            prev.next = current;
            removeDuplicacyHelper(current, current.next);
            return;
        }

    }
}