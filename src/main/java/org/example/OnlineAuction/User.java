package org.example.OnlineAuction;

import java.util.UUID;

public class User {
    private String name;
    private String id;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password){
        this.name=name;
        this.password=password;
        this.id="USER-"+ UUID.randomUUID().toString();
    }

}
