package Koszyk.src;

import java.util.Arrays;

public class ThirdFree extends Discounts{
    public Product[] apply(Basket basket){
        if (basket.products.length == 3){
            Arrays.sort(basket.products, new PriceSorter().reversed());
            basket.products[0].price = 0;
        }
        return basket.products;
    }
}
