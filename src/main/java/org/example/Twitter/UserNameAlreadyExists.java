package org.example.Twitter;

public class UserNameAlreadyExists extends RuntimeException{
    UserNameAlreadyExists(String name){
        super("username "+name+" already exists");
    }
}
