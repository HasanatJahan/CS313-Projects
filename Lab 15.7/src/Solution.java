import java.util.Iterator;
import java.util.LinkedList;

public class Solution<T>{
    public int count(Iterator<T> itr, T find){
        int num = 0;

        T item; //hold the current iterable object to compare
        while(itr.hasNext()){
            item = itr.next();
            if(item.equals(find)){
                num++; //increment the counter
                itr.remove(); //remove the elem from the itr
            }
        } //while

        return num;
    } //count method
}