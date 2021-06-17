package Koszyk.src;

public class Product {
    public String code;
    public String name;
    public double price;
    public double discountPrice;

    public Product(String code, String name, double price, double discountPrice){
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public int compareTo(Product p){
        if (this.price > p.price) return -1;
        else if (p.price > this.price) return 1;
        return 0;
    }
}
