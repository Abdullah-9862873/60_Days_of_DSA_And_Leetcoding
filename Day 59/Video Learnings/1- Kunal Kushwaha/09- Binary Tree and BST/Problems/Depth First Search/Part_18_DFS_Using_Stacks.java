/*
                        12
                       /   \
                      3     9
                     / \    /
                    5   6  18
                        /
                       4

In this tree lets say we want preOrder traversal

we will make a stack st

1) Add root to the stack 
2) while(!st.isEmpty)
3) Keep popping and printing and when you pop add the right child first and then left because in this way the left child will be popped first the next time... As stack are in LIFO manner.... So we get left child first which is preOrder Node-Left-Right
4) So 12 will be stored in str and 9 and 3 gets added
str = 12
5) Then 3 will be popped and 6 and 5 gets added
str = 12 3
6) Then 5 will get popped and nothing gets added
str = 12 3 5
7) Then 6 will get popped and 4 gets added
str = 12 3 5 6
8) Then 4 gets popped
str = 12 3 5 6 4
9) Then 9 gets popped and 18 will get added
str = 12 3 5 6 4 9
10) Then 18 gets popped
str = 12 3 5 6 4 9 18

*/

import java.util.*;

public class Part_18_DFS_Using_Stacks{
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        dfsUsingStack(root);
    }
    public static void dfsUsingStack(Node node){
        if(node == null){
            return;
        }

        String str = "";
        Stack<Node> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            Node removed = st.pop();
            str = str + "-" + removed.value;
            if(removed.right != null){
                st.push(removed.right);
            }
            if(removed.left != null){
                st.push(removed.left);
            }
        }
        System.out.println(str.substring(1));
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