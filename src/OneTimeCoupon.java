package Koszyk.src;

public class OneTimeCoupon extends Discounts{
    public String code;

    public OneTimeCoupon(String code) {
        this.code = code;
    }

    public Product[] apply(Basket basket) throws Exception {
        for (Product product : basket.products){
            if (product.code.equals(code) && !usedOnce){
                usedOnce = true;
                product.price -= product.price*30/100;
            } else {
                throw new Exception("Coupon was used once!");
            }
        }
        return basket.products;
    }
}

