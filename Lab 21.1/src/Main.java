import java.util.*;

public class Main {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);

        // Note: you need to add elems to the binary tree recursively


        int [] numArr = new int[2000];
        int count = 0;
        boolean isDefault = false; //flag to check if default case has been used
        countOddNodes binaryTree = new countOddNodes();

        //Custom Test Case

//        if(scnr.hasNext()){
//            //first count the number of inputs and add each to an array
//            count++;
//            numArr[count] = scnr.nextInt();
//        }
//        // default test case to populate the output
//        else {
            //Variables
            int [] defaultArr = {33,45,2,21,46,3,1,32,11,211,10};
            //go through the array and define the tree
            for(int i = 0; i < defaultArr.length; i++){
                if(i == 0){
                    IntegerTreeNode rootNode = new IntegerTreeNode(defaultArr[0]);
                    binaryTree.setRoot(rootNode);
                }else if( i == defaultArr.length-1){
                    new IntegerTreeNode(defaultArr[defaultArr.length-1], new IntegerTreeNode(defaultArr[defaultArr.length-2]), null);
                }else{
                    new IntegerTreeNode(defaultArr[i], new IntegerTreeNode(defaultArr[i-1]), new IntegerTreeNode(defaultArr[i+1]));
                }
            }

            isDefault = true;
//        } //else

        //now to do the custom case to populate the binary tree if not default
        if(!isDefault){
            for(int i = 0; i <= count; i++){
                for(int j = 0; j < numArr.length; j++){
                    if(j == 0){
                        IntegerTreeNode rootNode = new IntegerTreeNode(numArr[0]);
                        binaryTree.setRoot(rootNode);
                    }else if( j == numArr.length-1){
                        new IntegerTreeNode(numArr[numArr.length-1], new IntegerTreeNode(numArr[numArr.length-2]), null);
                    }else{
                        new IntegerTreeNode(numArr[j], new IntegerTreeNode(numArr[j-1]), new IntegerTreeNode(numArr[j+1]));
                    }
                }
            }
        } //isDefault


        //now to run the function
        System.out.println(binaryTree.oddInternalNodes());

    }
}