package org.example.test.FoodDeliverySystem;

import java.util.UUID;

public class Menu {
    private String menuId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    private String menuName;
    private MenuAvailabilityStatus menuAvailabilityStatus;
    private double price;

    public Menu(String menuName, double price) {
        this.menuName = menuName;
        this.menuAvailabilityStatus = MenuAvailabilityStatus.AVAILABLE;
        this.price = price;
        this.menuId="MEN"+ UUID.randomUUID().toString().substring(0,8);
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuAvailabilityStatus getMenuAvailabilityStatus() {
        return menuAvailabilityStatus;
    }

    public void setMenuAvailabilityStatus(MenuAvailabilityStatus menuAvailabilityStatus) {
        this.menuAvailabilityStatus = menuAvailabilityStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuAvailabilityStatus=" + menuAvailabilityStatus +
                ", price=" + price +
                '}';
    }
}
