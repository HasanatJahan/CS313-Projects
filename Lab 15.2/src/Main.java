import java.util.*;
import java.util.Scanner;

class Main{
    static boolean isValid(String s){
        //remove all the spaces from the string
        String strNoAlphaNum = s.replaceAll("[A-Za-z0-9]", "");
        String str = strNoAlphaNum.replaceAll("\\s", "");

        //initialize a stack to hold opening parens
        Stack<Character> stack = new Stack<Character>();

        //iterate through the string and add every opening brace to a stack
        for(int i = 0 ; i < str.length(); i++){
            char currChar = str.charAt(i);
            //if an opening brace
            if(currChar == '[' || currChar == '(' ){
                stack.push(currChar);
            }
            //else if it is a closing brace
            else if(currChar == ']' || currChar == ')'){
                if(stack.empty()) return false;
                //popped elem
                char poppedElem = stack.pop();
                // now  for each of the separate parens
                // for  square bracket
                if(currChar == ']' && poppedElem != '[') return false;
                // for parenthesis
                if(currChar == ')' && poppedElem != '(') return false;
            }
        }//for

        // this is if it only has opening braces
        if(!stack.empty()) return false;
        //if it passes all the tests then it is false
        return true;
    }
    /*
     * Sample main to run tests
     * *************************
     * Runs default tests if no
     * input is given.
     */
    public static void main(String[] args){
        //Variables
        Scanner scnr = new Scanner(System.in);
        //Custom test case
        if(scnr.hasNext()){
            String testInput = "";
            while(scnr.hasNext()){
                testInput = scnr.nextLine();
                System.out.println(testInput + " : " + isValid(testInput));
            }
        }
        //Default test case
        else{
            String [] sampletests = {"(lo[ef]fejefd)", "(ad(d23(efe[ef][2][3])[])[)","([([([welcome])hi])])}"};
            boolean [] sampleoutput = {true,false,true};
            for(int i = 0; i < sampletests.length; i++){
                if(isValid(sampletests[i]) != sampleoutput[i]){
                    System.out.println("Failed sample tests");
                    return;
                }
            }
            System.out.println("Passed sample tests");
        }
    }
}