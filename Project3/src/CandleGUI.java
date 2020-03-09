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
        createFileMenu();
        pack();
        setVisible(true);

    }

    /**
     * Method that creates the File Menu to Open or Quit
     */
    private void createFileMenu(){
        JMenuItem item;
        JMenuBar menuBar = new JMenuBar();
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

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
    }

    /**
     * Method that fills the text area with candles
     * @param candleList: the candle linked list
     *        myText: the JTextArea to display the results
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

//
}