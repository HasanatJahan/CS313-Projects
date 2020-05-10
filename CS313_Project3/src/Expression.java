import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The ExpressionTree program implements an expression tree from
 * input infix expression.
 *
 * @author  Hasanat Jahan
 */

public class Expression extends ExpressionTree {

    // Reference: http://penguin.ewu.edu/cscd300/Topic/ExpressionTree/ExpressionTree.java
    public String fullyParenthesised() {
        String result = "";
        return fullyParenthesised((BNode) this.root, result);
    }

    private String fullyParenthesised(BNode node, String result){
        if(node != null){
            if(!isLeaf(node)){
                result += "(" ;
            }
            result = fullyParenthesised(node.getLeft(), result) + node.data ;
            result = fullyParenthesised(node.getRight(), result) ;
            if(!isLeaf(node)){
                result += ")" ;
            }
        }
        return result;
    } // fullyParenthesised -- helper


    public void printInfix(){
        printInfix((BNode) this.root);
    }

    private void printInfix(BNode node){
        if(node != null){
            if(!isLeaf(node)){
                System.out.print("( ");
            }
            printInfix(node.getLeft());
            System.out.print(node.data + " ");
            printInfix(node.getRight());
            if(!isLeaf(node)){
                System.out.print(") ");
            }
        }

    }


    public Expression(String s) {
        super();

        //remove all the spaces in the expression
        String sNoSpaces = s.replaceAll("\\s", "");

        //this takes out all the numbers and replaces them with d
        String sNoNum = s.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");

        System.out.println(sNoSpaces);
        System.out.println(sNoNum);

        ArrayList<String> expression= new ArrayList<String>();

        //let's do the pattern checking to find all the numbers
        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        //this matches the pattern with all the numbers in the expression
        Matcher matcher = numRegex.matcher(sNoSpaces);


        //now to populate the input expression array list
        for(int i = 0; i < sNoNum.length(); i++){
            char elem = sNoNum.charAt(i);

            if(elem == 'd'){
                if( matcher.find()){
                    //this adds the whole digit to the inputExpression
                    String numVal = matcher.group();
//                    expression.add(numVal.charAt(0));
                    expression.add(numVal);
                }
            }else{
                expression.add(Character.toString(elem));
            }
        } //for loop to populate the expression

        // create a postfix arraylist
        ArrayList<String> postfixList = infixToPostfix(expression);

        // Note: testing if infix to postfix worked
        System.out.print("This is the postfix list ");
        for(int i = 0; i< postfixList.size(); i++){
            System.out.print(postfixList.get(i) + " ");
        }
        System.out.println();

        // build the tree
        BNode<String> expressionRoot = buildTree(postfixList);

        // now set the expression tree root
        this.root = expressionRoot;

        // Note: testing what went wrong
        System.out.println("Input String " + s );
        treePrint(this.root);
        printInfix();
        System.out.println();
    } //constructor



