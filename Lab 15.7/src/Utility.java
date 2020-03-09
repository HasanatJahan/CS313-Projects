import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Utility{
    public static void main(String [] args) {
        //Variables
        LinkedList<Integer> list = new LinkedList<Integer>();
        Solution<Integer> sol = new Solution<Integer>();
        int arr[] = {-3,-5,3,-8,44,64,26,87,6,-77,-23}; // Default
        int find = -8;
        Scanner scnr = new Scanner(System.in);
        //Writes to list if input exists
//        if(scnr.hasNext()){
//            find = scnr.nextInt();
//            if(scnr.hasNext())
//                while(scnr.hasNext())
//                    list.add(scnr.nextInt());
//        }
//        //Else, add default values
//        else
            for(int i : arr)
                list.add(i);
        System.out.println(sol.count(list.iterator(), find));
    }
}