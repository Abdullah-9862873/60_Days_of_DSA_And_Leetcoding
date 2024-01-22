public class Part_05_Convert_Sorted_Array_To_Binary_Search_Tree {
    public static Node root;

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        root = makeBinarySearchTree(arr, 0, arr.length-1);
        displayBinaryTree();
        checkBalancing();
        System.out.println();

    }

    public static Node makeBinarySearchTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start) / 2;

        Node node = new Node(arr[mid]);
        node.left = makeBinarySearchTree(arr, start, mid-1);
        node.right = makeBinarySearchTree(arr, mid+1, end);

        node.height = Math.max(height(node.left),height(node.right)) + 1;
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
