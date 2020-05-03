import java.util.*;

// Reference: Last lab : 26.1
public class BSTMap<K extends Comparable<K>, V> extends AbstractBSTMap<K, V> { // K must be a class that implements Comparable
    /* **************************************************
     *
     *    You are provided the following attribute
     *    and implemented methods from AbstractBSTSet:
     *
     *    public Entry<K,V> root;
     *    public void put(K k, V v){};
     *    public void remove(K k) {};
     *
     * **************************************************/
    // Construct a new empty map.
    public BSTMap() {
        TreeMap<K, V> BST = new TreeMap<>();
    }

    // Returns true if the map contains the specified key.
    public boolean containsKey(K k) {
        return containsKey(k, root);
    }

    // TODO: implement this method
    private boolean containsKey(K k, Entry<K, V> root) {
        if( root == null ) return false;
        if( k.compareTo(root.key) == 0 ) return true;
        if( k.compareTo(root.key) < 0 ) return containsKey(k, root.left);
        if( k.compareTo(root.key) > 0 ) return containsKey(k, root.right);
        return false;
    } //containsKey

    // Returns maximum value in BST
    public K maximum(Entry<K, V> root) {
        Entry<K,V> current = root;
        while (current.right != null){
            current = current.right;
        }
        return current.key;
    }

    // Calculates height of the BST
    public int height(Entry<K,V> root) {
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

    // Verifies the structure is a BST
    public boolean isBST(Entry<K, V> root) {
        if( root == null ) return true;
        if( root.left != null && maximum(root.left).compareTo(root.key) > 0){
            return false;
        }
        if( root.right != null && maximum(root.right).compareTo(root.key) < 0){
            return false;
        }
        if(!isBST(root.left) || !isBST(root.right)){
            return false;
        }
        return true;
    }

    public boolean sameTree(Entry<K,V> root1, Entry<K,V> root2) {
        if( root1 == null && root2 == null ) return true;
        if( root1 != null && root2 != null ) {
            return ((root1.key == root2.key) &&
                    sameTree(root1.left, root2.left) &&
                    sameTree(root1.right, root2.right));
        }
        //in other cases
        return false;
    }

    // Performs a right rotation and returns the new root of the subtree.
    // Reference: https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
    public Entry<K,V> rotateLeft(Entry<K,V> root) {
        Entry<K, V> rootRight = root.right;
        Entry<K, V> rootRightLeft = rootRight.left;

        //perform the rotation
        rootRight.left = root; //this is the new root
        root.right = rootRightLeft;

        return rootRight;
    }

    public ArrayDeque<ArrayList<K>> levelDeque(Entry<K,V> root) {
        ArrayDeque<ArrayList<K>> result = new ArrayDeque<ArrayList<K>>();
        Queue<Entry<K, V>> queue = new LinkedList<>();
        queue.add(root);

        while (true){
            int nodeCount = queue.size();
            if(nodeCount == 0 ) break;
            //create a new empty arraylist each time
            ArrayList<K> nodes = new ArrayList<>();

            // dequeue nodes of the current level and enqueue nodes of the next level
            while (nodeCount > 0 ){
                Entry<K, V> node = queue.peek();
                nodes.add(node.key);
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
