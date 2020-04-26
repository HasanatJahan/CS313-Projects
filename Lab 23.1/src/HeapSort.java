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
        queue.add(arr[0]); //add the root to make nodeCount 1

        int level = 0;
        int i = 0; //this tracks of node number
        while(true){
            //number of nodes at the current level
            int nodeCount = queue.size(); //this shows the count
            if(nodeCount == 0 ) break; //the other statement was nodeCount >= arr.length ||||  i >= arr.length
            LinkedList <T> nodes = new LinkedList<>(); //create the list yet again

            //this should differentiate between the levels
            while(nodeCount > 0){ //while there is still an element in the queue
                T tempNode = queue.peek(); //the front element in the front of queue
                nodes.add(tempNode); //add the node to the linked list
                queue.remove(); //this removes the head of the queue
                //now to add the nodes of the next level from the left subtree and the right subtree
                if(left(i) < arr.length){
                    queue.add(arr[left(i)]);
                }
                if(right(i) < arr.length){
                    queue.add(arr[right(i)]);
                }
                i++;
                nodeCount--;
            } //while - inner
            treeLevels.put(level, nodes); //create the tree
            level++;
        } //while - outer
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