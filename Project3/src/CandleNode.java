/**
 * The CandleNode class allows the user to create
 * a node with data which is candle and a pointer to
 * the next candle
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time TueThu 3:50PM-4:40PM
 */

public class CandleNode {
    protected Candle data;
    protected CandleNode next;

    public CandleNode(Candle c){
        data = c;
        next = null;
    }//constructor
}//candleNode