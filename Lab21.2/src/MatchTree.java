public class MatchTree <T extends Comparable<T>> extends Tree <T>{
    public MatchTree() {
        super();
    }

    // Used reference: https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
    //Method that constructs a countOddNodes Tree by inserting nodes in level order  -- it creates a generic array
    public TreeNode insertLevelOrder( T[] arr, TreeNode root, int i ){
        //base case for recursion
        if(i < arr.length){
            TreeNode temp = new TreeNode(arr[i]);
            root = temp; //setting a root for each level
            //insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            //insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        //else
        return root;
    }// insertLevelOrder method

    //Method to print the tree in order
    public void printInOrder(TreeNode root){
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    } //printInOrder

    //Reference: https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    // Function to print binary tree in 2D
    static final int COUNT = 10;
    // It does reverse inorder traversal
    public void print2DUtil(TreeNode root, int space){
        // Base case
        if (root == null) return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }


    // Reference: https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
    public int matches(TreeNode<T> root1, TreeNode<T> root2){
        //base case
        if(root1 == null || root2 == null) return 0;
        else if(root1.data.equals(root2.data)){
            return matches(root1.left, root2.left) + matches(root1.right, root2.right) + 1;
        }
        else {
            return matches(root1.left, root2.left) + matches(root1.right, root2.right);
        }
    }
}