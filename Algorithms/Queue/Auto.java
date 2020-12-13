package Queue;

public class Auto {
    private int arrivalTime;
    private int departureTime;
    private int waitingTime;

    public Auto(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Auto(int arrivalTime, int departureTime, int waitingTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.waitingTime = waitingTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }
}
