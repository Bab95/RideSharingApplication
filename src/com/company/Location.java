package com.company;

public class Location {
    private String latitude;
    private String logitude;

    public Location(String latitude, String logitude) {
        this.latitude = latitude;
        this.logitude = logitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLogitude() {
        return logitude;
    }

    public void setLogitude(String logitude) {
        this.logitude = logitude;
    }
}
