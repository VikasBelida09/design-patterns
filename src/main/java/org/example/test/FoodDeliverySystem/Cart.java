package org.example.test.FoodDeliverySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private List<CartItem> items;
    private String cartId;
    public Cart(){
        items=new ArrayList<>();
        cartId="CART"+ UUID.randomUUID().toString().substring(0,7);
    }
    public void addCartItem(CartItem item){
        this.items.add(item);
    }
    public void removeCartItem(CartItem item){
        this.items.remove(item);
    }
    public void updateCartItemQty(CartItem cartItem, int qty){
        CartItem it=this.items.stream().filter(ct->ct.getCartItemId().equals(cartItem.getCartItemId())).findFirst().orElse(null);
        if(it==null)return;
        it.setQuantity(qty);
    }
    public double getCartTotal(){
        return this.items.stream().mapToDouble(ct->ct.getMenuItem().getPrice() * ct.getQuantity()).sum();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", cartId='" + cartId + '\'' +
                '}';
    }
}
