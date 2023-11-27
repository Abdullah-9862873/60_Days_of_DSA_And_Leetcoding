import java.util.Arrays;

public class Part_10_Construct_Binary_Tree_from_PreOrder_and_InOrder {
    public static Node root;
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        root = constructBinaryTree(preOrder, inOrder);

        System.out.println();
        displayBinaryTree();
        checkBalancing();
        System.out.println();
    }

    public static Node constructBinaryTree(int[] preOrder, int[] inOrder){
        if(preOrder.length == 0 && inOrder.length == 0){
            return null;
        }
        
        Node node = new Node(preOrder[0]);
        // Find this node value in inOrder
        int index = -1;
        for(int i=0; i<inOrder.length; i++){
            if(inOrder[i] == node.value){
                index = i;
                break;
            }
        }
        node.left = constructBinaryTree(Arrays.copyOfRange(preOrder,1, index+1), Arrays.copyOfRange(inOrder,0,index));
        node.right = constructBinaryTree(Arrays.copyOfRange(preOrder,index+1,preOrder.length), Arrays.copyOfRange(inOrder,index+1,inOrder.length));

        return node;
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
