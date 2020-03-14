import java.util.*;
// I used this site as a reference: https://www.geeksforgeeks.org/multiplication-of-two-polynomials-using-linked-list/

public class Polynomial extends AbstractPolynomial {
    private int expo;
    private double coeff;

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
        // go through each polynomial in the array
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

//
//            try {
//                DNode current = data.getFirst();
//
//                boolean flag = false;
//                while (current != null) {
//                    Term currentTerm = (Term)current.getData();
//                    //if the coefficients match then add the coefficient of the newTerm and the current term of iteration
//                    if (currentTerm.getDegree() == expo) {
//                        currentTerm.setCoefficient(coeff + currentTerm.getCoefficient());
//                        flag = true;
//                        break;
//                    }
//                    current = current.getNext();
//                }//while
//                //if no matching coeff is found then create a new node and add it to the end of the linkedlist
//                if(!flag) data.addLast(newTerm);  //if there was nothing added then do not append it to the list
//            } //end of try block
//            //if there is no head node
//            catch (Exception e) {
//                data.addLast(newTerm);
//            } //end of catch

            // Inserting the terms in correct order
            //if the list is empty then add it to the beginning
            if(data.isEmpty()){
                data.addLast(newTerm);
            }
            else{
                DNode current = null;
                DNode newNode;
                Term currentTerm;
                // try to get the first term if it exits
                try{
                    current = data.getFirst();
                }
                catch (Exception e){}
                currentTerm = (Term) current.getData();
                // traverse through the list and find the best insertion point
                while (currentTerm != null && (currentTerm.getDegree() > newTerm.getDegree())){
                    current = current.getNext();
                    currentTerm = (Term) current.getData();
                }
                // a match has been found
                if(currentTerm != null){
                    //update the appropriate pointers
//                    currentTerm = (Term) current.getData();
                    // if the coefficient matches then add the values together
                    if(currentTerm.getDegree() == newTerm.getDegree()){
                        double newCoeff = currentTerm.getCoefficient() + newTerm.getCoefficient();
                        currentTerm.setCoefficient(newCoeff);
                    }else{ //else append it after
                        current = current.getPrev();
                        data.addAfter(newTerm, current);
                    }
                }else{
                    data.addLast(newTerm);
                }
            } //else
        } //for - going through each polynomial term


