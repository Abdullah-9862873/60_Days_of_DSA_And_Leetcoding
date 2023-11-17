
/*
Initial tree

                                        p
                                       / \
                                      c   t3
                                     / \
                                    t1  t2 

After doing right rotation(p)
                                       c
                                      / \
                                     t1  p
                                        / \
                                       t2  t3

You can obtain the exact first tree after performing leftRotation(p) on the second tree

*/
import java.util.Scanner;

public class Part_02_Implementing_AVL {
    public static Node root;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root element: ");
        root = new Node(input.nextInt());
        populate(input);
        System.out.println();
        display(root, "", false);

        boolean balanced = checkBalance(root);
        if (balanced) {
            System.out.println("The binary search tree is balanced");
        } else {
            System.out.println("The binary search tree is not balanced");
        }
    }

    // Identifying the four cases
    public static Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // Right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public static Node rightRotate(Node p) {
        // During Right Rotation we have to change the position of "c" "t2" and "p"
        // Look at the diagram at the top
        Node c = p.left;
        Node t2 = c.right;

        c.right = p;
        p.left = t2;

        // Since the heights are changing so we have to update the heights
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    public static Node leftRotate(Node c) {
        // During the left Rotation we have to change the position of "c", "t2"
        Node p = c.right;
        Node t2 = p.left;

        p.left = c;
        c.right = t2;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return p;
    }

    public static void populate(Scanner input) {
        System.out.println("Do you want to insert a value: (yes/no)");
        String userChoice = input.next();
        if (userChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the value: ");
            int value = input.nextInt();
            Node newNode = new Node(value);
            root = insert(root, newNode);
            populate(input);
        }
    }

    public static Node insert(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if (node.value < root.value) {
            root.left = insert(root.left, node);
        } else if (node.value > root.value) {
            root.right = insert(root.right, node);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        return rotate(root);
    }

    public static void display(Node node, String str, boolean isLeft) {
        if (node == null) {
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + node.value);
        display(node.left, str + (isLeft ? "|   " : "    "), true);
        display(node.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static boolean checkBalance(Node node) {
        if (node == null) {
            return true;
        }

        return height(node.left) - height(node.right) <= 1 && checkBalance(node.left) && checkBalance(node.right);
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