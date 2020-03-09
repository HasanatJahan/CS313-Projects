import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

/**
 * The EditMenuHandler class implements the ActionListener
 * class that handles the menu options "Search" by
 * completing the appropriate actions.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class EditMenuHandler implements ActionListener {
    JFrame jFrame;
    static CandleGUI cGUI;

    public EditMenuHandler(CandleGUI myGUI){
        cGUI = myGUI;
    }

    public void actionPerformed(ActionEvent event){
        String menuName = event.getActionCommand();
        if(menuName.equals("Search")){
            float userInputNum= 0.0f;
            //we do validation for the user input
            try{
                String userInput = JOptionPane.showInputDialog(null, "Please enter the price of your candle: ");
                userInputNum = Float.parseFloat(userInput);
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Not a number!");
            }
            catch(NullPointerException npe){
                JOptionPane.showMessageDialog(null, "Open a file first! Where I am supposed to find candles!");
            }

            //then display the candles to the GUI
            cGUI.getContentPane().removeAll();
            cGUI.displayCheaperCandles(Project4.sortedList, userInputNum);
        }
    }

}//ActionListener


