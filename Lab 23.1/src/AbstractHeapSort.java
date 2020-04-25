import java.util.LinkedHashMap;
import java.util.LinkedList;

public abstract class AbstractHeapSort<T extends Comparable <T>> {

    protected void bubbleDown(T arr[], int heapSize, int indexOfNodeToBubbleDown) {
        int largest = indexOfNodeToBubbleDown; // Initialize largest as root
        int leftChildIdx = 2 * indexOfNodeToBubbleDown + 1; // left = 2*indexOfNodeToBubbleDown + 1
        int rightChildIdx = 2 * indexOfNodeToBubbleDown + 2; // right = 2*indexOfNodeToBubbleDown + 2

        // If left child is larger than root
        if (leftChildIdx < heapSize && arr[leftChildIdx].compareTo(arr[largest]) > 0)
            largest = leftChildIdx;

        // If right child is larger than largest so far
        if (rightChildIdx < heapSize && arr[rightChildIdx].compareTo(arr[largest]) > 0)
            largest = rightChildIdx;

        // If largest is not root
        if (largest != indexOfNodeToBubbleDown) {
            T swap = arr[indexOfNodeToBubbleDown];
            arr[indexOfNodeToBubbleDown] = arr[largest];
            arr[largest] = swap;

            // Recursive call to  bubbleDown the root of the sub-tree
            bubbleDown(arr, heapSize, largest);
        }
    }

    public abstract void buildMaxHeap(T[] arr);

    public abstract LinkedHashMap<Integer, LinkedList<T>> levelMap(T arr[]);

    public abstract void sort(T arr[]);
}