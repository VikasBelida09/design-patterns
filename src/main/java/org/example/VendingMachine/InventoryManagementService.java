package org.example.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementService {
    private final Map<String, Integer> productQuantities;
    private static volatile InventoryManagementService instance;
    public InventoryManagementService(){
        productQuantities=new HashMap<>();
    }
    public static InventoryManagementService getInstance(){
        if(instance==null){
            synchronized (InventoryManagementService.class){
                if(instance==null){
                    instance=new InventoryManagementService();
                }
            }
        }
        return instance;
    }
    public void addProductAndQty(Product product, int quantity){
        productQuantities.putIfAbsent(product.getProductId(), productQuantities.getOrDefault(product.getProductId(),0)+quantity);
    }
    public void decrementProductQty(Product product, int qty){
        productQuantities.put(product.getProductId(),productQuantities.get(product.getProductId())-1);
    }
    public Map<String, Integer> getProductQuantities(){
        return this.productQuantities;
    }
}
