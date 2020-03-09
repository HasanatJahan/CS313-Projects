import java.awt.*;
import javax.swing.*;

/**
 * The CandleGUI class allows the user to display
 * the results of Candle linked lists.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class CandleGUI extends JFrame {
    JTextArea unsortedTextArea = new JTextArea(20, 20);
    JTextArea sortedTextArea = new JTextArea(20, 20);
    //constructor
    CandleGUI(){
        super();
        setTitle("Candles");
        setSize(500,500);
        setLocation(100,100);
        getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        getContentPane().add(unsortedTextArea);
        getContentPane().add(sortedTextArea);
        unsortedTextArea.setEditable(false);
        sortedTextArea.setEditable(false);

        //here you add the file menu handler
        //create the file menu
        JMenuBar candleMenu = new JMenuBar();
        createFileMenu(candleMenu);
        createEditMenu(candleMenu);
        //here the method for createEditMenu method

        setJMenuBar(candleMenu);
        pack();
        setVisible(true);

    }

    /**
     * Method that creates the File Menu to Open or Quit
     */
    private void createFileMenu(JMenuBar menuBar){
        JMenuItem item;
        JMenu fileMenu = new JMenu("File");

        //this determines how it reacts to button presses
        FileMenuHandler fmh= new FileMenuHandler(this);

        item = new JMenuItem("Open");
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator();

        item = new JMenuItem("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);

        menuBar.add(fileMenu);
    }

    /**
     * Method that creates the edit method and makes a call
     * to ActionListener
     */
    private void createEditMenu(JMenuBar menuBar){
        JMenuItem item;
        JMenu editMenu = new JMenu("Edit");

        //this determines how it reacts to button presses
        EditMenuHandler emh= new EditMenuHandler(this);

        item = new JMenuItem("Search");
        item.addActionListener(emh);
        editMenu.add(item);

        menuBar.add(editMenu);
    }

    /**
     * Method that fills the text area with candles
     * @param candleList: the candle linked list
     *        candleType: name of candle to make printing prettier
     */
    public void displayCandle(String candleType, CandleList candleList){
        JTextArea myText = new JTextArea(20, 20);
        myText.setEditable(false);
        getContentPane().add(myText);
        myText.append(candleType);
        CandleNode current = candleList.first.next;
        while(current!=null){
            myText.append(current.data + "\n");
            current= current.next;
        }
    }

    /**
     * Method to display the cheaper candles from based
     * on user input candle price
     * @param
     */
    public void displayCheaperCandles(CandleList candleList, float userInputPrice){
        JTextArea myText = new JTextArea(20, 20);
        myText.setEditable(false);
        getContentPane().add(myText);
        CandleNode current = candleList.first.next;

        //if the user input price is lower than the smallest price
        if(userInputPrice<current.data.getPrice()){
            myText.append("There are no candles cheaper than that you cheapo");
        }
        else {
            myText.append("These are the cheaper candles\n");
            while (current != null && current.data.getPrice() <= userInputPrice) {
                myText.append(current.data + "\n");
                current = current.next;
            }
        }
    }


}