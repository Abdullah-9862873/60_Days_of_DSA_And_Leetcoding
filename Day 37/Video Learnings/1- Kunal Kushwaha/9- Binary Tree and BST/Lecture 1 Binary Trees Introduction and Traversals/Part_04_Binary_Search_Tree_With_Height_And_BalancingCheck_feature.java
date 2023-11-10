import java.util.Scanner;

public class Part_04_Binary_Search_Tree_With_Height_And_BalancingCheck_feature {
    public static Node root;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root element: ");
        root = new Node(input.nextInt());
        populate(input);
        System.out.println();
        display(root, "", false);

        boolean balanced = checkBalance(root);
        if(balanced){
            System.out.println("The binary search tree is balanced");
        }else{
            System.out.println("The binary search tree is not balanced");
        }
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
        }
        else if(node.value > root.value && root.right != null){
            insert(root.right, node);
        }else if(node.value > root.value && root.right == null){
            root.right = node;
        }

        root.height = Math.max(height(root.left),height(root.right));
    }

    public static void display(Node node, String str, boolean isLeft){
        if(node == null){
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + node.value);
        display(node.left, str + (isLeft ? "|   " : "    "), true);
        display(node.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static boolean checkBalance(Node node){
        if(node == null){
            return true;
        }

        int leftHeight = (node.left == null) ? -1 : node.left.height;
        int rightHeight = (node.right == null) ? -1 : node.right.height;
        return Math.abs(leftHeight - rightHeight) <= 1 && checkBalance(node.left) && checkBalance(node.right);
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public static class Node{
        int value;
        Node left;
        Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }
    }
}
