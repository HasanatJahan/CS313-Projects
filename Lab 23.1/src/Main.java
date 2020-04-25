import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        // The default case tests on an array of Integers, but your code must work with all Comparable objects.
        int arr[] = {27, 60, 90, 72, 93, 88, 64, 68, 45, 87, 62, 59, 23, 53, 84, 50, 31, 28, 92, 61, 3, 69,
                91, 7, 52, 54, 18, 73, 1, 89, 36, 58, 44, 83, 13, 48, 15, 80, 5, 41};

        // cast the array of ints to an array of Integers
        Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        System.out.println("Original Array: " + Arrays.toString(boxedArray) + "\n");

        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.buildMaxHeap(boxedArray);

        //-----------------------
        System.out.println("This is what the maxHeap looks like " + boxedArray);
        for(int i = 0; i< boxedArray.length; i++){
            System.out.print(boxedArray[i] + " ");
        }
        //---------------------

        // There's levels to this heap.
        System.out.println(heapSort.levelMap(boxedArray).toString().replace("],", "],\n") + "\n");

        heapSort.sort(boxedArray);
        System.out.println("Heap Sorted: " + Arrays.toString(boxedArray));
    }
}