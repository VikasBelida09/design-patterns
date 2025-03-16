package org.example.VendingMachine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductService {
    private final Set<Product> products;
    public ProductService(){
        this.products=new HashSet<>();
    }
    public void addProduct(Product product){
        this.products.add(product);
    }

    public Set<Product> getProducts() {
        return products;
    }
}
