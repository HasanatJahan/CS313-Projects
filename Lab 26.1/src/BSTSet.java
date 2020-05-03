import java.util.*;

// E must be a class that implements Comparable
public class BSTSet<E extends Comparable<E>> extends AbstractBSTSet<E> {
    /* **************************************************
     *
     *    You are provided the following attribute
     *    and implemented methods from AbstractBSTSet:
     *
     *    public Node<E> root;
     *    public void add(E e){};
     *    public void remove(E e) {};
     *
     * **************************************************/

    // Construct a new empty set
    public BSTSet() {
        //duplicates in BST are not allowed so HashSet
        HashSet<E> BST = new HashSet<E>();
    }

    // Returns true if the set contains the specified element.
    public boolean contains(E e) {
        return contains(e, root);
    }
    // Returns true if the set contains the specified element.
    // Reference: class slides
    private boolean contains(E e, Node<E> root) {
        if( root == null ) return false;
        if(e.compareTo(root.data) == 0){
            return true;
        }
        // key < root.key
        if( e.compareTo(root.data) < 0 ){
            return contains(e, root.left);
        }
        // key > root.key
        if( e.compareTo(root.data) > 0){
            return contains(e, root.right);
        }
        return false;
    }

    // Reference: https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
    // Returns the minimum element in the BST
    public E minimum(Node<E> root) {
        Node <E> current = root;
        while ( current.left != null){
            current = current.left;
        }
        return current.data;
    }

    //Returns the maximum value for root in BST
    public E maximum(Node<E> root){
        Node<E> current = root;
        while (current.right != null){
            current = current.right;
        }
        return current.data;
    }

    // Reference: https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
    // Returns the number of edges in the longest path from root to leaf
    public int height(Node<E> root) {
        // Implement the body of this method
        if( root == null ) return -1;

        int leftHeight = height(root.left) ; //traverse through the left
        int rightHeight = height(root.right) ; //traverse through the right

        //then use the larger one
        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }else{
            return rightHeight + 1;
        }

    }

    // Returns true if the compared trees have the exact same structure
    // Reference: https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
    public boolean sameTree(Node<E> root1, Node<E> root2) {
        if(root1 == null && root2 == null) return true;
        if( root1 != null && root2 != null ) {
            return ((root1.data == root2.data) &&
                    sameTree(root1.left, root2.left) &&
                    sameTree(root1.right, root2.right));
        }
        //in other cases
        return false;
    } //sameTree

    // Returns true if the given root belongs to a BST
    // Reference:
    // https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public boolean isBST(Node<E> root) {
        if ( root == null ) return true;
        // keep going left and comparing if the left elem is smaller than its root
        if( root.left != null && maximum(root.left).compareTo(root.data) > 0 ){
            return false;
        }
        // keep going right and comparing if the right elem is larger than its root
        if( root.right != null && maximum(root.right).compareTo(root.data) < 0 ){
            return false;
        }
        // recursive call return false
        if(!isBST(root.left) || !isBST(root.right)){
            return false;
        }
        return true;
    }

    // Performs a right rotation and returns the new root of the subtree.
    // Reference: https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
    public Node<E> rotateRight(Node<E> root) {
        Node <E> rootLeft = root.left;
        Node <E> rootLeftRight = rootLeft.right;

        // perform the rotation
        rootLeft.right = root;
        root.left = rootLeftRight;

        return  rootLeft;
    } //rotateRight

    // Reference: https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
    public ArrayDeque<ArrayList<E>> levelDeque(Node<E> root) {
        ArrayDeque<ArrayList<E>> result = new ArrayDeque<ArrayList<E>>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (true){
            int nodeCount = queue.size();
            if(nodeCount == 0 ) break;
            //create a new empty arraylist each time
            ArrayList<E> nodes = new ArrayList<>();

            // dequeue nodes of the current level and enqueue nodes of the next level
            while (nodeCount > 0 ){
                Node<E> node = queue.peek();
                nodes.add(node.data);
                queue.remove();

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null)
                    queue.add(node.right);
                nodeCount--;
            }
            //add to the arraudeque
            result.add(nodes);
        } //while - true
        return result;
    }
}