package Koszyk.src;

public class FivePercent extends Discounts{
    public Product[] apply(Basket basket){
        if (basket.sum > 300 && !discount){
            basket.sum -= (basket.sum)*5/100;
            discount = true;
        }
        return basket.products;
    }
}