    // Reference: https://www.geeksforgeeks.org/expression-tree/
    BNode buildTree(ArrayList<String> postfixList){
        Stack<BNode> nodeStack = new Stack<>();
        BNode node;
        BNode op1, op2;

        for(int i = 0; i < postfixList.size(); i++){
            String elem = postfixList.get(i);
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
//    private ArrayList<String> infixToPostfix(ArrayList<String> infix){
//        ArrayList<String> result = new ArrayList<>();
//        //stack for the operators
//        Stack<String> operators = new Stack<>();
//        //stack for the number and previous expression held
//        Stack<String> operands = new Stack<>();
//
//        //go through the infix expression and populate the prefix ArrayList
//        for ( int i = 0; i< infix.size(); i++ ){
//            String currentStr = infix.get(i);
//            System.out.println("currentChar " + currentStr);
//
//            if(currentStr.equals('(')){
//                operators.push(currentStr);
//            }
//            else if(currentStr.equals("*") || currentStr.equals("/") || currentStr.equals("+") || currentStr.equals("-")){
//                operators.push(currentStr);
//            }
//            else if(currentStr.equals(")")){
//                while( !operators.empty() && !operators.peek().equals("(") ){
//                    //take the two operands
//                    String op1 = operands.peek();
//                    operands.pop();
//                    String op2 = operands.peek();
//                    operands.pop();
//                    //now get the latest operator
//                    String usedOp = operators.peek();
//                    operators.pop();
//
//                    String temp =  op1 + " " + op2 + " " + usedOp;
//                    operands.push(temp);
//                }
//                //now pop the opening bracket
//                operators.pop();
//            }
//
//            // if it's not an operator
//            else if(!currentStr.equals("*") && !currentStr.equals("/") && !currentStr.equals("+") && !currentStr.equals("-")){
//                operands.push(currentStr);
//            }
//
//            //if it is an operator
//            // push this operator from the stack after popping the operators that have a higher priority
//            else{
//                while (!operators.empty() && getPriority(currentStr) <= getPriority(operators.peek())){
//                    //take the two operands
//                    String op1 = operands.peek();
//                    operands.pop();
//                    String op2 = operands.peek();
//                    operands.pop();
//                    //now get the latest operator
//                    String usedOp = operators.peek();
//                    operators.pop();
//
//                    String temp =  op1 + " " + op2 + " " + usedOp;;
//                    operands.push(temp);
//                }
//                //now push the current operator
//                operators.push(currentStr);
//            }//else
//        } //main for loop
//
//        //if operators stack is not empty
//        while (!operators.empty()){
//            if( operands.size() >=2 ){
//                //take the two operands
//                String op1 = operands.peek();
//                operands.pop();
//                String op2 = operands.peek();
//                operands.pop();
//                //now get the latest operator
//                String usedOp = operators.peek();
//                operators.pop();
//
//                String temp = op1 + " " + op2 + " " + usedOp;
//                operands.push(temp);
//            }
//        }
//
//        //--- populate the resulting arraylist
//        String resultStr = operands.peek();
//        //this takes out all the numbers
//        String resultStrNoNum = resultStr.replaceAll("(\\d+(?:\\.\\d+)?)", "d").replace(".", "").replace(" ", "");
//
//        //let's do the pattern checking to find all the numbers
//        Pattern numRegex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
//        //this matches the pattern with all the numbers in the expression
//        Matcher matcher = numRegex.matcher(resultStr);
//
//        for (int i = 0 ; i < resultStrNoNum.length(); i++){
//            String elem = Character.toString(resultStrNoNum.charAt(i));
//            if(elem.equals("d")){
//                if(matcher.find()){
//                    String numVal = matcher.group();
//                    result.add(numVal);
//                }
//            }else{
//                result.add(elem);
//            }
//        } //ending for
//
//        return result;
//
//    }// infixToPostfix

    // Reference: https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
    // new Reference: https://algorithms.tutorialhorizon.com/convert-infix-to-postfix-expression/
    // Reference : https://stackoverflow.com/questions/26699089/infix-to-postfix-using-stacks-java
    private ArrayList<String> infixToPostfix(ArrayList<String> infix){
        ArrayList<String> result = new ArrayList<>();
        //initialize empty stack
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < infix.size(); i++) {
            String elem = infix.get(i);
//            System.out.println("this is elem " + elem);

            // not an operator or a brace
            if (!elem.equals("+") && !elem.equals("-") && !elem.equals("*") && !elem.equals("/") && !elem.equals("(") && !elem.equals(")")) {
                System.out.println("what is elem here "+ elem);
                result.add(elem);
            }
            // closing brace
            else if(elem.equals(")")){
                while(!stack.empty() && !stack.peek().equals("(")){
                    result.add(stack.pop());
                }
                //remove opening brace
//                stack.pop();
            }
            // if it an operator
            else{
//                System.out.println("what is elem here " + elem);
                while(!stack.empty() && !elem.equals("(") && getPriority(stack.peek()) >= getPriority(elem)){
                    String popped = stack.pop();
                    if(!popped.equals("(")){
                        result.add(popped);
                    }
                }
                stack.push(elem);
            }



//            // it is an operator
//            else if (elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
//                if (!stack.empty() && getPriority(elem) > getPriority(stack.peek())) {
//                    stack.push(elem);
//                } else {
//                    while (!stack.empty() && getPriority(elem) <= getPriority(stack.peek())) {
//                        String op = stack.pop();
//                        if (!op.equals("(")) {
//                            result.add(op);
//                        } else {
//                            elem = op;
//                        }
//                    }
//                    stack.push(elem);
//                }
//            } else {
//                 if (elem.charAt(0) == ')') {
//                    while (!stack.empty() && !stack.peek().equals("(")) {
//                        System.out.println("is it coming here");
//                        String op = stack.pop();
//                        result.add(op);
//                    }
//                }
//                else if (elem.charAt(0) == '(') {
//                    System.out.println("what about here");
//                    stack.push(elem);
//                }
//
//                //remove the opening brace
//                stack.pop();
//            }
        } //for loop



        //if anything remains on the stack add it to result
        while(!stack.empty()){
            String op = stack.pop();
            if(!op.equals("(")){
                result.add(op);
            }
        }
        return result;
    }//infixtoPostfix

    // Method that gets the priority of the given operator
    private int getPriority(String operator){
        if(operator.equals("*") || operator.equals("/")){
            return 2;
        }
        else if(operator.equals("+") || operator.equals("-")){
            return 1;
        }
        return 0;
    } //getPriority


    // Reference: https://www.geeksforgeeks.org/evaluation-of-expression-tree/
    public double evaluate() {
        return evaluate((BNode) root);
    }

    private double evaluate(BNode node){
        if( root == null ) return 0.0;
        if ( null == node.getRight() && null == node.getLeft()){
            return Double.parseDouble((String) node.data);
        }
        // get the leaves which are the values
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
