import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DescendingOrder {
    public static void selectionSortDescendTrace(int [] numbers, int numElements) {
        for(int i = 0; i < numElements - 1; i++){
            int index = i;
            for(int j = i+1; j < numElements; j++){
                if(numbers[j] > numbers[index]){
                    index = j;
                }
            }//inner for loop

            int largerNumber = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = largerNumber;

            //now to print the progress
            for(int k = 0; k< numElements; k++){
                System.out.print(numbers[k] + " ");
            }
            System.out.println();
        }//outer for
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input, i = 0;
        int numElements = 0;
        int [] numbers = new int[10];

        String inputStr = scnr.next();
        while(!inputStr.equals("-1")){
            input = Integer.parseInt(inputStr);
            numbers[i] = input;
            inputStr = scnr.next();
            i++;
            numElements++;
        }//while

        //call the method
        selectionSortDescendTrace(numbers, numElements);
    }
}

