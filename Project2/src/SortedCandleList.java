/**
 * The SortedCandleList class is an extension of the
 * CandleList class with an add method that adds the nodes
 * in order.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time TueThu 3:50PM-4:40PM
 */

public class SortedCandleList extends CandleList {
    public SortedCandleList(){
        super();
    }//one argument constructor

    /**
     * Method to add a new node in order in the sorted list
     * @param c: a new candle
     */
    public void add(Candle c){
        //create a new candleNode
        CandleNode newNode = new CandleNode(c);
        CandleNode current = first;
        while (current.next!=null && (current.next.data.getPrice()<newNode.data.getPrice())){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }//add
}