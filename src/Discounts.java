package Koszyk.src;


abstract public class Discounts {
    public Boolean discount = false;
    public Boolean cupAdd = false;
    public Boolean usedOnce = false;

    public Product[] apply(Basket basket) throws Exception { return basket.products; }
}
