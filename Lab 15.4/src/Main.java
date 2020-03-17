import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main{
    static double evaluate(String expr){
        double eval = 0.0;

        // this creates the string with no spaces
        String exprNoSpaces = expr.replaceAll(" ", "");
        String exprNoNum = expr.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", ""); //this takes out all the numbers

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = numRegex.matcher(exprNoSpaces); //this matches the pattern with all the numbers in the expression


        //go through the string once
        int numOperators = 0;
        int numParens = 0;
        // go through the array once
        for(int i = 0 ; i < exprNoSpaces.length(); i++){
            char elem = exprNoSpaces.charAt(i);
            if(elem == '*' || elem == '/' || elem == '+' || elem == '-' ){
                numOperators ++;
            }
            else if(elem == '(' || elem == ')'){
                numParens ++;
            }
        } //for

        // if with n numOperators there are not 2n parentheses then return 0
        if(numParens != (2 * numOperators)) {
            return eval;
        }


        // Dijkstra's Two Stack Algorithm
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> vals = new Stack<Double>();

        //iterate through the array of exprNoSpaces
        for(int i = 0 ; i< exprNoNum.length() ; i++){
            char elem = exprNoNum.charAt(i);
            if(elem == '(' || elem == ' ') {} //do nothing
            else if ( elem == '+' || elem == '-' || elem == '*' || elem == '/'){
                ops.push(elem);
            }
            else if (elem == ')') {
                char op = ops.pop();
                double v = vals.pop();

                if(op == '+') v = vals.pop() + v;
                else if(op == '-') v = vals.pop() - v;
                else if(op == '*') v = vals.pop() * v;
                else if(op == '/') v = vals.pop()/ v  ;

                vals.push(v);
            }
            else if (elem == 'd'){
                if(matcher.find()){
                    Double numVal = Double.parseDouble(matcher.group());
                    vals.push(numVal);
                }
            }
        } //for
        return vals.pop();
    } //evaluate method

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
                System.out.println(testInput + " : " + evaluate(testInput));
            }
        }
        //Default test case
        else{
            String [] sampletests = {"(1+(2*3))", "(2*(4*(6/3)))","(3+(4*2))"};
            double [] sampleoutput = {7.0, 16.0, 11.0};
            for(int i = 0; i < sampletests.length; i++){
                if(evaluate(sampletests[i]) != sampleoutput[i]){
                    System.out.println("Failed sample tests");
                    return;
                }
            }
            System.out.println("Passed sample tests");
        }
    }
}