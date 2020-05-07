import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression extends ExpressionTree {

    //NOTE: The fullyParenthesised method can also be done using a recursion.
    // This will require an auxiliary recursive method to call on.
    public String fullyParenthesised() {
        // add implementation here
        return "";
    }

    // Deal with the easier case when there are no parentheses first.
    // Once you accomplish this you can finish quickly using a recursion
    //Reference: https://github.com/Tacuma/Infix-to-Expression-Tree/blob/master/Infix-to-Expression-Tree/infixtotree.cpp

    public Expression(String s) {
        super();

        //remove all the spaces in the expression
        String sNoSpaces = s.replaceAll("\\s", "");

        //let's separate the numerical values from the operators
        List<String> numList = Arrays.asList(s.split("[^[0-9]$]"));

        // stack should hold the expression string
        Stack <Character> inputExpression = new Stack<Character>();

        // create an expression - this could be the arraylist
        ArrayList<Character> expression= new ArrayList<Character>();

        // stack for the nodes
        Stack <BNode> treeNodes = new Stack<>();
        // stack for the operators
        Stack <BNode> operators = new Stack<>();

        //this is the expression with no numbers
        String exprNoNum = s.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(sNoSpaces);

//        //now to populate the input stack
//        for(int i = 0; i < sNoSpaces.length(); i++){
//            char elem = sNoSpaces.charAt(i);
//            if(elem == 'd'){
//                //this adds the whole digit to the inputExpression
//                String numVal = matcher.group();
//                inputExpression.add(numVal.charAt(0));
//            }else{
//                inputExpression.add(elem);
//            }
//        } //for loop to populate the inputExpression stack

        //now to populate the input expression arraylist
        for(int i = 0; i < sNoSpaces.length(); i++){
            char elem = sNoSpaces.charAt(i);
            if(elem == 'd'){
                //this adds the whole digit to the inputExpression
                String numVal = matcher.group();
                expression.add(numVal.charAt(0));
            }else{
                expression.add(elem);
            }
        } //for loop to populate the expression arraylist
        //Note: Expression works
        // Reference: https://www.geeksforgeeks.org/infix-to-prefix-conversion-using-two-stacks/
        // Reference: https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/

        ArrayList<Character> prefixList = infixToPrefix(expression);

        //now to test if it worked
        System.out.println("This is the prefix arraylist");
        for (int i = 0; i < prefixList.size(); i++){
            System.out.println(prefixList.get(i));
        }

    } //constructor

    /**
     *
     * @param operator
     * @return
     */
    // Method that gets the priority of the given operator
    private int getPriority(char operator){
        if(operator == '*' || operator == '/'){
            return 2;
        }
        else if(operator == '+' || operator == '-'){
            return 1;
        }
        return 0;
    } //getPriority

    /***
     *
     * @param infix
     * @return
     */
    // References: https://www.geeksforgeeks.org/infix-to-prefix-conversion-using-two-stacks/
    private ArrayList<Character> infixToPrefix(ArrayList<Character> infix){
        ArrayList<Character> result = new ArrayList<>();
        //stack for the operators
        Stack<Character> operators = new Stack<>();
        //stack for the number and previous expression held
        Stack<String> operands = new Stack<>();

        //go through the infix expression and populate the prefix ArrayList
        for ( int i = 0; i< infix.size(); i++ ){
            Character currentChar = infix.get(i);
            System.out.println("this is currentChar "+ currentChar);
            if(currentChar == '('){
                operators.push(currentChar);
            }
            else if(currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-'){
                operators.push(currentChar);
            }
            else if(currentChar == ')'){
                while( !operators.empty() && operators.peek() != '(' ){
                    //take the two operands
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    //now get the latest operator
                    Character usedOp = operators.peek();
                    operators.pop();

                    String temp = usedOp + " " + op2 + " " + op1;
                    System.out.println("This si the temp created " + temp);
                    operands.push(temp);
                }
                //now pop the opening bracket
                operators.pop();
            }

            // if it's not an operator
            else if(currentChar != '*' || currentChar != '/' || currentChar != '+' || currentChar != '-'){
                // convert the char to a string
                String currentStr = Character.toString(currentChar);
                operands.push(currentStr);
            }

            //if it is an operator
            // push this operator from the stack after popping the operators that have a higher priority
            else{
                while (!operators.empty() && getPriority(currentChar) <= getPriority(operators.peek())){
                    //take the two operands
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    //now get the latest operator
                    Character usedOp = operators.peek();
                    operators.pop();

                    String temp = usedOp + " " + op2 + " " + op1;
                    System.out.println("This is the temp created " + temp);
                    operands.push(temp);
                }
                //now push the current operator
                operators.push(currentChar);
            }//else
        } //main for loop

        //if operators stack is not empty
        while (!operators.empty()){
            //take the two operands
            String op1 = operands.peek();
            operands.pop();
            String op2 = operands.peek();
            operands.pop();
            //now get the latest operator
            Character usedOp = operators.peek();
            operators.pop();

            String temp = usedOp + " " +op2 + " " + op1;
            System.out.println("This is the temp created " + temp);
            operands.push(temp);
        }

        // Note the infix to prefix notation is working
        //--- populate the resulting arraylist
        String resultStr = operands.peek();
//        String resultStrNoSpaces = resultStr.replaceAll("\\s", "");
//        System.out.println("This is resultStrNoSpaces " + resultStrNoSpaces);
        System.out.println("This is resultStr " + resultStr);
        //this takes out all the numbers
        String resultStrNoNum = resultStr.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");

        System.out.println("this is result str no num " + resultStrNoNum);
        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(resultStr);

        // Note: Testing stuff
        System.out.println("This si numval " + matcher.group().charAt(0));


        // traverse through the operands string to populate resulting prefix arraylist
        for (int i = 0 ; i < resultStrNoNum.length(); i++){
            char elem = resultStrNoNum.charAt(i);
            System.out.println("This is elem " + elem );
            if(elem == 'd'){
                //this adds the whole digit to the result arraylist
//                matcher.matches();
                String numVal = matcher.group();
                result.add(numVal.charAt(0));
            }else{
                result.add(elem);
            }
        } //ending for

        return result;
    } // infixToPrefix





    //Note : Dijkstra's two-stack algorithm for expression evaluation
    // Reference: https://stackoverflow.com/questions/37110903/dijkstras-two-stack-algorithm-for-expression-evaluation
    // Reference: https://www.geeksforgeeks.org/expression-tree/
    //NOTE: The evaluate should be straight forward; it builds upon previous work you have done in this class.
    public double evaluate() {
        // add implementation here
        return 0.0;
    }

    //NOTE: write any other methods that you think might be helpful
}
