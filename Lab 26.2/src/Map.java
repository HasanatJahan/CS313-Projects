public interface Map<K, V> {
    // Adds the given element to the set if it's not already added.
    void put(K k, V v);

    // Removes the given element from the set.
    void remove(K k);

    // Returns true if the given element is in the set.
    boolean containsKey(K k);
}