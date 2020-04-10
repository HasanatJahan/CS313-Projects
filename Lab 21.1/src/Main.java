import java.util.*;

public class Main {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);

        int [] numArr = new int[2000];
        int count = 0;
        boolean isDefault = false; //flag to check if default case has been used
        countOddNodes binaryTree = new countOddNodes(); //define the integernodetree to countOddNodes

        //Custom Test Case
//        if(scnr.hasNext()){
//            //first count the number of inputs and add each to an array
//            while (scnr.hasNext()){
//                numArr[count] = scnr.nextInt();
//                ++count;
//            }
//        }
//        // default test case to populate the output
//        else {
            //Variables
            int [] defaultArr = {33, 45, 2, 21, 46, 2, 2, 2, 3, 1, 32, 11, 211, 10}; //this should return 5
            //go through the array and define the tree
            binaryTree.setRoot(binaryTree.insertLevelOrder(defaultArr, binaryTree.getRoot(), 0));
            isDefault = true;
//        } //else

        //do the custom case to populate the binary tree if not the default input
        if(!isDefault){
            //copy over from the numArr to the correctly sized arr is necessary
            int [] inputArr = new int[count];
            for(int i = 0; i < count; i++){
                inputArr[i] = numArr[i];
            }

            //now to perform tree population
            binaryTree.setRoot(binaryTree.insertLevelOrder(inputArr, binaryTree.getRoot(), 0));
        } //isDefault

        binaryTree.printInOrder(binaryTree.getRoot());
        System.out.println();
        //now to run the function
        System.out.println(binaryTree.oddInternalNodes(binaryTree.getRoot()));

    }
}