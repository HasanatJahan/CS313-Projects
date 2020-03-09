import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * The FileMenuHandler class implements the ActionListener
 * class that handles the menu options "Open" and "Quit" by
 * completing the appropriate actions.
 *
 * @author Hasanat Jahan
 * @lab-section: 11H Cuiyuan Wang
 * @lab-time: TueThu 3:50PM-4:40PM
 */

public class FileMenuHandler implements ActionListener {
    JFrame jframe;
    static CandleGUI cGUI;

    public FileMenuHandler (CandleGUI myGUI) {
        cGUI = myGUI;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        }
        else if (menuName.equals("Quit")) {
            System.out.println("Bye Bye");
            System.exit(0);
        }
    } //actionPerformed

    /**
     * Method that opens the file chosen by the "Open" option in the menuBar
     */
    private void openFile(){
        JFileChooser chooser = new JFileChooser("./");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Input","txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File selectedFile = chooser.getSelectedFile();
            //then you open the file and read it to create two linked lists
            readFile(selectedFile);
            //now to add the files to the GUI so they can be displayed
            cGUI.getContentPane().removeAll();
            cGUI.displayCandle("Unsorted\n", Project4.unsortedList);
            cGUI.displayCandle("Sorted\n", Project4.sortedList);
        }else{
            System.out.println("Sorry, no file was chosen");
        }
    }

    /**
     * Method to read the file and fill the unsorted candlelist and the
     * sorted candle list
     * @param myFile
     */
    private void readFile(File myFile){
        TextFileInput inputFile = new TextFileInput(myFile.toString());
        String line = inputFile.readLine();
        while(line != null){
            StringTokenizer cTokens = new StringTokenizer(line, ",");
            //only if the line has three arguments then get the arguments
            if(cTokens.countTokens()==3){
                int h = Integer.parseInt(cTokens.nextToken());
                int w = Integer.parseInt(cTokens.nextToken());
                float p = Float.parseFloat(cTokens.nextToken());
                Candle c = new Candle(h, w, p);
                //add the candle to the two linked lists
                Project4.unsortedList.add(c);
                Project4.sortedList.add(c);
            }
            else{
                System.out.println(line + " does not have three tokens");
            }
            line = inputFile.readLine();
        }
    }

}//ActionListener