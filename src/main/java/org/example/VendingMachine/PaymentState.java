package org.example.VendingMachine;

public class PaymentState implements VendingMachineState{
    private final InventoryManagementService inventoryManagementService;
    private final Product product;
    private final int qty;
    private double totalInserted;
    private VendingMachineSystem vendingMachineSystem;
    PaymentState(VendingMachineSystem vendingMachineSystem,InventoryManagementService inventoryManagementService, Product product, int qty){
        this.qty=qty;
        this.product=product;
        this.inventoryManagementService=inventoryManagementService;
        totalInserted=0;
        this.vendingMachineSystem=vendingMachineSystem;
    }
    @Override
    public void showProducts(InventoryManagementService inventoryManagementService, ProductService productService) {
        System.out.println("Please complete the payment!");
    }

    @Override
    public void selectProduct(InventoryManagementService inventoryManagementService, Product product, int qty) {
        System.out.println("you have already selected the product!");
    }

    @Override
    public void insertCoins(double amnt) {
      this.totalInserted+=amnt;
        System.out.println("Inserted coin amount: "+ amnt +" total inserted:"+ totalInserted);
        checkPayment();
    }

    @Override
    public void insertBills(double amnt) {
        this.totalInserted+=amnt;
        System.out.println("Inserted coin amount: "+ amnt +" total inserted:"+ totalInserted);
        checkPayment();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please complete the payment!");
    }
    private void checkPayment(){
        double totalCost=product.getPrice() * qty;
        if(totalCost <= totalInserted){
            System.out.println("Payment Complete. Dispensing product...");
            vendingMachineSystem.setState(new DispensingState(vendingMachineSystem, inventoryManagementService,totalInserted-totalCost, product, qty));
            vendingMachineSystem.getVendingMachineState().dispenseProduct();
        }else{
            System.out.println("Total inserted: "+ totalInserted+" Remaining: "+ (totalCost-totalInserted));
        }
    }
}
