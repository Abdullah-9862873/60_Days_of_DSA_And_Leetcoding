
/*
Two nodes x and y are cousins and will return true if they are at same level and their height is same
 */
import java.util.*;

public class Part_08_Cousins_of_Binary_Tree {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of x: ");
        int x = input.nextInt();
        System.out.println("Enter the value of y: ");
        int y = input.nextInt();
        input.close();
        boolean ans = isCousins(root, x, y);
        System.out.println(ans);
    }

    public static boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root,x);
        Node yy = findNode(root,y);

        return (level(root, xx,0) == level(root, yy,0) && !(isSibling(root, xx, yy)));
    }
    public static Node findNode(Node root, int x){
        if(root == null){
            return null;
        }

        if(root.value == x){
            return root;
        }
        if(root.left != null){
           Node leftSide =  findNode(root.left, x);
           if(leftSide.value == x){
            return leftSide;
           }
        }
        return findNode(root.right, x);
    }

    public static int level(Node root, Node x, int lev){
        if(root == null){
            return 0;
        }

        if(root == x){
            return lev;
        }

        if(root.left != null){
            int ans = level(root.left, x, lev+1);
            if(ans != 0){
                return ans;
            }
        }
        return level(root.right, x,lev+1);
    }
    public static boolean isSibling(Node root, Node x, Node y){
        if(root == null){
            return false;
        }

        return ((root.left == x && root.right == y) || (root.left == y && root.right == x) || (isSibling(root.left, x, y)) || (isSibling(root.right, x, y)));
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
