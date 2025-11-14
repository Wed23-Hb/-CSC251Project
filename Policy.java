public class Policy {

    private String policyNumber;
    private String providerName;
    private PolicyHolder holder;

    private static int policyCount = 0;

    public Policy(String policyNumber, String providerName, PolicyHolder holder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.holder = new PolicyHolder(holder); // defensive copy
        policyCount++;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public double getPolicyPrice() {
        double price = 600.0;

        if (holder.getSmokingStatus().equalsIgnoreCase("smoker"))
            price += 100;

        double bmi = holder.getBMI();
        if (bmi > 35)
            price += (bmi - 35) * 20;

        return price;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + holder.toString() +
               "\nPolicy Price: $" + String.format("%.2f", getPolicyPrice());
    }
}
