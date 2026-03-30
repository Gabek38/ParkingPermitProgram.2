package src;
import java.math.BigDecimal;

public class CommuterPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal getBaseRate() {
        return new BigDecimal("35.00"); // Base rate for commuters
    }

    @Override
    public BigDecimal calculatePrice(VehicleType type) {
        // You can leave this empty or call getBaseRate and apply type
        return type.apply(getBaseRate());
    }
}