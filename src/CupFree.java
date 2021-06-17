package Koszyk.src;

import java.util.Arrays;

public class CupFree extends Discounts{
    public Product[] apply(Basket basket){
        if (basket.sum > 200 && !cupAdd){
            cupAdd = true;
            basket.products = Arrays.copyOf(basket.products, basket.products.length + 1);
            basket.products[basket.products.length - 1] = new Product("free1", "Kubek firmowy", 0.0, 0.0);
        }
        return basket.products;
    }
}