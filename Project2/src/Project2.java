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

public class Project2 {
    public static TextFileInput inputFile;
    public static Candle[] allCandles;
    public static int candleCount;

    public static void main(String [] args){
        UnsortedCandleList unsortedList = new UnsortedCandleList();
        SortedCandleList sortedList = new SortedCandleList();
        String myFile = "input.txt";
        inputFile = new TextFileInput(myFile);
        allCandles = new Candle[100];
        candleCount = 0;

        //fill up the allCandles array
        fillArray(inputFile);

        //read from the array and add it to the two linked lists
        for(int i=0; i<candleCount; i++){
            Candle c = allCandles[i];
            unsortedList.add(c);
            sortedList.add(c);
        }

        //now do display the two linked lists
        new CandleGUI(unsortedList, sortedList);
    }

    /**
     *  Method to change the number of candles and
     *  fill up the candle details array
     * @param input: the TextFileInput to read the values from
     */
    public static void fillArray(TextFileInput input){
        String line = input.readLine();
        while(line!=null){
            StringTokenizer cTokens = new StringTokenizer(line, ",");
            //only if the line has three arguments then get the arguments
            if(cTokens.countTokens()==3){
                int h = Integer.parseInt(cTokens.nextToken());
                int w = Integer.parseInt(cTokens.nextToken());
                float p = Float.parseFloat(cTokens.nextToken());
                Candle c = new Candle(h, w, p);
                //now add the candle to the array
                allCandles[candleCount++] = c;
            }//if
            else{
                System.out.println(line + " does not have three tokens");
            }
            //read the next line
            line = input.readLine();
        }//while
    }
}