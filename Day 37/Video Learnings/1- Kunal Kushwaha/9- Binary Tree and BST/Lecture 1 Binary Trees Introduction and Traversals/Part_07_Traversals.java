import java.util.Scanner;

public class Part_07_Traversals {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        display(root, "", false);
        String preOrder = getPreOrder(root);
        String inOrder = getInOrder(root);
        String postOrder = getPostOrder(root);
        
        System.out.println("PreOrder Traversal is: " + preOrder);
        System.out.println("InOrder Traversal is: " + inOrder);
        System.out.println("PostOrder Traversal is: " + postOrder);
    }

    public static String getPreOrder(Node root){
        if(root == null){
            return "";
        }
        String ans = "";
        ans += root.value + "-";
        ans += getPreOrder(root.left);
        ans += getPreOrder(root.right);
        return ans;
    }
    public static String getInOrder(Node root){
        if(root == null){
            return "";
        }

        String ans = "";
        ans += getInOrder(root.left);
        ans += root.value + "-";
        ans += getInOrder(root.right);
        return ans;
    }

    public static String getPostOrder(Node root){
        if(root == null){
            return "";
        }
        String ans = "";
        ans += getPostOrder(root.left);
        ans += getPostOrder(root.right);
        ans += root.value + "-";
        return ans;
    }

    public static void makeBinaryTree() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many total nodes you want in the tree?");
        int size = input.nextInt();
        int[] userInputs = new int[size];
        for (int i = 0; i < userInputs.length; i++) {
            if(i == 0){
                System.out.println("Enter the first and the root value of binary search tree");
            }else{
                System.out.println("Enter the " + (i + 1) + " value of binary search tree");
            }
            userInputs[i] = input.nextInt();
        }
        populate(userInputs);
        input.close();
        System.out.println();
    }

    public static void displayBinaryTree() {
        display(root, "", false);
        return;
    }

    public static void balancingCheck() {
        if (checkBalance(root)) {
            System.out.println("The Binary Search Tree is Balanaced");
        } else {
            System.out.println("The Binary Search Tree is not Balanaced");
        }
    }

    public static void populate(int[] userInputs) {
        if (userInputs.length >= 1) {
            root = new Node(userInputs[0]);
        }
        for (int i = 1; i < userInputs.length; i++) {
            Node value = new Node(userInputs[i]);
            insert(root, value);
        }
    }

    public static void insert(Node root, Node node) {
        if (root == null) {
            return;
        }

        if (node.value < root.value && root.left != null) {
            insert(root.left, node);
        } else if (node.value < root.value && root.left == null) {
            root.left = node;
        } else if (node.value > root.value && root.right != null) {
            insert(root.right, node);
        } else if (node.value > root.value && root.right == null) {
            root.right = node;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void display(Node root, String str, boolean isLeft) {
        if (root == null) {
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + root.value);
        display(root.left, str + (isLeft ? "|   " : "    "), true);
        display(root.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static boolean checkBalance(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = root.left == null ? -1 : root.left.height;
        int rightHeight = root.right == null ? -1 : root.right.height;
        return Math.abs(leftHeight - rightHeight) <= 1 && checkBalance(root.left) && checkBalance(root.right);

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

        public Node(int value) {
            this.value = value;
        }
    }

}
