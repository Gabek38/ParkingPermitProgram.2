import java.math.BigDecimal;

// --- INTERFACES (The "What") ---
interface PricingStrategy {
    BigDecimal getBaseRate();
}

interface RateModifier {
    BigDecimal apply(BigDecimal currentRate);
}

// --- STRATEGIES (The "How" - Polymorphism) ---
class ResidentPricingStrategy implements PricingStrategy {
    public BigDecimal getBaseRate() { return new BigDecimal("45.00"); }
}

class CommuterPricingStrategy implements PricingStrategy {
    public BigDecimal getBaseRate() { return new BigDecimal("35.00"); }
}

// --- MODIFIERS (Enums and Classes) ---
enum PermitType { RESIDENT, COMMUTER }

enum VehicleType implements RateModifier {
    CAR("1.00"), SUV("1.15"), MOTORCYCLE("0.70");
    private final BigDecimal multiplier;
    VehicleType(String m) { this.multiplier = new BigDecimal(m); }
    public BigDecimal apply(BigDecimal current) { return current.multiply(multiplier); }
}

class CarpoolDiscount implements RateModifier {
    public BigDecimal apply(BigDecimal current) { 
        return current.multiply(new BigDecimal("0.90")); 
    }
}