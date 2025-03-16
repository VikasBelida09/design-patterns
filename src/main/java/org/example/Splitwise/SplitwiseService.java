package org.example.Splitwise;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SplitwiseService {
    private static SplitwiseService instance;
    private final Map<String, User> users;
    private final Map<String, Group>groups;
    private final AtomicInteger groupIdCounter=new AtomicInteger();
    private SplitwiseService(){
        users=new ConcurrentHashMap<>();
        groups=new ConcurrentHashMap<>();
    }
    public static SplitwiseService getInstance(){
        if(instance==null){
            synchronized (SplitwiseService.class){
                if(instance==null){
                    instance=new SplitwiseService();
                }
            }
        }
        return instance;
    }
    public Group addGroup(String groupName){
        Group group=new Group(groupName);
        int groupId=groupIdCounter.incrementAndGet();
        group.setGroupId(MessageFormat.format("{0}", groupId));
        groups.put(group.getGroupId(), group);
        return group;
    }
    public void addUser(User user){
        users.put(user.getUserId(),user);
    }
    public void addExpense(Expense expense, String groupId){
        Group group=groups.get(groupId);
        if(group!=null){
            group.addExpense(expense);
        }
    }
    public void showGroups(){
        for(Map.Entry<String, Group>groupEntry: groups.entrySet()){
            System.out.println(groupEntry.getValue());
        }
    }
}
