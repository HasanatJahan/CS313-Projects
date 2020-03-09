public class ItemNode {
    private String item;
    private ItemNode nextNodeRef; // Reference to the next node

    public ItemNode() {
        item = "";
        nextNodeRef = null;
    }

    // Constructor
    public ItemNode(String itemInit) {
        this.item = itemInit;
        this.nextNodeRef = null;
    }

    // Constructor
    public ItemNode(String itemInit, ItemNode nextLoc) {
        this.item = itemInit;
        this.nextNodeRef = nextLoc;
    }

    // Insert node after this node.
    public void insertAfter(ItemNode nodeLoc) {
        ItemNode tmpNext;

        tmpNext = this.nextNodeRef;
        this.nextNodeRef = nodeLoc;
        nodeLoc.nextNodeRef = tmpNext;
    }

    // TODO: Define insertAtEnd() method that inserts a node
    //       to the end of the linked list
    public void setNext(ItemNode nextNode){
        this.nextNodeRef = nextNode;
    }

    public void insertAtEnd(ItemNode headNode, ItemNode currNode){
        //if head is null
        if(headNode.getNext() == null){
            headNode.setNext(currNode);;
        }
        else{
            this.setNext(currNode);
        }

        // JUST LEAVING THIS HERE AS A REMINDER OF THE BIG IDIOT I AM 
//        else{
////            ItemNode temp = headNode.getNext();
//            int count = 1;
//            ItemNode temp = headNode.getNext();
//            ItemNode tail = headNode.getNext();
//            while (tail != null){
//                count ++;
//                tail = tail.getNext();
//            }
//            //this finds the tail
////            currNode.setNext(null);
//
//            //traverse through the list upto count
//            for(int i = 1; i<= count; i++){
//                temp.getNext();
//            }
//            temp.insertAfter(currNode);
//        }
    }

    // Get location pointed by nextNodeRef
    public ItemNode getNext() {
        return this.nextNodeRef;
    }

    public void printNodeData() {
        System.out.println(this.item);
    }
}