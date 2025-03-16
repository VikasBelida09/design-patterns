package org.example.Twitter;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String username){
        super("User: "+username+" Not found!");
    }

}
