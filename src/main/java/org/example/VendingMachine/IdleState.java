package org.example.VendingMachine;

public class IdleState implements VendingMachineState{
    private final VendingMachineSystem vendingMachineSystem;
    public IdleState(VendingMachineSystem vendingMachineSystem){
        this.vendingMachineSystem=vendingMachineSystem;
    }
    @Override
    public void showProducts(InventoryManagementService inventoryManagementService, ProductService productService) {
        System.out.println("displaying products");
        productService.getProducts().forEach(p->{
            System.out.println(p.getProductName()+" " + p.getProductDescription()+ " "+ inventoryManagementService.getProductQuantities().get(p.getProductId()));
        });
    }

    @Override
    public void selectProduct(InventoryManagementService inventoryManagementService, Product product, int qty) {
        int available=inventoryManagementService.getProductQuantities().get(product.getProductId());
        if(available <qty){
            System.out.println("Please select quantity which is in the available limit");
            return;
        }
        System.out.println("Selected "+ product.getProductName()+" qty- "+qty);
        vendingMachineSystem.setState(new PaymentState(vendingMachineSystem, inventoryManagementService,product, qty));
    }

    @Override
    public void insertCoins(double amnt) {
        System.out.println("Select Product first!");
    }

    @Override
    public void insertBills(double amnt) {
        System.out.println("Select product first!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first!");
    }
}
