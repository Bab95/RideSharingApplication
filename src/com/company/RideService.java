package com.company;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RideService {
    private static RideService rideService;
    private Map<String,User> registeredUsers;
    private Map<String,Driver> registeredDriver;
    private ArrayList<Driver> activeDrivers;
    private RideService(){
        System.out.println("::::::::::INITIALIZING RIDE SERVICE! THIS TAKE A FEW SECONDS::::::::::::::");
        registeredDriver = new HashMap<>();
        registeredUsers = new HashMap<>();
        activeDrivers = new ArrayList<>();
    }

    public static RideService InitializeRideService(){
        if(rideService==null){
            rideService = new RideService();
        }
        return rideService;
    }
    public static RideService getInstance(){
        if(rideService==null){
            System.out.println("Ride Service is not Working!!!!Sorry for the incovenience!!!!");
            return null;
        }
        return rideService;
    }
    public String generateId(){
        byte arr[] = new byte[7];
        new Random().nextBytes(arr);
        String userId = new String(arr, Charset.forName("UTF-8"));
        return userId;
    }
    public userRegistrationStatus  registerUser(String userName,String mobileNumber){
        if(registeredUsers.containsKey(mobileNumber)){
            return userRegistrationStatus.USER_ALREADY_EXITS;
        }
        User user = new User(userName,mobileNumber,rideService.generateId());
        registeredUsers.put(mobileNumber,user);
        return userRegistrationStatus.REGISTRAION_COMPLETE;
    }

    public driverRegistrationStatus registerDriver(String driverName,String mobileNumber){
        if(registeredDriver.containsKey(mobileNumber)){
            return driverRegistrationStatus.DRIVER_DATA_ALREADY_EXISTS;
        }
        Driver driver = new Driver(driverName,mobileNumber,rideService.generateId());
        registeredDriver.put(mobileNumber,driver);
        return driverRegistrationStatus.REGISTRAION_COMPLETE;
    }
    public double Distance(Location driverLocation,Location riderLocation){
        int a = Integer.parseInt(driverLocation.getLatitude());
        int b = Integer.parseInt(driverLocation.getLogitude());
        int c = Integer.parseInt(riderLocation.getLatitude());
        int d = Integer.parseInt(riderLocation.getLogitude());
        return Math.sqrt((c-a)*(c-a) + (b-d)*(b-d));
    }

    private void notify(ArrayList<Driver> eligibleDrivers,Ride ride){
        for(Driver driver:eligibleDrivers){
            driver.notifications.add(ride);
        }
    }

    public BookingStatus requestRide(Ride ride){
        ArrayList<Driver> eligibleDrivers = new ArrayList<>();
        for(Driver driver : activeDrivers){
            if(rideService.Distance(driver.currentLocation,ride.source)==10){
                eligibleDrivers.add(driver);
            }
        }
        if(eligibleDrivers.size()==0){
            //Increment search Parameter.......
            //but here i am considering only one loop for searching.....
            return new BookingStatus(0,0,null,false);
        }else {
            notify(eligibleDrivers,ride);
            for(Driver driver:eligibleDrivers){
                if(driver.acceptRide()==ride){
                    return new BookingStatus(Distance(ride.source,ride.destination),ride.calculateFare(),driver,true);
                }
            }
        }
        return null;
    }
}
