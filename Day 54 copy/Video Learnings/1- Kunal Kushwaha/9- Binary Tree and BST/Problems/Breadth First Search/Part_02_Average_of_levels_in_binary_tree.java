/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
 */
import java.util.*;

public class Part_02_Average_of_levels_in_binary_tree {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();
        
        List<Double> ans = new ArrayList<>();
        ans = getAverageOfLevels(root);
        System.out.println(ans);
    }

    public static List<Double> getAverageOfLevels(Node node){
        List<Double> list = new ArrayList<>();
        if(node == null){
            return list;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();        // 1
            double sum = 0;     // 3
            for(int i=0; i<size; i++){
                Node newNode = q.remove();
                sum += newNode.value;
                if(newNode.left != null){
                    q.add(newNode.left);
                }
                if(newNode.right != null){
                    q.add(newNode.right);
                }
            }
            list.add((double)(sum/size));
        }
        return list;
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