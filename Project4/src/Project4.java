import java.util.*;

/**
 * This program reads from a input file of data for candles,
 * fills one array of candles, creates two candle linked lists,
 * one unsorted and one sorted and displays them in a separate
 * window.
 *
 * @author Hasanat Jahan
 * @lab-section 11H Cuiyuan Wang
 * @lab-time TueThu 3:50PM-4:40PM
 */

public class Project4 {
    public static Candle[] allCandles;
    public static int candleCount;
    public static UnsortedCandleList unsortedList = new UnsortedCandleList();
    public static SortedCandleList sortedList = new SortedCandleList();

    public static void main(String [] args){
        new CandleGUI();
    }

}