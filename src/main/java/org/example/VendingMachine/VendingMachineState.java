package org.example.VendingMachine;

public interface VendingMachineState {
    void showProducts(InventoryManagementService inventoryManagementService, ProductService productService);
    void selectProduct(InventoryManagementService inventoryManagementService,Product product, int qty);

    void insertCoins(double amnt);

    void insertBills(double amnt);

    void dispenseProduct();
}
