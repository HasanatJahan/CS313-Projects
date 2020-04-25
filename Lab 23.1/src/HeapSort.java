import java.util.*;

public class HeapSort<T extends Comparable <T>> extends AbstractHeapSort<T> {
    // BUILD HEAP
    public void buildMaxHeap(T[] arr) {
        // Insert code here to organize the array as a max-heap.
        // This should be done by repeatedly calling on the `bubbleDown()` code which is provided to you.
        // You do not need to and should not call bubbleDown() on every single element of the array. Do you see why?

        int arrLength = arr.length;
        for(int i = arrLength/2 ; i >= 0 ; i--){
            //repeatedly call bubbleDown until it it creates a max-heap
            bubbleDown(arr, arrLength, i); //this basically carries out the heapify operation
        }//for

    }//buildMaxHeap

    //helper methods to show the left, right and parent
    int left(int i){
        return 2 * i + 1;
    }
    int right(int i){
        return 2 * i + 2;
    }
    int parent(int i){
        return (i - 1)/2;
    }

    // Used resource: https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
    // Resource: https://www.geeksforgeeks.org/level-order-tree-traversal/
    // PRINT LEVELS OF HEAP
    public LinkedHashMap<Integer, LinkedList<T>> levelMap(T arr[]) {
        // Insert code here to return a LinkedHashMap listing each level of the heap, level by level.
        // The `key` of the LinkedHashMap should be the level of the Heap.
        // The `value` of the LinkedHashMap should be a LinkedList with the nodes at that level (in order from left to right).

        //resource: https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
        LinkedHashMap<Integer, LinkedList<T>> treeLevels = new LinkedHashMap<Integer, LinkedList<T>>();
        Queue<T> queue = new LinkedList<>();
        queue.add(arr[0]); //add the root
        int level = 0;

        double traversalLevel = Math.log(arr.length) / Math.log(2);

        while (level < traversalLevel){
            LinkedList <T> nodes = new LinkedList<>(); //create the list yet again

            while(!queue.isEmpty()){
                //new linked list at each level

                T tempNode = queue.poll(); //this removes the current element
                //now add the temp node to the linked list
                nodes.add(tempNode);

                if(left(level) < arr.length){
                    queue.add(arr[left(level)]);
                }

                if (right(level) < arr.length){
                    queue.add(arr[right(level)]);
                }

            }
            level++; //increase the level
            treeLevels.put(level, nodes);
        }


        return treeLevels;
    }


    // SORT
    public void sort(T arr[]) {
        // Complete the `sort()` method that
        //   - One by one extracts the maximum element from the heap and replaces it with the last element in the array.
        //   - Calls `bubbleDown()` to bubble down the new root of the reduced heap.
        //   - Repeats these steps until the reduced heap is empty.

        buildMaxHeap(arr); //first create a max heap
        for(int i = arr.length - 1 ; i > 0; i--){
            //extract the maximum elem
            T max = arr[0];
            T temp = max;
            arr[0] = arr[i];
            arr[i] = max;
            //bubble down on the reduced heap
            bubbleDown(arr, i, 0);
        }//for

    }


}