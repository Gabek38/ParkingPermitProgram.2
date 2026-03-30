package src;
import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getBaseRate(); // This fixes "undefined for the type PricingStrategy"
    BigDecimal calculatePrice(VehicleType type);
}