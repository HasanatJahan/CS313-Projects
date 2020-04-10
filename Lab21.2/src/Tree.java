// This class represents a tree of integers
public class Tree <T> {
    private TreeNode<T> root;

    // Constructs a tree
    public Tree() {
        root = null;
    }
    // Getters
    public TreeNode<T> getRoot() {
        return root;
    }
    // Setters
    public void setRoot(TreeNode<T> node) {
        root = node;
    }
}