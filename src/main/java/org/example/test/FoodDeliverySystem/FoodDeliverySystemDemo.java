package org.example.test.FoodDeliverySystem;

import org.example.test.FoodDeliverySystem.Payment.UPIPayment;

import java.time.LocalDate;
import java.util.List;

public class FoodDeliverySystemDemo {
    public static void main(String[] args) {
        FoodDeliverySystem swiggy=FoodDeliverySystem.getInstance();

        //restaurants
        Address address=new Address("Hyderabad","Telangana","500097","Ind","123 kharmanghat 1A");
        Restaurant restaurant=new Restaurant("Santosh Dhaba", address);

        Menu menuItem1=new Menu("Paneer Tikka Masala",200.4);
        Menu menuItem2=new Menu("Gobi Manchurian",120);
        Menu menuItem3=new Menu("Naan",20);
        Menu menuItem4=new Menu("Paneer Biryani",300);

        restaurant.addMenu(menuItem1);
        restaurant.addMenu(menuItem2);
        restaurant.addMenu(menuItem3);
        restaurant.addMenu(menuItem4);

        Address address1=new Address("PIttsburgh","Pennsylvania","15220","USA","1234 Pittsburgh Ave");
        Restaurant restaurant1=new Restaurant("Mintt", address);
        Menu menuItem11=new Menu("Paneer Tikka Masala",20.4);
        Menu menuItem22=new Menu("Gobi Manchurian",12);
        Menu menuItem33=new Menu("Naan",3);
        Menu menuItem44=new Menu("Paneer Biryani",18);

        restaurant1.addMenu(menuItem11);
        restaurant1.addMenu(menuItem22);
        restaurant1.addMenu(menuItem33);
        restaurant1.addMenu(menuItem44);

        //register restaurants
        swiggy.addRestaurant(restaurant);
        swiggy.addRestaurant(restaurant1);


        Customer customer=new Customer("Vikas","Vikas@vikas.com","123456789", LocalDate.now().minusYears(25).minusMonths(7).minusDays(3));

//        Delivery agents
        DeliveryAgent agent=new DeliveryAgent("Ramu","ramu@swiggy.com","1234567890");
        DeliveryAgent agent1=new DeliveryAgent("shyamu","shyamu@swiggy.com","1234567890");
        DeliveryAgent agent2=new DeliveryAgent("gopi","gopi@swiggy.com","1234567890");
        DeliveryAgent agent3=new DeliveryAgent("venu","venu@swiggy.com","1234567890");

        swiggy.registerDeliveryAgent(agent);
        swiggy.registerDeliveryAgent(agent1);
        swiggy.registerDeliveryAgent(agent2);
        swiggy.registerDeliveryAgent(agent3);


        List<Restaurant> restaurants=swiggy.findByName("Mintt");
        Restaurant rest=restaurants.get(0);
        //currently viewing
        System.out.println("currently viewing menu of "+ rest.getName());
        rest.getMenuItems().forEach(System.out::println);

        List<Menu>menuItem=rest.findByMenuItemName("Paneer");

        Cart cart=swiggy.addItemIntoCart(customer, menuItem.get(0),2);
        cart=swiggy.addItemIntoCart(customer, menuItem.get(1),3);

        Order order=swiggy.placeOrder(customer, cart,rest,new UPIPayment("1234567890@upi"));
        System.out.println(order.toString());

        System.out.println(swiggy.getOrderStatus(customer));
    }
}
