import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("\n=== CAMPUS PARKING PERMIT PROGRAM ===");
                System.out.print("Permit Type (Resident/Commuter): ");
                String pInput = sc.next().toUpperCase();
                
                System.out.print("Vehicle (Car/SUV/Motorcycle): ");
                String vInput = sc.next().toUpperCase();
                
                System.out.print("Carpool Participation? (Y/N): ");
                boolean isCarpool = sc.next().equalsIgnoreCase("Y");
                
                System.out.print("Duration (1-12 months): ");
                int months = sc.nextInt();

                // Validation
                if (months < 1 || months > 12) throw new InvalidSelectionException("Months must be 1-12.");

                // 1. Polymorphic Strategy Selection
                PricingStrategy strategy = pInput.equals("RESIDENT") ? 
                    new ResidentPricingStrategy() : new CommuterPricingStrategy();
                
                BigDecimal rate = strategy.getBaseRate();

                // 2. Polymorphic Rate Modification
                rate = VehicleType.valueOf(vInput).apply(rate);
                if (isCarpool) rate = new CarpoolDiscount().apply(rate);

                // 3. Final Calculations
                BigDecimal subtotal = rate.multiply(BigDecimal.valueOf(months));
                BigDecimal fee = subtotal.multiply(new BigDecimal("0.05"));
                BigDecimal total = subtotal.add(fee);

                // 4. Output Receipt
                System.out.println("\n--- ITEMIZED RECEIPT ---");
                System.out.println("Monthly Rate: $" + rate.setScale(2, RoundingMode.HALF_UP));
                System.out.println("Subtotal:     $" + subtotal.setScale(2, RoundingMode.HALF_UP));
                System.out.println("Campus Fee:   $" + fee.setScale(2, RoundingMode.HALF_UP));
                System.out.println("------------------------");
                System.out.println("TOTAL DUE:    $" + total.setScale(2, RoundingMode.HALF_UP));
                
                System.out.print("\nCalculate another? (Y/N): ");
                if (!sc.next().equalsIgnoreCase("Y")) break;

            } catch (Exception e) {
                System.out.println("INPUT ERROR: " + e.getMessage());
                sc.nextLine(); // Clear the bad input
            }
        }
        System.out.println("Goodbye!");
        sc.close();
    }
}