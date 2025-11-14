public class Policy
{
    private static int policyCount = 0;

    private int policyNumber;
    private String providerName;
    private PolicyHolder holder;

    public Policy(int policyNumber, String providerName, PolicyHolder holder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.holder = new PolicyHolder(holder);
        policyCount++;
    }

    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }

    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(holder);
    }

    public static int getPolicyCount()
    {
        return policyCount;
    }

    public double calculatePolicyPrice()
    {
        double price = 600;

        if (holder.getAge() > 50)
            price += 75;

        if (holder.getSmokingStatus().equalsIgnoreCase("smoker"))
            price += 100;

        if (holder.getBMI() > 35)
            price += 75;

        return price;
    }

    public String toString()
    {
        String result = "";

        result += "Policy Number: " + policyNumber + "\n\n";
        result += "Provider Name: " + providerName + "\n\n";
        result += holder.toString() + "\n\n";
        result += String.format("Policy Price: $%.2f", calculatePolicyPrice());

        return result;
    }
}
