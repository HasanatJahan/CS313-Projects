public class countOddNodes extends IntegerTree {
    private IntegerTreeNode overallRoot;

    //constructors
    public countOddNodes() {
        super();
    }

    // Helper method returns the overall answer after traversing the tree
    public int oddInternalNodes(){
        return oddInternalNodes(overallRoot);
    } //oddInternalNode-helper

    // Method counts the number of odd nodes in the tree
    public int oddInternalNodes(IntegerTreeNode root){
        //base case
        if(root == null) {
            return 0;
        }
        else if( root.data % 2 != 0 ){
            return 1 + oddInternalNodes(root.left) + oddInternalNodes(root.right);
        }
        else{
            return oddInternalNodes(root.left) + oddInternalNodes(root.right);
        }
    } //oddInternalNode


    // Used reference: https://www.geeksforgeeks.org/construct-complete-binary-tree-given-array/
    //Method that constructs a countOddNodes Tree by inserting nodes in level order
    public IntegerTreeNode insertLevelOrder(int [] arr, IntegerTreeNode root, int i ){
        //base case for recursion
        if(i < arr.length){
            IntegerTreeNode temp = new IntegerTreeNode(arr[i]);
            root = temp; //setting a root for each level
            //insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            //insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        //else
        return root;
    }// insertLevelOrder method


    //Ok lets see what the tree looks like -
    // Note: print seems to be working
    public void printInOrder(IntegerTreeNode root){
        if(root != null){
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }


}