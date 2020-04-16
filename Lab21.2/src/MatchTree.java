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
    private int matches(TreeNode<T> root1, TreeNode<T> root2){
        //base case
        if(root1 == null || root2 == null) return 0;
        else if(root1.data.equals(root2.data)){
            return matches(root1.left, root2.left) + matches(root1.right, root2.right) + 1;
        }
        else {
            return matches(root1.left, root2.left) + matches(root1.right, root2.right);
        }
    } //matches- private two parameters

    //method with one parameter
    public int matches (TreeNode<T> root2){
        return matches(this.getRoot(),root2);
    }//matches - one parameter


    //    //This should return the number of matches in the tree
    //    public int matches(TreeNode<T> root2) {
    //        //this keeps the count of the matches
    //        int count = 0;
    //        TreeNode<T> root1 = this.getRoot();
    //        //base case
    //        if (root1 == null || root2 == null) {
    //            return 0;
    //        }
    //
    //        //create two stacks to store the nodes from both trees
    //        Stack<TreeNode<T>> stack1 = new Stack<TreeNode<T>>();
    //        Stack<TreeNode<T>> stack2 = new Stack<TreeNode<T>>();
    //
    //        //variables to store data to make comparison
    //        T data1;
    //        T data2;
    //
    //        while (true) {
    //            //root1 traversal to populate stack1
    //            while (root1 != null) {
    //                stack1.push(root1);
    //                root1 = root1.left; //left first
    //            }//root1 traversal
    //
    //            //root2 traversal to populate stack2
    //            while (root2 != null) {
    //                stack2.push(root2);
    //                root2 = root2.left;
    //            }//root2 traversal
    //
    //            if (stack1.empty() || stack2.empty()) break; //to break out true while loop
    //
    //            data1 = stack1.peek().data;
    //            data2 = stack2.peek().data;
    //
    //            //this checks if they are the same
    //            if (data1.equals(data2)) {
    ////                if (this.getLevel(data1, 0) == this.getLevel(data2, 0)) {
    ////                    count++;
    ////                }
    //                count++; //increment the count
    //                root1 = stack1.peek().right;
    //                root2 = stack2.peek().right;
    //                stack1.pop();
    //                stack2.pop();
    //            }// if checking
    //        } //while true
    //        return count;
    //    }


} //MatchTree Class