package src;
import java.math.BigDecimal;

public class CarpoolDiscount {
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.20"); // 20% off

    public BigDecimal applyDiscount(BigDecimal originalPrice) {
        BigDecimal discountAmount = originalPrice.multiply(DISCOUNT_RATE);
        return originalPrice.subtract(discountAmount);
    }

    public BigDecimal apply(BigDecimal rate) {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}