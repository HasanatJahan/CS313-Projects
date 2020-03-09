/**
 * The UnSortedCandleList class is an extension of the
 * CandleList class with an add method
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time TueThu 3:50PM-4:40PM
 */

public class UnsortedCandleList extends CandleList {
    public UnsortedCandleList(){
        super();
    }//one argument constructor

    /**
     * Method to add a new candle to the unsorted linked list
     * @param c: a candle
     */
    public void add(Candle c){
        append(c);
    }//add
}