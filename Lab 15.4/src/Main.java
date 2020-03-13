import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main{
    static double evaluate(String expr){
        double eval = 0.0;

        expr = expr.replaceAll(" ", "");
        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = numRegex.matcher(expr);

        //go through the string once
        String tokens[] = expr.split("");
        int numOperators = 0;
        int numParens = 0;
        // go through the array once
        for(int i = 0 ; i < tokens.length; i++){
            String elem = tokens[i];
            if(elem.equals("*") || elem.equals("/") || elem.equals("+") || elem.equals("-")){
                numOperators ++;
            }
            else if(elem.equals("(") || elem.equals(")")){
                numParens ++;
            }
        } //for
        // if with n numOperators there are not 2n parentheses then return 0
        if(numParens != (2 * numOperators)) {
            return eval;
        }

        // Dijkstra's Two Stack Algorithm
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        //iterate through the array of tokens
        for(int i = 0 ; i< tokens.length; i++){
            if(tokens[i].equals("(")) continue; //do nothing
            else if (tokens[i].equals("+")) ops.push(tokens[i]);
            else if (tokens[i].equals("-")) ops.push(tokens[i]);
            else if (tokens[i].equals("*")) ops.push(tokens[i]);
            else if (tokens[i].equals("/")) ops.push(tokens[i]);

            else if (tokens[i].equals(")")) {

                String op = ops.pop();
                double v = vals.pop();
                System.out.println("this is v before " + v);

                if(op.equals("+")) v = vals.pop() + v;
                else if(op.equals("-")) v = vals.pop() - v;
                else if(op.equals("*")) v = vals.pop() * v;
                else if(op.equals("/")) v = vals.pop()/ v  ;

                System.out.println("This is the v after " + v);
                vals.push(v);
            }
            else if(matcher.find()){
                Double numVal = Double.parseDouble(matcher.group());

                vals.push(numVal);
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