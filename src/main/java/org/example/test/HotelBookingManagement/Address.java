package org.example.test.HotelBookingManagement;


public class Address {
    private String city;
    private String country;
    private String pinCode;
    private String state;
    private String district;

    public Address(String city, String country, String pinCode, String state, String district) {
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
        this.state = state;
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
