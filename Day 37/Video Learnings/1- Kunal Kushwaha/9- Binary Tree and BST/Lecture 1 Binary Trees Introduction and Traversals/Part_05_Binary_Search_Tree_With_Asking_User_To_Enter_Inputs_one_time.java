import java.util.Scanner;

public class Part_05_Binary_Search_Tree_With_Asking_User_To_Enter_Inputs_one_time {
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
            if(i == 0){
                System.out.println("Enter the first and the root value of binary search tree");
            }else{
                System.out.println("Enter the " + (i + 1) + " value of binary search tree");
            }
            userInputs[i] = input.nextInt();
        }
        populate(userInputs);
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

    public static void populate(int[] userInputs) {
        if (userInputs.length >= 1) {
            root = new Node(userInputs[0]);
        }
        for (int i = 1; i < userInputs.length; i++) {
            Node value = new Node(userInputs[i]);
            root = insert(root, value);
        }
    }

    public static Node insert(Node root, Node node) {
        if (root == null) {
            return node;
        }

        if(node.value < root.value){
            root.left = insert(root.left, node);
        }else if(node.value > root.value){
            root.right = insert(root.right, node);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return root;
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

/*
There is a problem with this method that if the array is sorted then it will create a tree like the following
            1
             \
              2
               \
                3
                 \
                  4
                   \
                    5

So the insertion in the tree is taking the time complexity more than log(n) and is taking linear time complexity which kills the purpose of the tree... To fix this problem of not making degenerate/skewed binary tree is by using AVL or self balancing tree... 
That will be done in the second lecture... But a simle approach can be take the middle element and divide it in two parts

Example you have the following array 
[1,2,3,4,5,6,7,8,9,10]

Then the tree made using the middle element approach should be like

                                               5
                                            /    \
                                          2       8
                                         / \     / \
                                        1   3   6   9
                                             \   \   \
                                              4   7   10

                                                
 */
