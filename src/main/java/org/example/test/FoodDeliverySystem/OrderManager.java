package org.example.test.FoodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class OrderManager implements OrderSystem {
    private final List<DeliveryAgent> deliveryAgentList;
    public OrderManager(){
        this.deliveryAgentList=new ArrayList<>();
    }

    @Override
    public void addDeliveryAgent(DeliveryAgent agent) {
        deliveryAgentList.add(agent);
    }

    @Override
    public void removeDeliveryAgent(DeliveryAgent agent) {
        deliveryAgentList.remove(agent);
    }

    @Override
    public void notifyDeliveryAgent(Order orderInfo) {
        for (DeliveryAgent agent : this.deliveryAgentList) {
            agent.update(orderInfo);
        }
    }
}
