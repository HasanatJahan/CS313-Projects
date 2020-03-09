import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String contactName;
        String phoneNumber;
        /* Type your code here. */
        ArrayList<ContactNode> contactsArr = new ArrayList<ContactNode>();

        //taking the data from the user and create a new object
        for(int i = 0; i < 3; i++){
            System.out.println("Person " + (i+1));
            System.out.println("Enter name:");
            contactName = scnr.nextLine();
            System.out.println("Enter phone number:");
            phoneNumber = scnr.nextLine();
            System.out.println("You entered: " + contactName + ", " + phoneNumber);
            System.out.println();
            contactsArr.add(new ContactNode(contactName, phoneNumber));
        }

        //iterate through the arraylist and set the pointer to be the next
        for(int i=0; i< contactsArr.size()-1; i++){
            contactsArr.get(i).insertAfter(contactsArr.get(i), contactsArr.get(i+1));
        }
        contactsArr.get(contactsArr.size()-1).nextNodePtr = null;

        //now to print it
        for(int i = 0; i< contactsArr.size(); i++){
            ContactNode.printContactNode(contactsArr.get(i));
        }

    }
}
