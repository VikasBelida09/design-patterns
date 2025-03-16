package org.example.Ecommerce;

public class OrderReceipt extends Receipt{
    private final IOrder order;
    private final String orderId;
    public OrderReceipt(String orderId, IOrder order,ReceiptRenderer receiptRenderer) {
        super(receiptRenderer);
        this.order = order;
        this.orderId = orderId;
    }

    @Override
    public String getContent() {
        return "Order ID: " + orderId + "\n" +
                "Description: " + order.getDescription() + "\n" +
                "Quantity: " + order.getQuantity() + "\n" +
                "Total Price: $" + order.getTotalPrice();
    }

}
