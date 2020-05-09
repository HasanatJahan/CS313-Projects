import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression extends ExpressionTree {

    public String fullyParenthesised() {
//        return fullyParenthesised((BNode) this.root);
        return "";
    }

    // NOTE:   THIS IS WHAT I WAS WORKING ON
    public String fullyParenthesised(BNode node){
//        // note: you only need parenthesis around the children
//        String result = "";
//
//        if(node == null){
//            result = "";
//        }
//
//        if( null == node.getLeft()  && null == node.getRight()){
//            result +=  node.data;
//        }
//
//        result += "(";
//        fullyParenthesised(node.getLeft());
//        result += ")";
//
//        if(node.getRight() != null){
//            result += "(";
//            fullyParenthesised(node.getRight());
//            result += ")";
//        }
//
//        return result;
        return "";
    } // fullyParenthesised -- helper


    public Expression(String s) {
        super();

        //remove all the spaces in the expression
        String sNoSpaces = s.replaceAll("\\s", "");
        ArrayList<Character> expression= new ArrayList<Character>();

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(sNoSpaces);


        //now to populate the input expression array list
        for(int i = 0; i < sNoSpaces.length(); i++){
            char elem = sNoSpaces.charAt(i);
            if(elem == 'd'){
                //this adds the whole digit to the inputExpression
                String numVal = matcher.group();
                expression.add(numVal.charAt(0));
            }else{
                expression.add(elem);
            }
        } //for loop to populate the expression

        // create a postfix arraylist
        ArrayList<Character> postfixList = infixToPostfix(expression);

        // build the tree
        BNode<String> expressionRoot = buildTree(postfixList);

        //now set the expression tree
        this.root = expressionRoot;

    } //constructor



    // Reference: https://www.geeksforgeeks.org/expression-tree/
    BNode buildTree(ArrayList<Character> postfixList){
        Stack<BNode> nodeStack = new Stack<>();
        BNode node = new BNode(postfixList.get(0), null, null, null);
        BNode op1, op2;

        for(int i = 0; i < postfixList.size(); i++){
            String elem = Character.toString(postfixList.get(i));
            // if it is not the operator
            if( !elem.equals("+") && !elem.equals("-") && !elem.equals("*") && !elem.equals("/")){
                node = new BNode(elem, null, null, null);
                node.setData(elem);
                nodeStack.push(node);

            }
            else {
                node = new BNode(elem, null, null, null);
                node.setData(elem);
                if(!nodeStack.empty()){
                    // pop two top nodes
                    op1 = nodeStack.pop();
                    op2 = nodeStack.pop();

                    // build tree component
                    node.setRight(op1);
                    node.setLeft(op2);
                    op1.setParent(node);
                    op2.setParent(node);

                }

                //now add the final expression to the stack
                nodeStack.push(node);
            }
        }

        node = nodeStack.peek();
        nodeStack.pop();

        return node;
    } //buildTree


    // Reference: https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
    private ArrayList<Character> infixToPostfix(ArrayList<Character> infix){
        ArrayList<Character> result = new ArrayList<>();
        //stack for the operators
        Stack<Character> operators = new Stack<>();
        //stack for the number and previous expression held
        Stack<String> operands = new Stack<>();

        //go through the infix expression and populate the prefix ArrayList
        for ( int i = 0; i< infix.size(); i++ ){
            Character currentChar = infix.get(i);
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

                    String temp =  op1 + " " + op2 + " " + usedOp;;
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

                    String temp =  op1 + " " + op2 + " " + usedOp;;
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

            String temp = op1 + " " + op2 + " " + usedOp;
            operands.push(temp);
        }

        //--- populate the resulting arraylist
        String resultStr = operands.peek();
        //this takes out all the numbers
        String resultStrNoNum = resultStr.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(resultStr);

        for (int i = 0 ; i < resultStrNoNum.length(); i++){
            char elem = resultStrNoNum.charAt(i);
            if(elem == 'd'){
                if(matcher.find()){
                    String numVal = matcher.group();
                    result.add(numVal.charAt(0));
                }
            }else{
                result.add(elem);
            }
        } //ending for

        return result;

    }// infixToPostfix


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
            operands.push(temp);
        }

        //--- populate the resulting arraylist
        String resultStr = operands.peek();
        //this takes out all the numbers
        String resultStrNoNum = resultStr.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(resultStr);

        for (int i = 0 ; i < resultStrNoNum.length(); i++){
            char elem = resultStrNoNum.charAt(i);
            if(elem == 'd'){
                if(matcher.find()){
                    String numVal = matcher.group();
                    result.add(numVal.charAt(0));
                }
            }else{
                result.add(elem);
            }
        } //ending for

        return result;
    } // infixToPrefix


    // Reference: https://www.geeksforgeeks.org/evaluation-of-expression-tree/
    public double evaluate() {
        return evaluate((BNode) root);
    }

    private double evaluate(BNode node){
        if( root == null ) return 0.0;
        if ( null == node.getRight() && null == node.getLeft()){
            return Double.parseDouble((String) node.data);
        }
        double leftVal = evaluate(node.getLeft());
        double rightVal = evaluate(node.getRight());

        if(node.data.equals("+")){
            return leftVal + rightVal;
        }
        if(node.data.equals("-")){
            return leftVal - rightVal;
        }
        if(node.data.equals("*")){
            return leftVal * rightVal;
        }

        return leftVal / rightVal;

    } //evaluate -  helper

}
