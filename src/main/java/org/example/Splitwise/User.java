package org.example.Splitwise;

import java.util.HashMap;
import java.util.Map;

public class User implements Observer{
    private String name;
    private String userId;
    private Map<User, Double> balanceMap;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.balanceMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<User, Double> getBalanceMap() {
        return balanceMap;
    }

    public void updateBalance(User user, double amnt) {
        this.balanceMap.put(user, this.balanceMap.getOrDefault(user,0D)+amnt);
    }

    @Override
    public void receiveUpdate(String message) {
        System.out.println("[Notification]: "+ message+" ");
    }
}
