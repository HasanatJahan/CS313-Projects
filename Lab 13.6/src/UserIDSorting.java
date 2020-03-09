import java.util.Scanner;
import java.util.ArrayList;

public class UserIDSorting {
    // TODO: Write the partitioning algorithm - pick the middle element as the
    //       pivot, compare the values using two index variables l and h (low and high),
    //       initialized to the l and h sides of the current elements being sorted,
    //       and determine if a swap is necessary
    public static int partition(ArrayList<String> userIDs, int i, int k) {
        //create a pivot
        int midIndex = (i + k)/2;
        String pivot = userIDs.get(midIndex);

        int l = i;
        int h = k;

        //compare the two pointers
        while(l <= h){

            //if the pivot is greater than the lStr then iterate the l pointer
            while(pivot.compareTo(userIDs.get(l)) > 0) l++;


            //if pivot is less than the hStr then iterate the h pointer
            while(pivot.compareTo(userIDs.get(h)) < 0) h--;

            //else, if the pointers don't overlap then swap values
            if( l <= h ){
                //swap values
                String temp = userIDs.get(l);
                userIDs.set(l, userIDs.get(h));
                userIDs.set(h, temp);
                l++;
                h--;
            }
        } //while
        //return the l pointer
        return l;
    } //partition method

    // TODO: Write the quicksort algorithm that recursively sorts the low and
    //       high partitions
    public static void quicksort(ArrayList<String> userIDs, int i, int k) {
        if(i >= k){ //base case
            return;
        }
        // find the partition index to call quicksort on
        int index = partition(userIDs, i, k);
        if( i < index-1 ){ //sort l half
            quicksort(userIDs, i, index - 1);
        }
        if( index < k ){ //sort the h half
            quicksort(userIDs, index, k);
        }
    } //quicksort

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        ArrayList<String> userIDList = new ArrayList<String>();

        String userID;

        userID = scnr.next();
        while (!userID.equals("-1")) {
            userIDList.add(userID);
            userID = scnr.next();
        }

        // Initial call to quicksort
        quicksort(userIDList, 0, userIDList.size() - 1);

        for (int i = 0; i < userIDList.size(); ++i) {
            System.out.println(userIDList.get(i));
        }
    }
}

