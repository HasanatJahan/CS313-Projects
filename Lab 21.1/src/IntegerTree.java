// This class represents a tree of integers
public class IntegerTree {
    private IntegerTreeNode root;

    // Constructs a tree
    public IntegerTree() {
        root = null;
    }
    // Getters
    public IntegerTreeNode getRoot() {
        return root;
    }
    // Setters
    public void setRoot(IntegerTreeNode node) {
        root = node;
    }
}