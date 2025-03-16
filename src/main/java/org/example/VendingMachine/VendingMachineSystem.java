package org.example.VendingMachine;

public class VendingMachineSystem {
    private VendingMachineState vendingMachineState;
    private final InventoryManagementService inventoryManagement;
    private final ProductService productService;
    private static volatile VendingMachineSystem instance;
    private VendingMachineSystem(){
        this.vendingMachineState=new IdleState(this);
        inventoryManagement=InventoryManagementService.getInstance();
        this.productService=new ProductService();
    }
    public static VendingMachineSystem getInstance(){
        if(instance==null){
            synchronized (VendingMachineSystem.class){
                if(instance==null){
                    instance=new VendingMachineSystem();
                }
            }
        }
        return instance;
    }
    public void addProduct(Product product){
        this.productService.addProduct(product);
    }
    public void setQty(Product product, int qty){
        this.inventoryManagement.addProductAndQty(product,qty);
    }
    public void showProducts(){
        this.vendingMachineState.showProducts(inventoryManagement, productService);
    }
    public void selectProduct(Product product, int qty){
        this.vendingMachineState.selectProduct(this.inventoryManagement, product, qty);
    }
    public void insertCoins(double amt){
        this.vendingMachineState.insertCoins(amt);
    }
    public void insertBills(double amt){
        this.vendingMachineState.insertBills(amt);
    }
    public void dispenseProduct(){
        this.vendingMachineState.dispenseProduct();
    }
    public void setState(VendingMachineState vendingMachineState){
        this.vendingMachineState=vendingMachineState;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }
}
