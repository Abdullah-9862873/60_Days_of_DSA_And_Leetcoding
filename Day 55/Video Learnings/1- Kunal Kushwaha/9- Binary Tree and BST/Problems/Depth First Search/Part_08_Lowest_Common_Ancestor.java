/*
Lets say you have the following tree input
                                    6
                                   /  \
                                  2    8
                                 / \  / \
                                0  4  7  9
                                  / \
                                 3   5

And the p and q are 2 and 9 
Then the answer should be 6 because that is the lowest possible ancestor
 */
import java.util.Scanner;

public class Part_08_Lowest_Common_Ancestor {
    public static Node root;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();
        
        System.out.println("Enter the value of p: " );
        int p = input.nextInt();
        System.out.println("Enter the value of q: ");
        int q = input.nextInt();
        input.close();

        Node pNode = findNode(p, root);
        Node qNode = findNode(q, root);

        Node ans = findLowestCommonAncestor(root, pNode, qNode);
        System.out.println("Lowest Common Ancestor is: " + ans.value);
    }
    public static Node findLowestCommonAncestor(Node root, Node p, Node q){
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        Node left = findLowestCommonAncestor(root.left, p, q);
        Node right = findLowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    public static Node findNode(int val, Node root){
        if(root == null){
            return null;
        }

        if(root.value == val){
            return root;
        }
        Node left = findNode(val, root.left);
        if(left != null){
            return left;
        }
        return findNode(val, root.right);
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
