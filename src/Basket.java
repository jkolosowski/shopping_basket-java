package Koszyk.src;

import java.util.Arrays;


public class Basket {

    public Product[] products = new Product[0];
    public Discounts[] discounts = new Discounts[0];

    public double sum = 0;

    public void add(String code, String name, double price, double discountPrice) throws Exception {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = new Product(code, name, price, discountPrice);
        sum += price;

        for (Discounts discount : discounts){
            discount.apply(this);
        }
    }

    public void addDiscount(Discounts discount){
        discounts = Arrays.copyOf(discounts, discounts.length + 1);
        discounts[discounts.length - 1] = discount;
    }

    public void oneTimeCoupon(String code) throws Exception {
        OneTimeCoupon coupon = new OneTimeCoupon(code);
        coupon.apply(this);
    }


    public void sortByPrice(){
        Arrays.sort(products, new PriceSorter());
    }

    public void sortByName(){
        Arrays.sort(products, new NameSorter());
    }


    public Product[] getProducts(){
        return products;
    }


    public Product getMaxProduct(){
        this.sortByPrice();
        return products[0];
    }

    public Product getMinProduct(){
        this.sortByPrice();
        return products[products.length - 1];
    }


    public Product[] nMinProducts(int num){
        if (products.length >= num){
            Product[] minProducts = new Product[0];
            Arrays.sort(products, new PriceSorter().reversed());
            for (int i=0; i < num; i++){
                minProducts = Arrays.copyOf(minProducts, minProducts.length + 1);
                minProducts[minProducts.length - 1] = products[i];
            }
            return minProducts;
        } else {
            throw new IllegalArgumentException("Not enough products to make this!");
        }
    }

    public Product[] nMaxProducts(int num){
        if (products.length >= num){
            Product[] maxProducts = new Product[0];
            Arrays.sort(products, new PriceSorter());
            for (int i=0; i < num; i++){
                maxProducts = Arrays.copyOf(maxProducts, maxProducts.length + 1);
                maxProducts[maxProducts.length - 1] = products[i];
            }
            return maxProducts;
        } else {
            throw new IllegalArgumentException("Not enough products to make this!");
        }
    }


    public double sumPrices(){
        return sum;
    }


    public void printProducts() throws Exception{
        if (products.length != 0){
            for (Product product : products){
                System.out.println("Code: " + product.code + " | name: " + product.name + " | price: " + product.price + " | discount price: " + product.discountPrice);
            }
        } else {
            throw new Exception("The basket is empty!");
        }
    }

}