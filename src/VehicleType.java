package src;

import java.math.BigDecimal;

public enum VehicleType {
    CAR, 
    SUV, 
    MOTORCYCLE;

    BigDecimal apply(BigDecimal rate) {
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}