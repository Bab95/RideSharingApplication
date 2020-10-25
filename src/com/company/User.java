package com.company;

import java.util.ArrayList;

public class User {
    private String userName;
    private String userId;
    private ArrayList<Ride> Rides;
    private Double rating;
    private String mobileNumber;
    private RideService rideService;
    public User(String userName, String userId,String mobileNumber) {
        this.userName = userName;
        this.userId = userId;
        this.mobileNumber = mobileNumber;
        this.Rides = new ArrayList<>();
        rideService = RideService.getInstance();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public BookingStatus bookRide(Location source,Location destination){
        Ride ride = new Ride(source, destination);
        BookingStatus bookingStatus = rideService.requestRide(ride);
        if(bookingStatus.status==false){
            System.out.println("::::::NO BOOKING FOUND:::::::::::");
            return null;
        }
        System.out.println( bookingStatus.toString());
        return bookingStatus;
    }

}
