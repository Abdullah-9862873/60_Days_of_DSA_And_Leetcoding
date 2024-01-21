import java.util.*;

public class Part_11_Serialize_and_Deserialize_Binary_Tree {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        List<String> serializedList = serializeTree(root);
        List<String> deserializedListInput = new ArrayList<>(serializedList);
        System.out.println("Serialized Tree is: " + serializedList);

        // Converting the Serialized List to String

        String serialized = convertListToString(serializedList);
        System.out.println("Serialized is: " + serialized);

        root = deserializeTree(deserializedListInput);
        displayBinaryTree();
        checkBalancing();
        System.out.println();
    }
    public static String convertListToString(List<String> list){
        String str = "";
        while(!list.isEmpty()){
            if(list.get(0) != "null"){
                String element = list.remove(0);
                str = str + element;
            }else{
                list.remove(0);
            }
        }
        return str;
    }
    public static List<String> serializeTree(Node root){
        List<String> str = new ArrayList<>();
        serializeTreeHelper(root,str);
        return str;
    }
    public static void serializeTreeHelper(Node root, List<String> str){
        if(root == null){
            str.add("null");
            return;
        }

        str.add(String.valueOf(root.value));
        serializeTreeHelper(root.left, str);
        serializeTreeHelper(root.right, str);
    }
    public static Node deserializeTree(List<String> serializedList) {
        if (serializedList.isEmpty()) {
            return null;
        }
    
        String val = serializedList.get(0);
        serializedList.remove(0);
    
        if (val.equals("null")) {
            return null;
        }
    
        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeTree(serializedList);
        node.right = deserializeTree(serializedList);
    
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    
        return node;
    }
    

    public static void makeBinaryTree() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root Element: ");
        root = new Node(input.nextInt());
        populate(root, input);
    }

    public static void populate(Node root, Scanner input) {
        System.out.println("Do you want to enter the left of " + root.value + " (yes/no)");
        String leftChoice = input.next();
        if (leftChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the left node of " + root.value);
            root.left = new Node(input.nextInt());
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            populate(root.left, input);
        }
        System.out.println("Do you want to enter the right of " + root.value + " (yes/no)");
        String rightChoice = input.next();
        if (rightChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the right node of " + root.value);
            root.right = new Node(input.nextInt());
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            populate(root.right, input);
        }
    }

    public static void checkBalancing() {
        boolean ans = isBalanced(root);
        if (ans == true) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        return (height(root.left) - height(root.right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void displayBinaryTree() {
        display(root, "", false);
    }

    public static void display(Node root, String str, boolean isLeft) {
        if (root == null) {
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + root.value + " (" + height(root) + ")");
        display(root.left, str + (isLeft ? "|   " : "    "), true);
        display(root.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node next;
        private int height;

        public Node(int val) {
            this.value = val;
        }
    }
}
