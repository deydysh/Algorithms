package Queue;

import Queue.ArrayQueue.ArrayQueue;
import Queue.Execeptions.OverflowException;

import java.util.Scanner;

public class CarWash {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        Scanner input = new Scanner(System.in);
        int arrivalTime = 0;
        int waitingTime = 0;
        int departureTime = 0;
        int autoCounter = 0;
        while (true) {
            arrivalTime = input.nextInt();
            if (arrivalTime == 999) {
                while (!queue.isEmpty()) {
                    Auto auto = (Auto) queue.peek();
                    waitingTime += auto.getWaitingTime();
                    System.out.println("Departure time = " + auto.getDepartureTime());
                    queue.pop();
                    autoCounter++;
                }
                break;
            }
            else {
                if (arrivalTime >= departureTime) {
                    while (!queue.isEmpty()) {
                        Auto auto = (Auto) queue.peek();
                        waitingTime += auto.getWaitingTime();
                        System.out.println("Departure time = " + auto.getDepartureTime());
                        queue.pop();
                        autoCounter++;
                    }
                    departureTime = arrivalTime + 10;
                    System.out.println("Departure time = " + departureTime);
                    autoCounter++;
                } else {
                    try {
                        if (arrivalTime < departureTime) {
                            Auto auto = new Auto(arrivalTime, departureTime + 10, departureTime - arrivalTime);
                            queue.add(auto);
                            departureTime += 10;

                        }
                    } catch (OverflowException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        System.out.println("Number of served cars: " + autoCounter);
        System.out.println("Waiting time: " + waitingTime);
        System.out.println("Average waiting time: " + (float)waitingTime/autoCounter);
    }
}
