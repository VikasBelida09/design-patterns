package org.example.test.BookMyShow;

public class Address{
    private String city;
    private String pinCode;
    private String streetName;
    private String state;
    private String country;

    public Address(String city, String pinCode, String streetName, String state, String country) {
        this.city = city;
        this.pinCode = pinCode;
        this.streetName = streetName;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
