package org.example.OnlineAuction;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private final Map<String, User> users;
    private static volatile UserManager instance;

    private UserManager(){
        users=new ConcurrentHashMap<String, User>();
    }
    public static UserManager getInstance(){
        if(instance==null){
            synchronized (UserManager.class){
                if(instance==null){
                    instance=new UserManager();
                }
            }
        }
        return instance;
    }
    public User addUser(String name, String password){
        User user=new User(name, password);
        users.putIfAbsent(user.getName(),user);
        return user;
    }
    public boolean authenticate(String userName, String password){
        User user=users.get(userName);
        if(Objects.isNull(user)){
            System.out.println("Invalid username!");
            return false;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Invalid password!");
            return false;
        }
        return true;
    }


}
