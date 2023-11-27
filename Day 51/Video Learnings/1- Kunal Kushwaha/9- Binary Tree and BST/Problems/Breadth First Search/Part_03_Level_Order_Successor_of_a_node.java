/*
Level Order Successor is that if you are given a value then return the value that is just next to it

Like in the following tree
                                3
                               / \
                              9  20
                             / \ / \
                            10 1 2  6

The value that is just after 9 is 20
 */
import java.util.*;

public class Part_03_Level_Order_Successor_of_a_node {
    public static Node root;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();
        System.out.println("Enter the node you want to find the successor of: ");
        int in = input.nextInt();       // 9
        input.close();
        int ans = getLevelOrderSuccessor(root, in);
        System.out.println("The successor of in is: " + ans);
    }
    public static int getLevelOrderSuccessor(Node root, int target){
        if(root == null){
            return -1;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node newNode = q.remove();
                if(newNode.left != null){
                    q.add(newNode.left);
                }
                if(newNode.right != null){
                    q.add(newNode.right);
                }
                if(newNode.value == target){
                    return q.peek().value;
                }
            }
        }
        return -1;
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
        private int height;

        public Node(int val) {
            this.value = val;
        }
    }
}
