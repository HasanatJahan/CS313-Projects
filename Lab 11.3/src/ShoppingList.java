import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

public class ShoppingList {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        // TODO: Declare a LinkedList called shoppingList of type ListItem
        LinkedList<ListItem> shoppingList = new LinkedList<ListItem>();
        String item;

        // TODO: Scan inputs (items) and add them to the shoppingList LinkedList
        //       Read inputs until a -1 is input
        item = scnr.nextLine();
        while(!item.equals("-1")){
            ListItem listNode = new ListItem(item);
            shoppingList.add(listNode);
            item = scnr.nextLine();
        }


        // TODO: Print the shoppingList LinkedList using the printNodeData() method
//        for(Iterator i = shoppingList.iterator(); i.hasNext(); ) (i.next()).printNodeData();
        for(int i = 0; i<shoppingList.size(); i++){
            shoppingList.get(i).printNodeData();
        }

    }
}