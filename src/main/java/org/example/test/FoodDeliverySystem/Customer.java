package org.example.test.FoodDeliverySystem;

import java.time.LocalDate;
import java.util.List;

public class Customer extends Person {
    private LocalDate dob;
    private List<Address> addressList;

    public Customer(String name, String email, String phoneNumber, LocalDate dob) {
        super(name, email, phoneNumber);
        this.dob = dob;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
