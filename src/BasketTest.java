package Koszyk.src;

import org.junit.*;
import static org.junit.Assert.*;
public class BasketTest {

    @Test
    public void testDefaultBasketEmpty(){
        Basket basket = new Basket();
        assertEquals(0, basket.getProducts().length);
    }

    @Test
    public void testAddProductsToBasketSizeCorrect() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        assertEquals(2, basket.getProducts().length);
    }

    @Test
    public void testAddProductsValuesToBasket() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        assertEquals("1z3d", basket.getProducts()[0].code);
        assertEquals("Patelnia", basket.getProducts()[0].name);
        assertEquals(99.99, basket.getProducts()[0].price, 0);
        assertEquals(81.99, basket.getProducts()[0].discountPrice, 0);
    }

    @Test
    public void testSumCorrectWhileAddingToBasket() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        assertEquals(159.98, basket.sum, 0);
    }

    @Test
    public void testDiscount5PercentAdd() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new FivePercent());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Piekarnik", 2399.99, 2099.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        assertEquals(2534.98, basket.sum, 0.1);
    }

    @Test
    public void testOneFreeWhile3ProductsInBasket() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new ThirdFree());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("3d45", "Maseczka", 1.99, 1.89);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        assertEquals("Maseczka", basket.getProducts()[0].name);
        assertEquals(0, basket.getProducts()[0].price, 0);
    }

    @Test
    public void testCupFreeAdd() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new CupFree());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Piekarnik", 2399.99, 2099.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        assertEquals(4, basket.getProducts().length);
    }

    @Test
    public void testCupFreeAddAfter200() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new CupFree());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Piekarnik", 2399.99, 2099.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        assertEquals("Kubek firmowy", basket.getProducts()[2].name);
    }

    @Test
    public void testMaxPriceValueInBasket() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Piekarnik", 2399.99, 2099.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals("Piekarnik", basket.getMaxProduct().name);
    }

    @Test
    public void testMinPriceValueInBasket() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        basket.add("3d45", "Maseczka", 1.99, 1.89);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals("Maseczka", basket.getMinProduct().name);
    }

    @Test
    public void testSortByPrice() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new CupFree());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Piekarnik", 2399.99, 2099.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        basket.sortByPrice();
        assertEquals("Piekarnik", basket.getProducts()[0].name);
        assertEquals("Blender", basket.getProducts()[1].name);
        assertEquals("Patelnia", basket.getProducts()[2].name);
        assertEquals("Talerz", basket.getProducts()[3].name);
        assertEquals("Kubek firmowy", basket.getProducts()[4].name);
    }

    @Test
    public void testSortByName() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new CupFree());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        basket.sortByName();
        assertEquals("Blender", basket.getProducts()[0].name);
        assertEquals("Kubek firmowy", basket.getProducts()[1].name);
        assertEquals("Miś", basket.getProducts()[2].name);
        assertEquals("Patelnia", basket.getProducts()[3].name);
        assertEquals("Talerz", basket.getProducts()[4].name);
    }

    @Test
    public void testSortByPriceAndByName() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        basket.add("3d45", "Maseczka", 1.99, 1.89);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        basket.sortByPrice();
        basket.sortByName();
        assertEquals("Maseczka", basket.getProducts()[0].name);
        assertEquals("Miś", basket.getProducts()[1].name);
        assertEquals("Patelnia", basket.getProducts()[2].name);
        assertEquals("Talerz", basket.getProducts()[3].name);
    }

    @Test
    public void testnMinProductsSize() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Parownica", 98.99, 98.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals(2, basket.nMinProducts(2).length);
    }

    @Test
    public void testnMinProductsValues() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Miś", 59.99, 49.99);
        basket.add("3d45", "Maseczka", 1.99, 1.89);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals("Maseczka", basket.nMinProducts(2)[0].name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testnMinProductsException() throws IllegalArgumentException{
        Basket basket = new Basket();
        basket.nMinProducts(2);
    }

    @Test
    public void testnMaxProductsSize() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Parownica", 98.99, 98.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals(2, basket.nMaxProducts(2).length);
    }

    @Test
    public void testnMaxProductsValues() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Parownica", 98.99, 98.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals("Blender", basket.nMaxProducts(2)[0].name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testnMaxProductsException() throws IllegalArgumentException{
        Basket basket = new Basket();
        basket.nMaxProducts(2);
    }

    @Test
    public void testSumEmptyBasket(){
        Basket basket = new Basket();
        assertEquals(0, basket.sumPrices(), 0);
    }

    @Test
    public void testSumProductsInBasket() throws Exception{
        Basket basket = new Basket();
        basket.addDiscount(new FivePercent());
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("2x3s", "Parownica", 98.99, 98.99);
        basket.add("3d45", "Blender", 159.99, 151.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        assertEquals(355.01, basket.sumPrices(), 0.01);
    }

    @Test
    public void testOneTimeCoupon() throws Exception {
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.oneTimeCoupon("1z3d");
        assertEquals(69.99, basket.getProducts()[0].price, 0.1);
    }

    @Test(expected = Exception.class)
    public void testOneTimeCouponUsedException() throws Exception{
        Basket basket = new Basket();
        basket.add("1z3d", "Patelnia", 99.99, 81.99);
        basket.add("8zd3", "Talerz", 13.99, 13.49);
        basket.oneTimeCoupon("1z3d");
        basket.oneTimeCoupon("8zd3");
    }

    @Test(expected = Exception.class)
    public void testExceptionEmptyBasket() throws Exception{
        Basket basket = new Basket();
        basket.printProducts();
    }
}
