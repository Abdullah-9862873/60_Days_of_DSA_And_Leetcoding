import java.util.*;

public class Part_06_Populating_Next_Right_Pointers_In_Each_Node {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        populateNextPointers(root);
        displayNextPointers(root);
    }

    public static Node populateNextPointers(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node newNode = q.remove();
                if (i < size - 1) {
                    newNode.next = q.peek();
                } else {
                    newNode.next = null;
                }
                if (newNode.left != null) {
                    q.add(newNode.left);
                }
                if (newNode.right != null) {
                    q.add(newNode.right);
                }
            }
        }
        return root;
    }

    public static void displayNextPointers(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node newNode = q.remove();
            if (newNode.left != null) {
                q.add(newNode.left);
            }
            displayPointers(newNode, "");
        }
    }

    public static void displayPointers(Node node, String str) {
        if (node == null) {
            str = str + "Null";
            System.out.println(str);
            return;
        }

        if (str.isEmpty()) {
            str = node.value + "->";
        } else {
            str = str + node.value + "->";
        }
        displayPointers(node.next, str);
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

/*
Alternate Efficient Solution
public static Node populateNextPointers(Node root) {
    if (root == null) {
        return null;
    }
    populateNextPointersHelper(root);
    return root;
}

private static void populateNextPointersHelper(Node node) {
    if (node == null) {
        return;
    }
    if (node.left != null) {
        node.left.next = node.right;
    }
    if (node.right != null) {
        node.right.next = (node.next != null) ? node.next.left : null;
    }
    populateNextPointersHelper(node.left);
    populateNextPointersHelper(node.right);
}

*/
