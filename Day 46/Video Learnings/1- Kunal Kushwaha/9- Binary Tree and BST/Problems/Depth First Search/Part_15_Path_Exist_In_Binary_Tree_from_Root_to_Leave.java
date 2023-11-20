/*
                                    3
                                   / \
                                  5   9
                                     / \
                                    10  12
                                   /    /
                                  16   8  

And you are given an input array [3,9,12,8]

You have to tell if 3->9->12->8 path exists here or not

 */
import java.util.Scanner;

public class Part_15_Path_Exist_In_Binary_Tree_from_Root_to_Leave {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        int[] inputArr = {3,9,12,8};
        boolean ans = checkPathExist(root, inputArr);
        System.out.println(ans);
    }
    public static boolean checkPathExist(Node root, int[] arr){
        boolean getAns = helper(root, arr, 0);
        return getAns;
    }
    public static boolean helper(Node root, int[] arr, int index){
        if(index >= arr.length || root == null){
            return false;
        }

        if(arr[index] != root.value){
            return false;
        }

        if(root.left == null && root.right == null && index == arr.length-1){
            return true;
        }

        boolean left = helper(root.left, arr, index+1);
        boolean right = helper(root.right, arr, index+1);
        return left || right;
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
