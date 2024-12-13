package org.example.test.FoodDeliverySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class Restaurant {
    private String restaurantId;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    private String name;
    private final List<Menu> menuItems;
    private Address address;

    public Restaurant(String name, Address address){
        this.name=name;
        this.address=address;
        this.menuItems=new ArrayList<>();
        this.restaurantId="RES"+ UUID.randomUUID().toString().substring(0,8);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenuItems() {
        return menuItems;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public List<Menu> findByMenuItemName(String name){
        return this.menuItems.stream().filter(menu->menu.getMenuName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
    public void updateMenuItemPrice(Menu menu, double price){
        Menu filteredMenu=this.menuItems.stream().filter(m->m.getMenuId().equals(menu.getMenuId())).findFirst().orElse(null);
        if(Objects.isNull(filteredMenu)) return;
        filteredMenu.setPrice(price);
    }
    public void updateMenuItemAvailability(Menu menu, MenuAvailabilityStatus status){
        Menu filteredMenu=this.menuItems.stream().filter(m->m.getMenuId().equals(menu.getMenuId())).findFirst().orElse(null);
        if(Objects.isNull(filteredMenu)) return;
        filteredMenu.setMenuAvailabilityStatus(status);
    }
    public void updateMenuItemName(Menu menu, String name){
        Menu filteredMenu=this.menuItems.stream().filter(m->m.getMenuId().equals(menu.getMenuId())).findFirst().orElse(null);
        if(Objects.isNull(filteredMenu)) return;
        filteredMenu.setMenuName(name);
    }
    public void addMenu(Menu menu){
        this.menuItems.add(menu);
    }
    public void removeMenu(Menu menu){
        this.menuItems.remove(menu);
    }

   public boolean confirmOrder(Order order){
        order.setOrderStatus(OrderStatus.CONFIRMED);
        return true;
   }
}
