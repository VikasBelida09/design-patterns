package org.example.test.HotelBookingManagement;

public class Guest {
    private String name;
    private String phoneNumber;
    private String nationalIdentity;
    private Address address;

    private String email;
    private String id;

    public String getId() {
        return id;
    }

    public Guest(String name, String phoneNumber, String nationalIdentity, Address address, String email, String id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalIdentity = nationalIdentity;
        this.address = address;
        this.email = email;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
