package src;
import java.math.BigDecimal;

public class ResidentPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(VehicleType type) {
        switch (type) {
            case CAR: return new BigDecimal("50.00");
            case SUV: return new BigDecimal("75.00");
            case MOTORCYCLE: return new BigDecimal("30.00");
            default: return BigDecimal.ZERO;
        }
    }
}