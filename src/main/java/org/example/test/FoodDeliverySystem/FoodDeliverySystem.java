package org.example.test.FoodDeliverySystem;

import org.example.test.FoodDeliverySystem.Payment.Payment;

import java.util.*;

public class FoodDeliverySystem {
    List<Restaurant> restaurantList;
    Map<String, Order> userOrders;
    Map<String, Cart> userCarts;
    OrderManager orderManager;

    private static FoodDeliverySystem instance;
    private FoodDeliverySystem(){
        this.restaurantList=new ArrayList<>();
        this.userOrders=new HashMap<>();
        this.userCarts=new HashMap<>();
        orderManager=new OrderManager();
    }
    public synchronized static FoodDeliverySystem getInstance(){
        if(Objects.isNull(instance)){
            instance=new FoodDeliverySystem();
        }
        return instance;
    }
    public List<Restaurant> findByName(String name){
        return this.restaurantList.stream().filter(restaurant -> restaurant.getName().equals(name)).toList();
    }
    public List<Menu> getMenuForRestaurant(String name){
        Restaurant rest=this.restaurantList.stream().filter(restaurant -> restaurant.getName().equals(name)).findFirst().orElse(null);
        if(rest==null)return null;
        return rest.getMenuItems();
    }
    public Cart addItemIntoCart(Customer customer, Menu menu, int qty){
        Cart cart=userCarts.getOrDefault(customer.getEmail(),new Cart());
        cart.addCartItem(new CartItem(menu,qty));
        userCarts.putIfAbsent(customer.getEmail(), cart);
        return cart;
    }
    public void removeItemFromCart(Customer customer, CartItem item){
        userCarts.get(customer).removeCartItem(item);
    }
    public Cart getUserCart(Customer customer){
        return userCarts.get(customer);
    }
    public Order placeOrder(Customer customer, Cart cart, Restaurant restaurant, Payment payment){
        Order order=new Order(cart);
        userOrders.put(customer.getEmail(), order);
        boolean confirmation= payment.makePayment(cart.getCartTotal()) && restaurant.confirmOrder(order);
        if(confirmation){
            orderManager.notifyDeliveryAgent(order);
        }
        return order;
    }
    public OrderStatus getOrderStatus(Customer customer){
        return userOrders.get(customer.getEmail()).getOrderStatus();
    }
    public void registerDeliveryAgent(DeliveryAgent agent){
         orderManager.addDeliveryAgent(agent);
    }
    public void addRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
    }

}
