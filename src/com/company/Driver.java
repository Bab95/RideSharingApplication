package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
    private String driverName;
    private String driverId;
    private String mobileNumber;
    private ArrayList<Ride> ridesCompleted;
    public Location currentLocation;
    public ArrayList<Ride> notifications;
    public Driver(String driverName, String driverId, String mobileNumber) {
        this.driverName = driverName;
        this.driverId = driverId;
        this.mobileNumber = mobileNumber;
        this.ridesCompleted = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Ride acceptRide(){
        int n = notifications.size();
        int r = new Random().nextInt(n);
        int t = new Random().nextInt(2);
        if(t==1)
            return notifications.get(r);
        return null;
    }

}
