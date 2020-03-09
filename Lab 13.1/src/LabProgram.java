import java.util.Scanner;
import java.util.Arrays;

public class LabProgram {

    public static void sortArray(int[] myArr, int arrSize){
        for( int i = 0; i < arrSize - 1 ; i++){
            for(int j = 0; j < arrSize - i - 1 ; j++){
                if(myArr[j] > myArr[j+1]){
                    int temp = myArr[j];
                    myArr[j] = myArr[j+1];
                    myArr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //read the input from the user
        Scanner scnr = new Scanner(System.in);
        int inputSize = scnr.nextInt();

        //create an array of the desired size
        int [] numArr = new int[inputSize];

        //populate the array the user input
        for(int i = 0; i < inputSize; i++){
            numArr[i] = scnr.nextInt();
        }

        //now to sort the array
        sortArray(numArr, inputSize);

        //now to print the array
        for(int i = 0; i < inputSize; i++){
            System.out.print(numArr[i] + " ");
        }
        System.out.println();


    }
}
