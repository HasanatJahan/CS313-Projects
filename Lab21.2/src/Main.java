import java.util.*;

public class Main {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);

        Integer [] numArr1 = new Integer[1000];
        Integer [] numArr2 = new Integer[1000];
        boolean isDefault = false; //flag to check if default case has been used
        MatchTree tree1 = new MatchTree();
        MatchTree tree2 = new MatchTree();

        int count1 = 0;
        int count2 = 0;

        //Reference: https://stackoverflow.com/questions/18838781/converting-string-array-to-an-integer-array
        //Custom Test Case
        String [] stringsArr;
        String userInput;
        int trackerNum = 1;

        if(scnr.hasNext()){
            while(scnr.hasNext()){
                userInput = scnr.nextLine();

                stringsArr = userInput.split(" ");

                if(trackerNum == 1){
                    for(int i = 0; i < stringsArr.length; i++){
                        numArr1[i] = Integer.valueOf(stringsArr[i]);
                        count1++;
                    }
                    trackerNum++; //modify the trackerNum
                }
                else {
                    for(int i = 0; i < stringsArr.length; i++){
                        numArr2[i] = Integer.valueOf(stringsArr[i]);
                        count2++;
                    }
                }
            } //while
        } //if

        else{
            //Default Arrays
            Integer [] defaultArr1 = {33,45,2,21,46,3,1,32,11,211,10},
                    defaultArr2 = {32,46,3,21,45,2,1,31,47,11,211,10};

            isDefault = true;
            //create two trees from the default array
            tree1.setRoot(tree1.insertLevelOrder(defaultArr1, tree1.getRoot(), 0));
            tree2.setRoot(tree2.insertLevelOrder(defaultArr2, tree2.getRoot(), 0));
        } //else


        if( !isDefault ){
            System.out.println("Is it coming here");
            System.out.println("count1 " + count1);
            System.out.println("count2 " + count2);

            Integer[] inputArr1 = new Integer[count1];
            Integer[] inputArr2 = new Integer[count2];
            //populate the input arrays
            for(int i = 0; i < count1; i++){
                System.out.println("what about the first for loop ");
                inputArr1[i] = numArr1[i];
                System.out.println("This is inputArr1 item " + i + " " + inputArr1[i] );
            }

            for(int i = 0; i < count2; i++){
                System.out.println("what about the first for loop ");
                inputArr2[i] = numArr2[i];
                System.out.println("This is inputArr2 item " + i + " " + inputArr2[i] );
            }

            //create two trees from the input
            tree1.setRoot(tree1.insertLevelOrder(inputArr1, tree1.getRoot(), 0));
            tree2.setRoot(tree2.insertLevelOrder(inputArr2, tree2.getRoot(), 0));

        }


        // testing
        System.out.println("Tree1 root " + tree1.getRoot().data);
        System.out.println("Tree 1 ");
        tree1.printInOrder(tree1.getRoot());
        System.out.println();
        tree1.print2DUtil(tree1.getRoot(), 0);
        System.out.println("Tree 2 ");
        tree2.printInOrder(tree2.getRoot());
        System.out.println();
        tree2.print2DUtil(tree2.getRoot(), 0);
        //testing the matches
        System.out.println("The number of matches is " + tree1.matches(tree1.getRoot(), tree2.getRoot()));

    }
}