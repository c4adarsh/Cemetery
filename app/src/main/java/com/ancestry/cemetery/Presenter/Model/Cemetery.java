package com.ancestry.cemetery.Presenter.Model;


/**
 * Created by adarsh on 4/4/2017.
 */

public class Cemetery {

    int cemeteryId;

    String cemeteryName;

    String latitude;

    String longitude;

    String streetAddress;

    String cityName;

    String StateName;

    String countryName;


    public Cemetery(int cemeteryId, String cemeteryName, String latitude, String longitude, String streetAddress, String cityName, String stateName, String countryName) {
        this.cemeteryId = cemeteryId;
        this.cemeteryName = cemeteryName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.cityName = cityName;
        StateName = stateName;
        this.countryName = countryName;
    }

    public int getCemeteryId() {
        return cemeteryId;
    }

    public void setCemeteryId(int cemeteryId) {
        this.cemeteryId = cemeteryId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getcemeteryId() {
        return cemeteryId;
    }

    public void setcemeteryId(int cemeteryId) {
        this.cemeteryId = cemeteryId;
    }

    public String getCemeteryName() {
        return cemeteryName;
    }

    public void setCemeteryName(String cemeteryName) {
        this.cemeteryName = cemeteryName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

