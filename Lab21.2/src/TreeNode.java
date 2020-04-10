// Class that represents a single node in the tree
public class TreeNode <T> {
    public T data; // data stored at this node
    public TreeNode<T> left; // reference to left subtree
    public TreeNode<T> right; // reference to right subtree

    // Constructs a leaf node with the given data.
    public TreeNode(T data) {
        this(data, null, null);
    }

    // Constructs a leaf or branch node with the given data and links.
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}