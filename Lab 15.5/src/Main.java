import java.util.Iterator;
import java.util.LinkedList;

public class Main{
    public static void removeNegative(LinkedList <Integer> list){
        // initialize the iterator for the list using an iterator method
        Iterator<Integer> iter = list.iterator();
        // iterating through the list
        while(iter.hasNext()){
            //if negative then remove
            if(iter.next() < 0){
                iter.remove();
            } //if
        } //while
    }
}