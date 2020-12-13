package Queue;

import Queue.Execeptions.OverflowException;

public interface Queue {
    public void add (Object data) throws OverflowException;
    public Object pop();
    public Object peek();
    public boolean isEmpty();
    public boolean isFull();
}
