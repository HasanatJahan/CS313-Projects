import java.util.*;
public class Polynomial extends AbstractPolynomial {
    private int expo;
    private double coeff;
    // constructor

    // this constructor should change it to canonical form
    public Polynomial(String s) {
        // adds all the polynomial strings to a list
        s = s.replaceAll("\\s", "");
        List<String> list = Arrays.asList(s.split("(?!^-)(?=[+-])"));
        ArrayList<String> polyStrs = new ArrayList<String>();
        // populate an Arraylist with the desired polynomials
        for (String str : list) {
            polyStrs.add(str);
        }

        String polyStr = "";
        //go through each polynomial in the array
        for (int i = 0; i < polyStrs.size(); i++) {
            //get's the first polynomial string
            polyStr = polyStrs.get(i);

            String [] expParts = polyStr.split("[a-zA-Z]"); //splits it by x
            String[] numExpParts = polyStr.split("\\^"); //splits it by ^
            String expoStr = "";
            //extract the exponent taking the right half of the expression splitting by ^
            if((numExpParts.length == 0) || (!polyStr.contains("^") && (polyStr.contains("X") || polyStr.contains("x")))){ //there is no numerical value so it's x^1
                expoStr = "1";
            }else if(expParts.length <= 1 ){ //there is no x- in that case it's x^0
                expoStr = "0";
            }else{
                expoStr = numExpParts[1];
            }

            //this extracts the coefficient taking the left half of the expression splitting by x
            String[] coeffParts = polyStr.replace(" ", "").split("[a-zA-Z]");
            String coeffStr = "";

            //create a coefficient for the polynomial
            if (coeffParts.length == 0 || coeffParts[0].equals("")) { //there is no x in the expression
                coeffStr = "1";
            }
            else if (coeffParts[0].equalsIgnoreCase("-")) {
                coeffStr = "-1";
            }
            else if(coeffParts[0].equalsIgnoreCase("+")){
                coeffStr = "+1";
            }
            else {
                coeffStr = coeffParts[0].replace(" ", "");
            }

            //here you create the term
            expo = Integer.parseInt(expoStr);
            coeff = Double.parseDouble(coeffStr);
            //term should be the data
            Term newTerm = new Term(coeff, expo);

            // Change this to try and catch
            try {
                DNode current = data.getFirst();

                boolean flag = false;
                while (current != null) {
                    Term currentTerm = (Term)current.getData();
                    //if the coefficients match then add the coefficient of the newTerm and the current term of iteraton
                    if (currentTerm.getDegree() == expo) {
                        currentTerm.setCoefficient(coeff + currentTerm.getCoefficient());
                        flag = true;
                        break;
                    }
                    current = current.getNext();
                }//while
                //if no matching coeff is found then create a new node and add it to the end of the linkedlist
                if(!flag) data.addLast(newTerm);  //if there was nothing added then do not append it to the list
            } //end of try block
            //if there is no head node
            catch (Exception e) {
                data.addLast(newTerm);
            } //end of catch
        } //for - going through each polynomial
    }//constructor


    public Polynomial() {
        super();
    }

    public AbstractPolynomial add(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        try {
            DNode thisNode = this.data.getFirst();
            DNode pNode = p.data.getFirst();
            double coeff;

            while(thisNode != null && pNode != null){
                Term thisNodeTerm = (Term)thisNode.getData();
                Term pNodeTerm = (Term)pNode.getData();
                //if one is greater than the other than add the node
                if(thisNodeTerm.getDegree() > pNodeTerm.getDegree()){
                    ans.data.addLast(thisNodeTerm);
                    thisNode = thisNode.getNext();

                    // TODO -- fix this portion to work with the exception - currently as soon as there is a null - it goes to catch

                    //nested if statements maybe
                    if(thisNode == null){
                        while (pNode != null){
                            pNodeTerm = (Term)pNode.getData();
                            ans.data.addLast(pNodeTerm);
                            pNode = pNode.getNext();
                        }
                    }

                }

                else if(thisNodeTerm.getDegree() < pNodeTerm.getDegree()){
                    ans.data.addLast(pNodeTerm);
                    pNode = pNode.getNext();


                }
                // if they are equal then add them together
                else{
                    coeff = thisNodeTerm.getCoefficient() + pNodeTerm.getCoefficient();
                    Term newTerm = new Term(coeff, thisNodeTerm.getDegree());
                    ans.data.addLast(newTerm);
                    thisNode = thisNode.getNext();
                    pNode = pNode.getNext();


                }
            } // while

            //merge the rest of the nodes until it is null
            while(thisNode != null){
                Term thisNodeTerm = (Term)thisNode.getData();
                ans.data.addLast(thisNodeTerm);
                thisNode = thisNode.getNext();
            }

            while (pNode != null){
                Term pNodeTerm = (Term)pNode.getData();
                ans.data.addLast(pNodeTerm);
                pNode = pNode.getNext();
            }

        } // try

        //TODO: Have it so that when the length of the string ends - then you add the rest of the nodes to the ends of the ans and it doesnt directly go to the catch block
        //

        catch (Exception e){}
        return ans;
    }

    public AbstractPolynomial subtract(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        double tempCoeff;
        try {
            DNode thisNode = this.data.getFirst();
            DNode pNode = p.data.getFirst();
            double coeff;

            while( thisNode != null || pNode != null ){
                Term thisNodeTerm = (Term)thisNode.getData();
                Term pNodeTerm = (Term)pNode.getData();
                //if one is greater than the other than add the node
                if(thisNodeTerm.getDegree() > pNodeTerm.getDegree()){
                    ans.data.addLast(thisNodeTerm);
                    thisNode = thisNode.getNext();
                }
                else if(thisNodeTerm.getDegree() < pNodeTerm.getDegree()){
                    tempCoeff = pNodeTerm.getCoefficient();
                    pNodeTerm.setCoefficient(-tempCoeff);
                    ans.data.addLast(pNodeTerm);
                    pNode = pNode.getNext();
                }
                else{
                    tempCoeff = pNodeTerm.getCoefficient();
                    pNodeTerm.setCoefficient(-tempCoeff);
                    coeff = thisNodeTerm.getCoefficient() + pNodeTerm.getCoefficient();
                    Term newTerm = new Term(coeff, thisNodeTerm.getDegree());
                    ans.data.addLast(newTerm);
                    thisNode = thisNode.getNext();
                    pNode = pNode.getNext();
                }
            } //while
        }catch (Exception e) {}
        return ans;
    }

    public AbstractPolynomial multiply(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        // TODO: multiply the two polynomials
        return ans;
    }

    /****************
     * MAIN FUNCTION
     ****************/

    public static void main(String args[]) throws Exception {
        //Variables
        Scanner scnr = new Scanner(System.in);
        AbstractPolynomial p, q;
        String testInput = "";
        //Custom test case
        if(scnr.hasNext()){
            testInput = scnr.nextLine();
            p = new Polynomial(testInput);
            testInput = scnr.nextLine();
            q = new Polynomial(testInput);
            System.out.println("User Input\n***************************");
            Utility.run(p, q);
        }
        //Default test case
        else{
            p = new Polynomial(" X^5");
            q = new Polynomial("X^2 - X + 1");
            System.out.println("Default Input\n***************************");
            Utility.run(p, q);
        }
    }
}