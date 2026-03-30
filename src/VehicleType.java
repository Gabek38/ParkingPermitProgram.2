package src;
import java.math.BigDecimal;

public enum VehicleType {
    CAR("1.00"), 
    SUV("1.15"), 
    MOTORCYCLE("0.70");

    private final BigDecimal multiplier;

    VehicleType(String m) {
        this.multiplier = new BigDecimal(m);
    }

    public BigDecimal apply(BigDecimal rate) {
        return rate.multiply(multiplier);
    }
}