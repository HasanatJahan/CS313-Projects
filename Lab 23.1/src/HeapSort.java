import java.util.*;

public class HeapSort<T extends Comparable <T>> extends AbstractHeapSort<T> {
    // BUILD HEAP
    public void buildMaxHeap(T[] arr) {
        // Insert code here to organize the array as a max-heap.
        // This should be done by repeatedly calling on the `bubbleDown()` code which is provided to you.
        // You do not need to and should not call bubbleDown() on every single element of the array. Do you see why?

        int arrLength = arr.length;
        for(int i = arrLength/2 - 1; i > 0 ; i--){
            //repeatedly call bubbleDown until it it creates a max-heap
            bubbleDown(arr, arrLength, i); //this basically carries out the heapify operation
        }//for

    }//buildMaxHeap


    //helper method to populate linkedlist in the linkedhashmap
    public LinkedList<T> populateLinkedList(T arr[], int i){
        LinkedList<T> result = new LinkedList<>();
        return null;
    }//populateLinkedList


    // PRINT LEVELS OF HEAP
    public LinkedHashMap<Integer, LinkedList<T>> levelMap(T arr[]) {
        // Insert code here to return a LinkedHashMap listing each level of the heap, level by level.
        // The `key` of the LinkedHashMap should be the level of the Heap.
        // The `value` of the LinkedHashMap should be a LinkedList with the nodes at that level (in order from left to right).

        LinkedHashMap<Integer, LinkedList<T>> treeLevels = new LinkedHashMap<Integer, LinkedList<T>>();

        //populate the hash map
        int i = 0; //this represents the levels
        int j = 1; //this is the index we use to traverse
        int m = 1;
        //calculate the log base of levels
        double level = Math.log(arr.length)/ Math.log(2);

        while (i < level){
            LinkedList <T> nodes = new LinkedList<>(); //create the list yet again
            if(i == 0) {
                nodes.add(arr[i]);
            }//if
            else {
                System.out.println("Value of m is " + m + " and i is " + i);
                while(j <= m*2 && m*2 < arr.length){
                    nodes.add(arr[j]);
                    j++;
                }//while
                m = m * 2 ;
            } //else
            treeLevels.put(i, nodes);
//            m = m * 2 ;
            i++;
        }//while

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