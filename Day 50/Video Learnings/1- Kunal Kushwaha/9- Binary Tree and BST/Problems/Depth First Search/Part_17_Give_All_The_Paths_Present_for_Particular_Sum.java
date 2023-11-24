import java.util.*;

public class Part_17_Give_All_The_Paths_Present_for_Particular_Sum {
    public static Node root;

    public static void main(String[] args) {
        makeBinaryTree();
        displayBinaryTree();
        checkBalancing();
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of sum: ");
        int sum = input.nextInt();
        input.close();

        int ans = calcNoOfPathsExist(root,sum);
        System.out.println("The path exists for sum " + sum + " are: " + ans);

        List<List<Integer>> paths = giveAllPaths(root,sum);
        for(List<Integer> list: paths){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> giveAllPaths(Node root, int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper2(root, sum, path, paths);
        return paths;
    }
    public static void helper2(Node root, int target,List<Integer> path ,List<List<Integer>> paths){
        if(root == null){
            return;
        }
        path.add(root.value);
        int sum = 0;

        //how many paths do I have over here
        for(int i=path.size()-1; i>=0; i--){
            int val = path.get(i);
            sum += val;
            if(sum == target){
                // Make a copy of list from index list.size()-1 to i included and add that list in my ans
                paths.add(new ArrayList<>(path.subList(i, path.size())));
            }
        }

        helper2(root.left, target,path, paths);
        helper2(root.right, target,path, paths);

        path.remove(path.size()-1);

        return;
    }

    public static int calcNoOfPathsExist(Node root, int sum){
        List<Integer> list = new ArrayList<>();
        int ans = helper(root, sum, list);
        return ans;
    }
    public static int helper(Node root, int target, List<Integer> list){
        if(root == null){
            return 0;
        }
        list.add(root.value);
        int sum = 0;
        int count = 0;

        // how many paths can I make here add them to count
        for(int i=list.size()-1; i>=0; i--){
            int val = list.get(i);
            sum+= val;
            if(sum == target){
                count++;
            }
        }

        count += helper(root.left, target, list) + helper(root.right, target, list);

        // backtrack
        list.remove(list.size()-1);
        return count;
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
