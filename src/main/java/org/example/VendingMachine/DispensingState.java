package org.example.VendingMachine;

public class DispensingState implements VendingMachineState{
    private final VendingMachineSystem vendingMachineSystem;
    private final double change;
    private final Product product;
    private final int qty;
    private final InventoryManagementService inventoryManagementService;
    public DispensingState(VendingMachineSystem vendingMachineSystem, InventoryManagementService inventoryManagementService, double change, Product product, int qty) {
        this.vendingMachineSystem=vendingMachineSystem;
        this.change=change;
        this.product=product;
        this.qty=qty;
        this.inventoryManagementService=inventoryManagementService;
    }

    @Override
    public void showProducts(InventoryManagementService inventoryManagementService, ProductService productService) {
        System.out.println("Dispensing product please wait!");
    }

    @Override
    public void selectProduct(InventoryManagementService inventoryManagementService, Product product, int qty) {
        System.out.println("Dispensing product please wait!");
    }

    @Override
    public void insertCoins(double amnt) {
        System.out.println("Dispensing product please wait!");
    }

    @Override
    public void insertBills(double amnt) {
        System.out.println("Dispensing product please wait!");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Dispensing product - "+product.getProductName()+" qty- "+qty);
        inventoryManagementService.decrementProductQty(product,qty);
        if(change > 0){
            System.out.println("Dispensing remaining product - "+ change);
        }
        vendingMachineSystem.setState(new IdleState(vendingMachineSystem));
    }
}
