package Koszyk.src;

import java.util.Comparator;

public class PriceSorter implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.compareTo(p2);
    }
}

