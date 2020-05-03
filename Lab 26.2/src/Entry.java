public class Entry<K extends Comparable<K>, V> {
    K key;
    V value;
    Entry<K, V> left = null, right = null;

    Entry(K k, V v) {
        key = k;
        value = v;
    }
}
