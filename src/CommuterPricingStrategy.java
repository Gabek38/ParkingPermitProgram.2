package src;
import java.math.BigDecimal;

public class CommuterPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(VehicleType type) {
        switch (type) {
            case CAR: return new BigDecimal("100.00");
            case SUV: return new BigDecimal("150.00");
            case MOTORCYCLE: return new BigDecimal("60.00");
            default: return BigDecimal.ZERO;
        }
    }

    @Override
    public BigDecimal getBaseRate() {
        throw new UnsupportedOperationException("Unimplemented method 'getBaseRate'");
    }
}