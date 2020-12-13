package Queue.ListQueue;

public class Node<T> {
    private T data;
    private Node next = null;

    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
