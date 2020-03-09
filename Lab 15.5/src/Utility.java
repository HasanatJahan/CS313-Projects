import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Utility extends Main{
    public static void main(String [] args) {
        //Variables
        LinkedList<Integer> list = new LinkedList<Integer>();
        int arr[] = {-3,-5,3,-8,44,64,26,87,6,-77,-23}; // Default
        Scanner scnr = new Scanner(System.in);
        //Writes to list if input exists
//        if(scnr.hasNext())
//            while(scnr.hasNext())
//                list.add(scnr.nextInt());
            //Else, add default values
//        else
            for(int i : arr)
                list.add(i);
        removeNegative(list);
        System.out.println(list);
    }
}