package org.example.test.FoodDeliverySystem;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class DeliveryAgent extends Person implements DeliverySubscriber{
    Random random;
    public DeliveryAgent(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        random=new Random();
    }

    @Override
    public void update(Order order) {
        if(pickOrNotPick()){
            boolean assignedSuccessfully=order.setAgentAssigned(this);
            if(assignedSuccessfully){
                this.simulateOrderLifeCycle(order);
            }
        }
    }
    private void simulateOrderLifeCycle(Order order){
        Timer timer=new Timer();
        TimerTask task = new TimerTask() {
            int step=0;
            @Override
            public void run() {
                switch (step){
                    case 0:
                        order.setOrderStatus(OrderStatus.PICKED);
                        break;
                    case 1:
                        order.setOrderStatus(OrderStatus.ARRIVING);
                        break;
                    case 2:
                        order.setOrderStatus(OrderStatus.DELIVERED);
                        timer.cancel();
                        break;
                }
                step++;
            }
        };
        timer.schedule(task,0,5000);
    }
    private boolean pickOrNotPick(){
        return random.nextBoolean();
    }
}
