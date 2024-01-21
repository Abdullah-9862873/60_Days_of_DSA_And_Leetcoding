import java.util.*;

public class Part_09_Symmetric_Tree {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        boolean symmetry = isSymmetric(root);
        System.out.println(symmetry);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }

        ArrayList<Node> arr = new ArrayList<>();
        arr.add(root);
        while (arr.size() != 0) {
            int size = arr.size();
            boolean check = checkChildrenSymmetry(arr, size);
            if (check) {
                for (int i = 0; i < size; i++) {
                    Node newNode = arr.remove(0);
                    if (newNode.left != null) {
                        arr.add(newNode.left);
                    }
                    if (newNode.right != null) {
                        arr.add(newNode.right);
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean checkChildrenSymmetry(ArrayList<Node> arr, int size) {
        int p1 = 0;
        int p2 = size - 1;
    
        while (p1 <= p2) {
            Node p1Node = arr.get(p1);
            Node p2Node = arr.get(p2);
    
            boolean condition1 = (p1Node.left == null && p2Node.right == null) ||
                                 (p1Node.left != null && p2Node.right != null && p1Node.left.value == p2Node.right.value);
    
            boolean condition2 = (p1Node.right == null && p2Node.left == null) ||
                                 (p1Node.right != null && p2Node.left != null && p1Node.right.value == p2Node.left.value);
    
            if (!(condition1 && condition2)) {
                return false;
            }
    
            p1++;
            p2--;
        }
        return true;
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
