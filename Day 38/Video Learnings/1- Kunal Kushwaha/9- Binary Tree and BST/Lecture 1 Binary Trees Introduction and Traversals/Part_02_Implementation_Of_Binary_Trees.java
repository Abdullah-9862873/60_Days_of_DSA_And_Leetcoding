/*
There are two ways to implement trees:
----> Linked Representation
----> Sequential Representation using Arrays

The sequential representation is not very efficient as you have to define the size of the array

Note:
----> The sequential representation of the trees will be used in the heap data structure because if we implement this here then as there can be cases in which there is a left child but there is no right child of a node then we have to leave the space of that index as null... So memory will get allocated but will be of no use... To solve this problem we will not implement the sequential representation of trees...

----> Also in segment trees which is strict binary tree we will use sequential representation using arrays...


*/

import java.util.Scanner;

public class Part_02_Implementation_Of_Binary_Trees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of root node: ");
        Node root = new Node(input.nextInt());
        populate(root, input);
        input.close();

        display(root, "",false);
    }

    public static void display(Node root, String prefix, boolean isLeft) {
        if(root == null){
            return;
        }
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.value);
        display(root.left, prefix + (isLeft ? "|   " : "    "), true);
        display(root.right, prefix + (isLeft ? "|   " : "    "), false);
    }
    

    public static void populate(Node node, Scanner input) {
        System.out.println("Do you want to enter the left node of " + node.value + " (yes/no): ");
        String leftChoice = input.next();
        if (leftChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = input.nextInt();
            node.left = new Node(value);
            populate(node.left, input);
        }
        System.out.println("Do you want to enter the right node of " + node.value + " (yes/no): ");
        String rightChoice = input.next();
        if (rightChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = input.nextInt();
            node.right = new Node(value);
            populate(node.right, input);
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
