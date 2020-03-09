import javax.swing.JOptionPane;

/**
 * Outputs the number of uppercase and lowercase
 * instances of the the letter E in a user input string.
 * It takes user string input using JOptionPane,
 * uses two methods to count the respective cases of E,
 * and displays the output using JOptionPane.
 *
 * @author Hasanat Jahan
 * @lab-section 11H Cuiyuan Wang
 * @Lab-Time TueThu 3:50PM-4:40PM
 * @student-id 23686488
 */

public class Project0 {
    public static void main(String[] args){
        String inputWord;
        while(true) {
            //takes user input string
            inputWord = JOptionPane.showInputDialog(null, "Please enter a sentence");

            //check if the user wants to stop the program
            if (inputWord.equalsIgnoreCase("stop")) {
                System.exit(0);
            }

            //display the output to the user by calling the separate methods
            JOptionPane.showMessageDialog(null, "Number of lowercase e's: "+ lowerECount(inputWord) + "\nNumber if upper case e's: "+ upperECount(inputWord));
        }//while loop
    }//main

    /**
     * method to count the upper case letters
     * @param: input string from user stored in variable inputWord
    */
    public static int upperECount(String inputWord){
        int uppercaseCount=0;
        for(int i=0; i<inputWord.length(); i++){
            char letter= inputWord.charAt(i);
            if(letter =='E'){
                uppercaseCount+=1;
            }
        }//for loop

        return uppercaseCount;
    }//upperECount


    /**   method to count the lower case letters
     *    @param: input string from user stored in variable inputWord
    */
    public static int lowerECount(String inputWord){
        int lowercaseCount=0;
        for(int i=0; i<inputWord.length(); i++){
            char letter= inputWord.charAt(i);
            if(letter =='e'){
                lowercaseCount+=1;
            }
        }//for loop

        return lowercaseCount;
    }//lowerECount
}//class