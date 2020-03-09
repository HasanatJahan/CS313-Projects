import javax.swing.*;
import java.awt.*;
public class SampleGUI extends JFrame {

    public SampleGUI(String title, int height, int width) {
        setTitle(title);
        setSize(height,width);
        setLocation  (400,200);
        createFileMenu();
//        createEditMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    } //SSNGUI

    private void createFileMenu( ) {
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();
        JMenu       fileMenu = new JMenu("File");
        JMenu       editMenu = new JMenu("Edit");
        //this will tell you how to react
        FileMenuHandler fmh  = new FileMenuHandler(this);
        EditMenuHandler emh = new EditMenuHandler(this);


        item = new JMenuItem("Open");    //Open...
        item.addActionListener( fmh );
        fileMenu.add( item );

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener( fmh );
        fileMenu.add( item );

        //this is for the edit menu
        item = new JMenuItem("Find");    //Find...
        item.addActionListener( emh );
        editMenu.add( item );

        editMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Replace");       //Quit
        item.addActionListener( emh );
        editMenu.add( item );

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
    } //createMenu

} //SSNGUI