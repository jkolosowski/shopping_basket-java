package Koszyk.src;

public class printProducts {
    public static void main(String[] args) throws Exception {
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        basket.printProducts();
    }
}
