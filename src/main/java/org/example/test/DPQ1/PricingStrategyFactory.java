package org.example.test.DPQ1;

public class PricingStrategyFactory {
    public static PricingStrategy getPricingStrategyChain(){
        RegularCustomerDiscount rs=new RegularCustomerDiscount();
        PremiumCustomerDiscount ps=new PremiumCustomerDiscount();
        GoldCustomerDiscount gs=new GoldCustomerDiscount();

        rs.setNextPricingStrategy(ps);
        ps.setNextPricingStrategy(gs);
        return rs;
    }
}
