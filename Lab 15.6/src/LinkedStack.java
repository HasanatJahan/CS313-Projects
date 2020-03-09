public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public T pop() throws Exception {
        if (empty())
            throw new Exception();
        T answer = top.getData();
        top = top.getNext();
        size--;
        return answer;
    }

    public void push(T x) {
        top = new Node<>(x, top);
        size++;
    }

    public String toString() {
        StringBuilder ans = new StringBuilder("Linked Stack<T>:  ");
        Node<T> n = top;
        while (n != null) {
            ans.append(n.getData()).append(" -> ");
            n = n.getNext();
        }
        return ans.toString();
    }
}
