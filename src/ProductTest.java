package Koszyk.src;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void testCreateProduct() {
        Product item = new Product("1z3d", "Patelnia", 99.99, 81.99);
        assertEquals("1z3d", item.code);
        assertEquals("Patelnia", item.name);
        assertEquals(99.99, item.price, 0);
        assertEquals(81.99, item.discountPrice, 0);
    }
}
