package com.company;

public class BookingStatus {
    double distance;
    double estimatedFare;
    Driver driver;
    boolean status;
    public BookingStatus(double distance, double estimatedFare, Driver driver,boolean status) {
        this.distance = distance;
        this.estimatedFare = estimatedFare;
        this.driver = driver;
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingStatus{" +
                "distance=" + distance +
                ", estimatedFare=" + estimatedFare +
                ", driver=" + driver.getDriverName() +
                ", status=" + status +
                '}';
    }
}
