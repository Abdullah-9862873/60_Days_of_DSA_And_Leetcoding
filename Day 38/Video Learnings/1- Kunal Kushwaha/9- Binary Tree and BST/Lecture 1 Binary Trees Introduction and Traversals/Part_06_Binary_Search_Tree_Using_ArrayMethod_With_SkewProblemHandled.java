
/*
The idea is that when an array is given to us which is sorted like the following
[1,2,3,4,5,6,7,8,9,10]

Then we will apply dividing the array from middle approach so that the resultant tree will be something like:

                                               5
                                            /    \
                                          2       8
                                         / \     / \
                                        1   3   6   9
                                             \   \   \
                                              4   7   10
 */
import java.util.Scanner;

public class Part_06_Binary_Search_Tree_Using_ArrayMethod_With_SkewProblemHandled {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        balancingCheck();
    }

    public static void makeBinaryTree() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many total nodes you want in the tree?");
        int size = input.nextInt();
        int[] userInputs = new int[size];
        for (int i = 0; i < userInputs.length; i++) {
            System.out.println("Enter the " + (i + 1) + " value of binary search tree");
            userInputs[i] = input.nextInt();
        }
        root = populate(userInputs, 0, userInputs.length - 1);
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

    public static Node populate(int[] userInputs, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(userInputs[mid]);
        node.left = populate(userInputs, start, mid - 1);
        node.right = populate(userInputs, mid + 1, end);
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
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
