package org.example.Ecommerce;

public abstract class Receipt {
    protected ReceiptRenderer receiptRenderer;
    public Receipt(ReceiptRenderer receiptRenderer){
        this.receiptRenderer=receiptRenderer;
    }
    public abstract String getContent();

    public void deliver(){
        receiptRenderer.render(getContent());
    }
}
