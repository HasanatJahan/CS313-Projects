import javax.swing.*;
import java.io.File;

public class ListLargestFile {
    static long maxLength = 0;
    static File maxFile = null;
    public static void main(String[] args) {
        JFileChooser fd = new JFileChooser("./");
//        mode - the type of files to be displayed:
//            * JFileChooser.FILES_ONLY
//            * JFileChooser.DIRECTORIES_ONLY
//            * JFileChooser.FILES_AND_DIRECTORIES
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fd.showOpenDialog(null);
        File f = fd.getSelectedFile();
        listFiles(f,"");
        System.out.println("The max file is "+maxFile+ " with the length of "+ maxFile.length());
    }
    public static void listFiles(File f, String indent) {
        File files[] = f.listFiles();

        for (int i = 0; i<files.length; i++) {
            File f2 = files[i];
            System.out.print(indent+f2.getName());
            System.out.print("...");
            System.out.print(f2.lastModified());
            System.out.print("...");
            System.out.print(f2.length());
            System.out.println();
            if(f2.length()>maxLength){
                maxFile = f2;
                maxLength = f2.length();
            }
            if (f2.isDirectory())
                listFiles(f2, indent+"   ");
        }
    }
}

