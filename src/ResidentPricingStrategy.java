package src;
import java.math.BigDecimal;

public class ResidentPricingStrategy implements PricingStrategy {
    
    @Override
    public BigDecimal getBaseRate() {
        // Return the flat base rate for residents
        return new BigDecimal("45.00"); 
    }

    @Override
    public BigDecimal calculatePrice(VehicleType type) {
        // This uses the logic: Base Rate * Vehicle Multiplier
        return type.apply(getBaseRate());
    }
}