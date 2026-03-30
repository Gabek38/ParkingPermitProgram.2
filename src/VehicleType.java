package src;
import java.math.BigDecimal;

public enum VehicleType {
    // These define the multipliers for each vehicle
    CAR("1.00"), 
    SUV("1.15"), 
    MOTORCYCLE("0.70");

    private final BigDecimal multiplier;

    // Constructor to set the multiplier
    VehicleType(String m) {
        this.multiplier = new BigDecimal(m);
    }

    // This fixes "undefined for the type VehicleType"
    public BigDecimal apply(BigDecimal rate) {
        return rate.multiply(multiplier);
    }
}