package Queue.ListQueue;

import Queue.Execeptions.*;
import Queue.Queue;

public class ListQueue<T> implements Queue{

    private int size = 0;
    private int capacity;
    private Node first = null;

    public ListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(Object data) throws OverflowException {
        if (isFull()) throw new OverflowException();
        Node new_node = new Node((T) data);
        if (size == 0)
            first = new_node;
        else {
            Node current = first;
            while (current.getNext() != null)
                current = current.getNext();
            current = current.getNext();
            current = new_node;
        }
        size++;
        capacity--;
    }

    @Override
    public T pop() {
        T tmp = (T)first.getData();
        first = first.getNext();
        size--;
        capacity++;
        return tmp;
    }

    @Override
    public T peek(){
        return (T)first.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == 0;
    }

    @Override
    public String toString() {
        String tmp = "";
        Node current = first;
        while (current.getNext() != null) {
            tmp+=current.getData() + " ";
        }
        return tmp;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
