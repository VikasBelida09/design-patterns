package org.example.test.FoodDeliverySystem;

import java.util.UUID;

public class Order {
   private Cart cart;
   OrderStatus orderStatus;
   DeliveryAgent agentAssigned;

   private String orderId;
   public Order(Cart cart){
       this.cart=cart;
       this.orderStatus=OrderStatus.NOT_CONFIRMED;
       agentAssigned=null;
       this.orderId="ORD"+ UUID.randomUUID().toString().substring(0,8);
   }
   public void updateOrderStatus(){

   }
   public double getOrderTotal(){
       return this.cart.getCartTotal();
   }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        System.out.println("Order status updated to: " + orderStatus);
    }

    public DeliveryAgent getAgentAssigned() {
        return agentAssigned;
    }

    public synchronized boolean setAgentAssigned(DeliveryAgent agentAssigned) {
       if(this.agentAssigned==null){
           this.agentAssigned = agentAssigned;
           System.out.println("Your Order:"+this.orderId +" has been assigned to "+agentAssigned.getName());
           return true;
       }
       return false;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cart=" + cart +
                ", orderStatus=" + orderStatus +
                ", agentAssigned=" + agentAssigned +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
