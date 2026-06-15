import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    
    static double readConsumption(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("  Error: Consumption cannot be negative. Try again.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("  Error: Please enter a valid number. Try again.");
            }
        }
    }

    
    static void singleCustomer() {
        System.out.println("\n===== NWSC WATER BILL CALCULATOR (Single Customer) =====");
        double consumption = readConsumption("Enter monthly water consumption (m3): ");
        Customer c = new Customer(consumption);

        System.out.println("\n--- Bill Summary ---");
        System.out.println("Consumption   : " + c.getConsumption() + " m3");
        System.out.println("Customer Band : " + c.getBand());
        System.out.println("Total Bill    : UGX " + (long) c.getTotalBill());
    }

    
    static void sixCustomers() {
        System.out.println("\n===== NWSC WATER BILL CALCULATOR (6 Customers) =====");

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            double consumption = readConsumption("Enter consumption for customer " + i + " (m3): ");
            customers.add(new Customer(consumption));
        }

    
        System.out.println("\n--- Individual Bills ---");
        System.out.println("Customer | Consumption (m3) | Band | Total Bill (UGX)");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i + 1) + "        | " + c.getConsumption() + "               | " + c.getBand() + " | UGX " + (long) c.getTotalBill());
        }

        
        int lifeline = 0, domesticLow = 0, domesticHigh = 0;
        int commercial = 0, industrial = 0, institutional = 0;
        double totalRevenue = 0;

        for (Customer c : customers) {
            totalRevenue += c.getTotalBill();
            switch (c.getBand()) {
                case "LIFELINE":       lifeline++;       break;
                case "DOMESTIC LOW":   domesticLow++;    break;
                case "DOMESTIC HIGH":  domesticHigh++;   break;
                case "COMMERCIAL":     commercial++;     break;
                case "INDUSTRIAL":     industrial++;     break;
                case "INSTITUTIONAL":  institutional++;  break;
            }
        }

        double averageBill = totalRevenue / customers.size();

        System.out.println("\n--- Billing Summary ---");
        System.out.println("LIFELINE      : " + lifeline);
        System.out.println("DOMESTIC LOW  : " + domesticLow);
        System.out.println("DOMESTIC HIGH : " + domesticHigh);
        System.out.println("COMMERCIAL    : " + commercial);
        System.out.println("INDUSTRIAL    : " + industrial);
        System.out.println("INSTITUTIONAL : " + institutional);
        System.out.println("-----------------------------------");
        System.out.println("Total Revenue : UGX " + (long) totalRevenue);
        System.out.println("Average Bill  : UGX " + (long) averageBill);
    }

    
    public static void main(String[] args) {
        singleCustomer();
        sixCustomers();
        scanner.close();
    }
}
