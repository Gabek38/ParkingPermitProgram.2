package src;
import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(VehicleType type);
}