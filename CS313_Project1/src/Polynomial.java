import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



//resources:
//https://stackoverflow.com/questions/56041285/how-do-i-get-the-coefficients-and-exponents-from-a-polynomial-string
//https://stackoverflow.com/questions/48502209/how-to-evaluate-a-polynomial-given-as-a-string
//https://stackoverflow.com/questions/28859919/java-regex-separate-degree-coeff-of-polynomial

/**
 * This class creates a polynomial from a user input string
 * and allows user multiplication, addition, subtraction and division.
 * @author Hasanat
 */

public class Polynomial extends PolynomialInterface {
    private int expo;
    private double coeff;
    private DList PList; //this has a dummy node by it's default constructor

    // this constructor should change it to canonical form
    public Polynomial(String s) {
        PList = new DList();

        // adds all the polynomial strings to a list
        List<String> list = Arrays.asList(s.split("(?!^-)(?=[+-])"));
        ArrayList<String> polyStrs = new ArrayList<String>();
        // populate an Arraylist with the desired polynomials
        for (String str : list) {
            polyStrs.add(str);
        }

        String polyStr = "";
        //create a new Datanode for each polynomial and append it to the PList
        for (int i = 0; i < polyStrs.size(); i++) {
            polyStr = polyStrs.get(i);

            //this part extractes the expo
            String[] expParts = polyStr.split("\\^");
            //setting the value of expStr
            String expoStr = "";
            if (expParts.length > 1) {
                expoStr = expParts[1].replace(" ", "");
            } else {
                if (expParts[0].contains("X")) {
                    expoStr = "1";
                } else {
                    expoStr = "0";
                }
            }

            //this extracts the coefficient
            String[] coeffParts = polyStr.replace(" ", "").split("[a-zA-Z]");
            String coeffStr = "";

            if (coeffParts[0].equalsIgnoreCase("-")) {
                coeffStr = "-1";
            } else if (coeffParts[0].equals("")) {
                coeffStr = "1";
            } else {
                coeffStr = coeffParts[0].replace(" ", "");
            }

            //here you create the term
            expo = Integer.parseInt(expoStr);
            coeff = Double.parseDouble(coeffStr);
            Term term = new Term(coeff, expo);


            // Change this to try and catch
            try {
                DNode current = PList.getFirst();
                Term currentTerm = (Term) current.getData();
                while (current.getNext() != null) {
                    //if the coefficients match then add them together
                    if (currentTerm.getCoefficient() == coeff) {
                        currentTerm.setCoefficient(coeff + currentTerm.getCoefficient());
                    }
                    current.getNext();
                }//while

                //if no matching coeff is found then create a new node and add it to the
                DNode polyNode = new DNode(currentTerm, PList.getLast(), null);

            } catch (Exception e) {
                DNode firstNode = new DNode(term, null, null);
                PList.addFirst(firstNode);
            }//end of catch


        } //for - going through each polynomial

    }//constructor


    public Polynomial() {
        super();
    }

    public PolynomialInterface add(PolynomialInterface p) {
        PolynomialInterface ans = new Polynomial();
        // TODO make an add function that takes two polynomials and adds them together
        //The data of a polynomial interface p is data
//        DList pList = p.data;
//        DNode thisNode = (DList)this.getFirst();
//        DNode pNode = p.getFirst();
        Polynomial thisPoly = new Polynomial();
        Polynomial pPoly = new Polynomial();
        return ans;
    }

    public PolynomialInterface subtract(PolynomialInterface p) {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        return ans;
    }

    public PolynomialInterface multiply(PolynomialInterface p) {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        return ans;
    }

    /****************
     * MAIN FUNCTION
     ****************/

    public static void main(String args[]) throws Exception {
        //Variables
        Scanner scnr = new Scanner(System.in);
        PolynomialInterface p, q;
        String testInput = "";
        //Custom test case
//        if(scnr.hasNext()){
//            testInput = scnr.nextLine();
//            p = new Polynomial(testInput);
//            testInput = scnr.nextLine();
//            q = new Polynomial(testInput);
//            System.out.println("User Input\n***************************");
//            Utility.run(p, q);
//        }
        //Default test case
//        else{
            p = new Polynomial(" X^5");
            q = new Polynomial("2X^2 - X + 1");
            System.out.println("Default Input\n***************************");
            Utility.run(p, q);
//        }
    }
}