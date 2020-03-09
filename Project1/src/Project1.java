import java.util.*;
/**
 *  This program reads from a input file of data for candles,
 *  fills two arrays of Candles, sorts one of them and
 *  displays them side to side in separate window.
 *
 * @author Hasanat Jahan
 * @lab-section 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class Project1 {
    public static Candle[] unsortedCandleArray;
    public static Candle[] sortedCandleArray;
    public static TextFileInput inputFile;
    public static int candleCount;


    public static void main(String[] args){
        int maxLineCount = 100;
        candleCount=0;
        String myFile = "input.txt";
        inputFile = new TextFileInput(myFile);

        unsortedCandleArray= new Candle[maxLineCount];
        sortedCandleArray= new Candle[maxLineCount];

        //fill the candle array and change the candleCount variable
        fillArrays(inputFile);

        //sort one of the arrays - the sorted candle array
        arraySelectionSorter(sortedCandleArray);

        //display the candles
        new CandleGUI(unsortedCandleArray, sortedCandleArray);
    }

    /**
     *  Method to change the number of candles and
     *  fill up the candle details array
     * @param input: the TextFileInput to read the values from
     */
    public static void fillArrays(TextFileInput input){
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
                unsortedCandleArray[candleCount] = c;
                sortedCandleArray[candleCount] = c;
                candleCount++;
            }//if
            else{
                System.out.println(line + " does not have three tokens");
            }
            //read the next line
            line = input.readLine();
        }//while
    }

    /**
     * This method sorts the unsorted array to create a new sorted array
     * @param candleArray: the candle array to sort
     */
    public static void arraySelectionSorter(Candle[] candleArray){
        for(int i=0; i<candleCount-1; i++){
            int lowestIndex=i;
            for(int j=i+1; j<candleCount; j++){
                float jCandlePrice= candleArray[j].getPrice();
                float lowestIndexCandlePrice = candleArray[lowestIndex].getPrice();
                if(jCandlePrice < lowestIndexCandlePrice) {
                    lowestIndex = j;
                }
            }//for j
            //now to swap the values
            float iCandlePrice = candleArray[i].getPrice();
            float lowestIndexCandlePrice= candleArray[lowestIndex].getPrice();
            if(iCandlePrice != lowestIndexCandlePrice){
                Candle temp = candleArray[lowestIndex];
                candleArray[lowestIndex]= candleArray[i];
                candleArray[i]=temp;
            }//if
        }//for i
    }
}


