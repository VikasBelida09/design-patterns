package org.example.VendingMachine;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachineSystem vendingMachineSystem=VendingMachineSystem.getInstance();

        Product product1=new Product("Lays","Lays is amazing!", 5);
        Product product2=new Product("Coke","Coke is amazing!", 56);

        vendingMachineSystem.addProduct(product1);
        vendingMachineSystem.addProduct(product2);

        vendingMachineSystem.setQty(product1, 10);
        vendingMachineSystem.setQty(product2,10);

        vendingMachineSystem.showProducts();

        vendingMachineSystem.selectProduct(product1,5);

        vendingMachineSystem.insertCoins(30);
    }
}
