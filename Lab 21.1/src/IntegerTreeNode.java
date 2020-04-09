// Class that represents a single node in the tree
public class IntegerTreeNode {
    public int data; // data stored at this node
    public IntegerTreeNode left; // reference to left subtree
    public IntegerTreeNode right; // reference to right subtree

    // Constructs a leaf node with the given data.
    public IntegerTreeNode(int data) {
        this(data, null, null);
    }

    // Constructs a leaf or branch node with the given data and links.
    public IntegerTreeNode(int data, IntegerTreeNode left, IntegerTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}