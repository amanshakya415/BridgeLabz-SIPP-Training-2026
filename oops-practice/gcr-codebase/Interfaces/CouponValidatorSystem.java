interface CouponValidator {
    boolean validateCoupon(String code);
    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5;
    }
}

class ShoppingCart implements CouponValidator {
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        return code.startsWith("SAVE") || code.startsWith("DISCOUNT");
    }
}

public class CouponValidatorSystem {
    public static void main(String[] args) {
        String[] coupons = {"SAVE10", "DISC", "DISCOUNT50", "INVALID", "PROMO20"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon)) {
                System.out.println(coupon + " is a VALID coupon.");
            } else {
                System.out.println(coupon + " is an INVALID coupon.");
            }
        }
    }
}