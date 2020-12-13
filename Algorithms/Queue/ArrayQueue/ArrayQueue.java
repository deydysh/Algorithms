package Queue.ArrayQueue;

import Queue.Execeptions.*;
import Queue.Queue;

public class ArrayQueue<T> implements Queue{
    private int capacity;
    private int size = 0;
    Object[] array;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    @Override
    public void add(Object data) throws  OverflowException{
        if (isFull()) throw new OverflowException();
        array[size] = (T)data;
        size++;
        capacity--;
    }

    @Override
    public T pop(){
        T tmp = (T)array[0];
        for (int i = 0; i < size-1; i++) {
            array[i] = array[i+1];
        }
        capacity++;
        size--;
        return tmp;
    }

    @Override
    public T peek(){
        return (T)array[0];
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
        for (int i = 0; i < size; i++) tmp += array[i] + " ";
        return tmp;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
