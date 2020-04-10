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

        //Custom Test Case
        if(scnr.hasNext()){
            while (scnr.hasNext()){
                numArr1[count1] = scnr.nextInt();
                count1++;
            }
            //Writes to list if input exists
            if(scnr.hasNext())
                while(scnr.hasNext()){
                    numArr2[count2] = scnr.nextInt();
                    count2++;
                }

        }

        else{
            //Default Arrays
            Integer [] defaultArr1 = {33,45,2,21,46,3,1,32,11,211,10},
                    defaultArr2 = {32,46,3,21,45,2,1,31,47,11,211,10};

            isDefault = true;
            //create two trees from the default array
            tree1.setRoot(tree1.insertLevelOrder(defaultArr1, tree1.getRoot(), 0));
            tree2.setRoot(tree2.insertLevelOrder(defaultArr2, tree2.getRoot(), 0));
        }

        if(!isDefault){
            Integer[] inputArr1 = new Integer[count1];
            Integer[] inputArr2 = new Integer[count2];
            //populate the input arrays
            for(int i = 0; i < count1; i++){
                inputArr1[i] = numArr1[i];
            }

            for(int i = 0; i < count2; i++){
                inputArr1[i] = numArr1[i];
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