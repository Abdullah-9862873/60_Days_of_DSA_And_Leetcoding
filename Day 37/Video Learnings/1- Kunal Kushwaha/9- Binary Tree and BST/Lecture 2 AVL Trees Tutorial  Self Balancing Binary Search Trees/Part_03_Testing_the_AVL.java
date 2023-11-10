/*
Note:
Here I have inserted Nodes from 0 to 1000... With using the traditional method the height of the overall tree would have been so high... And the tree would have been imbalanced... But AVL allows you to maintain the height of the tree to be Log(n) so log(1000) = 3... 
*/

import java.util.*;

public class Part_03_Testing_the_AVL {
    public static Node root;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Node node = new Node(i);
            root = insert(root, node);
        }
    
        display(root, "", false);
    
        boolean balanced = checkBalance(root);
        if (balanced) {
            System.out.println("The binary search tree is balanced");
        } else {
            System.out.println("The binary search tree is not balanced");
        }
        System.out.println(height(root));
    }
    
    public static Node rotate(Node node) {

        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            } else if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (height(node.left) - height(node.right) < -1) {
            if (height(node.right.left) - height(node.right.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            } else if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }
        }
        return node;
    }

    public static Node rightRotate(Node p) {

        Node c = p.left;
        Node t2 = c.right;

        c.right = p;
        p.left = t2;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    public static Node leftRotate(Node c) {

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
            insert(root, newNode);
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

        int leftHeight = (node.left == null) ? -1 : node.left.height;
        int rightHeight = (node.right == null) ? -1 : node.right.height;
        return Math.abs(leftHeight - rightHeight) <= 1 && checkBalance(node.left) && checkBalance(node.right);
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