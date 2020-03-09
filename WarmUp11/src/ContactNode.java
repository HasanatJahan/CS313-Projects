/* Type code here. */
/**

 Public member methods
 insertAfter() (2 pts)
 printContactNode()
 * */

public class ContactNode{
    private String contactName;
    private String contactPhoneNumber;
    ContactNode nextNodePtr;

    public ContactNode(String newContactName, String newContactPhoneNumber){
        contactName = newContactName;
        contactPhoneNumber  = newContactPhoneNumber;
        nextNodePtr = null;
    }

    // Accessor
    public String getName(){
        return contactName;
    }

    public String getPhoneNumber(){
        return contactPhoneNumber;
    }

    public ContactNode getNext(){
        return nextNodePtr;
    }

    public void insertAfter(ContactNode curr, ContactNode newNode) {
        newNode.nextNodePtr = curr.nextNodePtr;
        curr.nextNodePtr = newNode;
    }

    public static void printContactNode(ContactNode n){
        System.out.println("Name: " + n.getName());
        System.out.println("Phone number: " +  n.getPhoneNumber());
        System.out.println();
    }

}










 