package Koszyk.src;

import java.util.Comparator;

public class NameSorter implements Comparator<Product> {
    public int compare(Product p1, Product p2) {
        return p1.name.compareTo(p2.name);
    }
}
