public class Customer {
    private double consumption;
    private String band;
    private double ratePerM3;
    private double fixedCharge;
    private double totalBill;

    public Customer(double consumption) {
        this.consumption = consumption;
        determineBand();
        computeBill();
    }

    private void determineBand() {
        if (consumption <= 5) {
            band = "LIFELINE";
            ratePerM3 = 1000;
            fixedCharge = 2000;
        } else if (consumption <= 20) {
            band = "DOMESTIC LOW";
            ratePerM3 = 2500;
            fixedCharge = 4000;
        } else if (consumption <= 50) {
            band = "DOMESTIC HIGH";
            ratePerM3 = 3800;
            fixedCharge = 7500;
        } else if (consumption <= 100) {
            band = "COMMERCIAL";
            ratePerM3 = 4500;
            fixedCharge = 15000;
        } else if (consumption <= 300) {
            band = "INDUSTRIAL";
            ratePerM3 = 5200;
            fixedCharge = 40000;
        } else {
            band = "INSTITUTIONAL";
            ratePerM3 = 6000;
            fixedCharge = 90000;
        }
    }

    private void computeBill() {
        totalBill = (consumption * ratePerM3) + fixedCharge;
    }

    public double getConsumption() { return consumption; }
    public String getBand()        { return band; }
    public double getTotalBill()   { return totalBill; }
}
