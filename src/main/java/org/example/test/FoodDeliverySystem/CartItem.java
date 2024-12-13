package org.example.test.FoodDeliverySystem;

import java.util.UUID;

public class CartItem {
    private String cartItemId;
    private Menu menuItem;
    private int quantity;

    public CartItem(Menu menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.cartItemId="CTIT"+ UUID.randomUUID().toString().substring(0,8);
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Menu getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Menu menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                '}';
    }
}
