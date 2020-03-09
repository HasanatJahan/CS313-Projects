/**
 * The CandleList class allows the user to create a
 * linked list of candles comprising of a first node, a
 * last node and the length of a candleList.
 * It has an append method and a get method for length.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time TueThu 3:50PM-4:40PM
 */

public abstract class CandleList {
    //first node in linked list is a dummy node
    protected CandleNode first;
    //last node in the linked list
    protected CandleNode last;
    //number of items in the list
    protected int length;

    public CandleList(){
        first = new CandleNode(null);
        last = first;
        length = 0;
    }//no argument constructor

    /**
     * The append method adds a new node to the
     * CandleList
     * @param c: this is a candle object
     */
    public  void append(Candle c){
        CandleNode newNode = new CandleNode(c);
        last.next = newNode;
        last = newNode;
        length++;
    }//append

    /**
     * Method to get the length of the linked list
     */
    public int getLength(){
        return length;
    }

}