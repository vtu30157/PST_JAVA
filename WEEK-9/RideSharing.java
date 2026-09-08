package ridesharing;

import java.util.Scanner;

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Vehicle {
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

abstract class Trip {
    double distance;

    Trip(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bike extends Trip {

    Bike(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 10;
    }
}

class Auto extends Trip {

    Auto(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 15;
    }
}

class Cab extends Trip {

    Cab(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 20;
    }
}

class InvalidBookingException extends Exception {

    InvalidBookingException(String message) {
        super(message);
    }
}

public class RideSharing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            String rideType = sc.next();
            double distance = sc.nextDouble();

            try {

                if (distance <= 0) {
                    throw new InvalidBookingException(
                        "Invalid booking"
                    );
                }

                Trip trip;

                if (rideType.equalsIgnoreCase("Bike")) {
                    trip = new Bike(distance);
                }
                else if (rideType.equalsIgnoreCase("Auto")) {
                    trip = new Auto(distance);
                }
                else if (rideType.equalsIgnoreCase("Cab")) {
                    trip = new Cab(distance);
                }
                else {
                    throw new InvalidBookingException(
                        "Invalid booking"
                    );
                }

                System.out.println((int) trip.calculateFare());

            }
            catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}