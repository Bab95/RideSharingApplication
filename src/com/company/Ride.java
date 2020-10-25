package com.company;

public class Ride {
    Location source;
    Location destination;
    RideStatus rideStatus;

    public Ride(Location source, Location destination) {
        this.source = source;
        this.destination = destination;
    }

    public double Distance(Location driverLocation, Location riderLocation){
        int a = Integer.parseInt(driverLocation.getLatitude());
        int b = Integer.parseInt(driverLocation.getLogitude());
        int c = Integer.parseInt(riderLocation.getLatitude());
        int d = Integer.parseInt(riderLocation.getLogitude());
        return Math.sqrt((c-a)*(c-a) + (b-d)*(b-d));
    }
    public double calculateFare(){
        double distance = Distance(source,destination);
        double fare = distance*10 + 25;
        return fare;
    }
}
