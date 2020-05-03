public class Expression extends ExpressionTree {

    //NOTE: The fullyParenthesised method can also be done using a recursion.
    // This will require an auxiliary recursive method to call on.
    public String fullyParenthesised() {
        // add implementation here
        return "";
    }

    //26.1 Methods for a Binary Search Tree Set
    // NOTE: In terms of planning it, I suggest that you think about which operation is the last to be performed in the expression.
    // Can you write down a rule to identify this operation?
    // Deal with the easier case when there are no parentheses first. Once you accomplish this you can finish quickly using a recursion

    public Expression(String s) {
        //Note: The constructor should turn an input expression into the content of a binary (expression) tree.
        // The constructor should deal with expression without parenthesis
        // Adapt the constructor to deal with parenthesis - using a stack
        super();

        //remove all the spaces in the expression
        s = s.replaceAll("\\s", "");

        //let's first do the expression evaluation
        //define an expression tree by reading the expression


    }

    //NOTE: The evaluate should be straight forward; it builds upon previous work you have done in this class.
    public double evaluate() {
        // add implementation here
        return 0.0;
    }

    //NOTE: write any other methods that you think might be helpful
}