//        // -- now to remove duplicates from the data polynomial linked list
//        DNode ptr1 = null;
//        DNode ptr2 = null;
//
//        try{
//            ptr1 = data.getFirst();
//        }catch (Exception e){}
//
//        //Terms
//        Term ptr1Term = (Term)ptr1.getData();
//        Term ptr2Term;
//
//        while(ptr1Term != null){
//            ptr2 = ptr1.getNext();
//            ptr2Term = (Term)ptr2.getData();
//            while(ptr2Term != null){
//                ptr1Term = (Term)ptr1.getData();
//                if(ptr1Term.getDegree() == ptr2Term.getDegree()){
//                    ptr1Term.setCoefficient(ptr1Term.getCoefficient() + ptr2Term.getCoefficient());
//                    ptr2.setNext(ptr2.getNext().getNext());
//                }else {
//                    ptr2 = ptr2.getNext();
//                }
//                ptr2Term = (Term) ptr2.getData();
//            }// inner while - ptr2
//            ptr1 = ptr1.getNext();
//            ptr1Term = (Term) ptr1.getData();
//        } // outer while - ptr1

    }//constructor


    public Polynomial() {
        super();
    }

    public AbstractPolynomial add(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        DNode thisNode = null;
        DNode pNode = null;
        double coeff;

        System.out.println("It is coming to the add method");

        try {
            thisNode = this.data.getFirst();
            pNode = p.data.getFirst();
        } //end of try
        catch (Exception e) {} //end of catch

        Term thisNodeTerm = (Term) thisNode.getData();
        Term pNodeTerm = (Term) pNode.getData();

        //iterate through each linkedlist and add the values with matching degrees
        while (thisNodeTerm != null && pNodeTerm != null) {
            //if one is greater than the other than add the node
            if (thisNodeTerm.getDegree() > pNodeTerm.getDegree()) {
                ans.data.addLast(thisNodeTerm);
                thisNode = thisNode.getNext();
            }
            else if (thisNodeTerm.getDegree() < pNodeTerm.getDegree()) {
                ans.data.addLast(pNodeTerm);
                pNode = pNode.getNext();
            }
            // if they are equal then add them together
            else {
                coeff = thisNodeTerm.getCoefficient() + pNodeTerm.getCoefficient();
                Term newTerm = new Term(coeff, thisNodeTerm.getDegree());
                ans.data.addLast(newTerm);
                thisNode = thisNode.getNext();
                pNode = pNode.getNext();
            }

            //get the new terms of the iterated nodes
            thisNodeTerm = (Term) thisNode.getData();
            pNodeTerm = (Term) pNode.getData();
        } // while to add the polynomials together

        //merge the rest of the nodes until it is null
        while (thisNodeTerm != null) {
            thisNodeTerm = (Term) thisNode.getData();
            ans.data.addLast(thisNodeTerm);
            thisNode = thisNode.getNext();
        }

        while (pNodeTerm != null) {
            pNodeTerm = (Term) pNode.getData();
            ans.data.addLast(pNodeTerm);
            pNode = pNode.getNext();
        }

        return ans;
    } // add method

    public AbstractPolynomial subtract(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        double tempCoeff;
        DNode thisNode = null;
        DNode pNode = null;
        double coeff;

        System.out.println("It is coming to the subtract method");

        try {
            thisNode = this.data.getFirst();
            pNode = p.data.getFirst();
        }

        catch (Exception e){}

        Term thisNodeTerm = (Term) thisNode.getData();
        Term pNodeTerm = (Term) pNode.getData();
        Term tempTerm;
        // match the two matching degree terms together
        while( thisNodeTerm != null && pNodeTerm != null ){
            //if one is greater than the other than add the node
            if(thisNodeTerm.getDegree() > pNodeTerm.getDegree()){
                ans.data.addLast(thisNodeTerm);
                thisNode = thisNode.getNext();
            }
            else if(thisNodeTerm.getDegree() < pNodeTerm.getDegree()){
                tempCoeff = pNodeTerm.getCoefficient();
                tempTerm = new Term(-tempCoeff, pNodeTerm.getDegree());
                ans.data.addLast(tempTerm);
                pNode = pNode.getNext();
            }
            else{
                coeff = thisNodeTerm.getCoefficient() - pNodeTerm.getCoefficient();
                Term newTerm = new Term(coeff, thisNodeTerm.getDegree());
                ans.data.addLast(newTerm);
                thisNode = thisNode.getNext();
                pNode = pNode.getNext();
            }
            // get the terms of the next node
            thisNodeTerm = (Term)thisNode.getData();
            pNodeTerm = (Term)pNode.getData();
        } //while to subtract the common degree terms

        //merge the rest of the nodes until it is null
        while (thisNodeTerm != null) {
            ans.data.addLast(thisNodeTerm);
            thisNode = thisNode.getNext();
            thisNodeTerm = (Term)thisNode.getData();
        }

        while (pNodeTerm != null) {
            tempCoeff = pNodeTerm.getCoefficient();
            tempTerm = new Term(-tempCoeff, pNodeTerm.getDegree());
            ans.data.addLast(tempTerm);
            pNode = pNode.getNext();
            pNodeTerm = (Term)pNode.getData();
        }
        return ans;
    } //subtract method

    public AbstractPolynomial multiply(AbstractPolynomial p) {
        AbstractPolynomial ans = new Polynomial();
        DNode thisNode = null;
        DNode pNode = null;
        double newCoeff;
        int newExpo;

        System.out.println("It is coming to the multiply method ");

        try {
            thisNode = this.data.getFirst();
            pNode = p.data.getFirst();
        }
        catch (Exception e){}

        Term thisNodeTerm = (Term) thisNode.getData();
        Term pNodeTerm = (Term) pNode.getData();
        DNode current;
        Term newTerm;
        // loop that loops through each item in the first linked list
        while(thisNodeTerm != null){
            // loops through all elements from the second linked list
            while(pNodeTerm != null){
                newCoeff = thisNodeTerm.getCoefficient() * pNodeTerm.getCoefficient();
                newExpo = thisNodeTerm.getDegree() + pNodeTerm.getDegree();
                newTerm = new Term(newCoeff, newExpo);
                ans.data.addLast(newTerm);
                pNode = pNode.getNext();
                pNodeTerm = (Term) pNode.getData();
            }
            thisNode = thisNode.getNext();
            thisNodeTerm = (Term) thisNode.getData();

            //reset the value of pNodeTerm to the first node in the second list
            pNode = null;
            try {
                pNode = p.data.getFirst();
            } catch (Exception e) {}
            pNodeTerm = (Term) pNode.getData();
        }

        // ------------------------------------------------------------------- //
//        // Now to remove all the duplicates from the resulting ans linked list and merge it together
//        DNode ptr1 = null;
//        DNode ptr2 = null;
//        try {
//            ptr1 = ans.data.getFirst();
//        }
//        catch (Exception e){}
//
//        // these are the terms
//        Term ptr1Term = (Term) ptr1.getData();
//        Term ptr2Term;
//        // this finds a first pointer
//        while( ptr1Term != null ){
//            ptr2 = ptr1.getNext();
//            ptr2Term = (Term) ptr2.getData();
//            while( ptr2Term != null ){
//                ptr1Term = (Term) ptr1.getData();
//                if( ptr1Term.getDegree() == ptr2Term.getDegree()){
//                    ptr1Term.setCoefficient(ptr1Term.getCoefficient() + ptr2Term.getCoefficient());
//                    ptr2.setNext(ptr2.getNext().getNext()); // the next next term
//                }
//                else{
//                    ptr2 = ptr2.getNext();
//                }
//                ptr2Term = (Term) ptr2.getData();
//            } //while - ptr2
//            ptr1 = ptr1.getNext();
//            ptr1Term = (Term)ptr1.getData();
//        } //while - ptr1

        // TODO: create a more readable and simple remove duplicates method

















        return ans;
    } // multiply method

    /*****************
     * MAIN FUNCTION
     *****************/

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