package Queue;

import Queue.ArrayQueue.ArrayQueue;
import Queue.Execeptions.OverflowException;

public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue<Auto>(5);
        Auto auto = new Auto(0, 0, 0);
        try { queue.add(auto); }
        catch (OverflowException ex) {

        }
    }
}
