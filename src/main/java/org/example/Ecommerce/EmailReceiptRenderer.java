package org.example.Ecommerce;

public class EmailReceiptRenderer implements ReceiptRenderer{
    @Override
    public void render(String content) {
        System.out.println("Email Receipt Renderer: "+ content);
    }
}
