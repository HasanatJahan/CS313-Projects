public abstract class AbstractBSTMap<K extends Comparable<K>, V> implements Map<K, V> { // K must be a class that implements Comparable
    public Entry<K, V> root;

    // Adds the specified key-value pair.
    // If the key is already in the map, the old value is replaced.
    public void put(K k, V v) {
        root = put(k, v, root);
    }

    // Adds the specified key-value pair and returns the root.
    private Entry<K, V> put(K k, V v, Entry<K, V> r) {
        if (r == null) return new Entry<>(k, v); // Key not found, so add the pair.
        int compare = k.compareTo(r.key);
        if (compare < 0)                    // If k < root.key, add it to the left subtree.
            r.left = put(k, v, r.left);
        else if (compare > 0)               // If k > root.key, add it to the right subtree.
            r.right = put(k, v, r.right);
        else
            r.value = v;                  // If the key is already in the map, replace the old value.
        return r;
    }

    // Removes the pair with the specified key.
    public void remove(K k) {
        root = remove(k, root);
    }

    // Removes the pair with the specified key and returns the root.
    private Entry<K, V> remove(K k, Entry<K, V> r) {
        if (root == null) return null;         // Key not found.
        int compare = k.compareTo(r.key);
        if (compare < 0)                       // If k < root.key, remove it from the left subtree.
            r.left = remove(k, r.left);
        else if (compare > 0)                  // If k > root.key, remove it from the left subtree.
            r.right = remove(k, r.right);
        else {                                            // If k == root.key,
            if (r.left == null) return r.right;      // Case with 0 or 1 subtree (right).
            else if (r.right == null) return r.left; // Case with 1 subtree (left).
            Entry<K, V> t = r.right;
            while (t.left != null) t = t.left;      // Case with 2 subtrees:
            r.key = t.key;                       // Replace root's pair with min-key pair in right subtree.
            r.value = t.value;
            r.right = remove(t.key, r.right); // Remove the min-key pair from right subtree.
        }
        return r;
    }
}