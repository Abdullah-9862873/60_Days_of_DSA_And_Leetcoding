import java.util.Scanner;

public class Part_03_Binary_Search_Tree {
    public static Node root;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root element: ");
        root = new Node(input.nextInt());
        populate(input);
        System.out.println();
        display(root, "", false);
    }

    public static void populate(Scanner input){
        System.out.println("Do you want to insert a value: (yes/no)");
        String userChoice = input.next();
        if(userChoice.equalsIgnoreCase("yes")){
            System.out.println("Enter the value: ");
            int value = input.nextInt();
            Node newNode = new Node(value);
            insert(root, newNode);
            populate(input);
        }
    }

    public static void insert(Node root, Node node){
        if(root == null){
            return;
        }

        if(node.value < root.value && root.left != null){
            insert(root.left, node);
        }else if(node.value < root.value && root.left == null){
            root.left = node;
            return;
        }

        if(node.value > root.value && root.right != null){
            insert(root.right, node);
        }else if(node.value > root.value && root.right == null){
            root.right = node;
            return;
        }
    }

    public static void display(Node node, String str, boolean isLeft){
        if(node == null){
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + node.value);
        display(node.left, str + (isLeft ? "|   " : "    "), true);
        display(node.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
}
