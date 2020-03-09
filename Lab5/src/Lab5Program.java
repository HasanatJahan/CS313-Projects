import javax.swing. *;

public class Lab5Program {

    public static void main(String[] args) {
        String isOrIsNot, inputWord;
        //we take the first argument which is in args- this would be the file to be read
        String fileName=args[0];
        //now we input the value from the file
        String[] wordArray= inputFromFile(fileName);

        while (true) {
            //This line asks the user for input by popping out a single window
            //with text input
            inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case: ");
            if(inputWord.equals("STOP") || inputWord.equals("stop")){
                System.exit(0);
            }
            //if the inputWord is contained within wordArray return true
            if (wordIsThere(inputWord, wordArray))
                isOrIsNot = "is"; //set to is if the word is on the list
            else
                isOrIsNot = "is not"; //set to its not if word is not on the list

            //Output to a JOptionPane window whether the word is on the list or not
            JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");

        }//while loop
    }//main

    public static boolean wordIsThere(String findMe, String[] theList){
        for(int i=0; i<theList.length; i++){
            if(findMe.equals(theList[i])){
                return true;
            }
        }
        return false;
    }//wordIsThere

    //here we declare the method to be used for the class
    public static String[] inputFromFile(String file){
        String[] tempArray = new String [20];
        TextFileInput tfi= new TextFileInput(file);
        //now read until the end of the file
        //first read the first line
        String line= tfi.readLine();
        //now we want to count the size of the array- the length method will not do this
        //because we are adding to the array
        int count=0;
        //here we iterate
        while(line!=null){
            //we read a line and add it to the array
            tempArray[count++]= line;
            line = tfi.readLine();
        }
        //after we complete we can find the file- we cannot return this array directly
        //because the actual size is not 20
        String[] actualArray= new String[count];
        for(int i=0; i<count; i++){
            actualArray[i]= tempArray[i];
        }
        return actualArray;
    }//inputFromFile
}//class Lab4Program1