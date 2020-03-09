public class Solution<T> {
    public int count(LinkedStack<T> s, T x) {

        /*TODO: find the number of occurrences of a certain elem
         */
        //this keeps count of the number of occurrences found
        int num = 0;

        //if the stack is empty then there are no occurrences
        if(s.empty()) return 0;

        //else if the stack is not empty
        //create a new stack to hold the popped values
        LinkedStack<T> tempList = new LinkedStack<>();
        T item;
        //this counts the number of occurrences
        while (!s.empty()){
            try {
                item = s.pop();
                tempList.push(item);
                //if the item is the same
                if(x.equals(item)) {
                    num++;
                }
            } catch (Exception e) {}
        } //while

        T tempItem;
        //now transfer back the values from temp to original stack
        while(!tempList.empty()){
            try {
                tempItem = tempList.pop();
                s.push(tempItem);

            } catch (Exception e) {}
        } //while

        return num;
    } //count method
}