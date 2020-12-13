package Queue.Execeptions;

public class OverflowException extends Exception{
    public OverflowException() {
        super("The queue is full!");
    }
}
