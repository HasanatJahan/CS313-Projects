import java.awt.GridLayout;
import javax.swing.*;

/**
 * The CandleGUI class allows the user to display
 * the results of Candle array.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class CandleGUI extends JFrame {
    //constructor
    CandleGUI(Candle[] candle1, Candle[] candle2){
        super();
        setTitle("Candles");
        setSize(400,200);
        setLocation(100,100);
        setLayout(new GridLayout(1,2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JTextArea textAreaLeft = new JTextArea(20,20);
        JTextArea textAreaRight = new JTextArea(20,20);
        textAreaLeft.setEditable(false);
        textAreaRight.setEditable(false);

        getContentPane().add(textAreaLeft);
        getContentPane().add(textAreaRight);
        textAreaLeft.setText("Unsorted Candles\n");
        textAreaRight.setText("Sorted Candles\n");

        pack();
        setVisible(true);

        displayCandle(candle1, textAreaLeft);
        displayCandle(candle2, textAreaRight);
    }


    /**
     * Method that fills the text area with the candles
     * @param candle: the candle array
     *        myText: the JTextArea to display the results
     */
    public static void displayCandle(Candle[] candle, JTextArea myText){
        for(int i=0; i<Project1.candleCount; i++){
            myText.append(candle[i]+"\n");
        }//for
    }
}
