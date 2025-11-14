import java.util.Scanner;

class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    public Policy() {
        policyNumber = "";
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public double getBMI() {
        return (weight * 703.0) / (height * height);
    }

    public double getPolicyPrice() {
        double price = 600.0;
        if (age > 50) price += 75.0;
        if (smokingStatus.equalsIgnoreCase("smoker")) price += 100.0;
        double bmi = getBMI();
        if (bmi > 35.0) price += (bmi - 35.0) * 20.0;
        return price;
    }
}

public class Project_HuyDucBui {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Policy Number: ");
        String policyNumber = input.nextLine().trim();

        System.out.print("Enter the Provider Name: ");
        String providerName = input.nextLine().trim();

        System.out.print("Enter the Policyholder's First Name: ");
        String firstName = input.nextLine().trim();

        System.out.print("Enter the Policyholder's Last Name: ");
        String lastName = input.nextLine().trim();

        System.out.print("Enter the Policyholder's Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine().trim();

        System.out.print("Enter the Policyholder's Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Enter the Policyholder's Weight (in pounds): ");
        double weight = input.nextDouble();

        if (smokingStatus.equalsIgnoreCase("smoker") || smokingStatus.equalsIgnoreCase("hut thuoc")) {
            smokingStatus = "smoker";
        } else if (smokingStatus.equalsIgnoreCase("non-smoker") ||
                   smokingStatus.equalsIgnoreCase("khong hut thuoc") ||
                   smokingStatus.equalsIgnoreCase("không hút thuốc")) {
            smokingStatus = "non-smoker";
        }

        Policy policy = new Policy(
            policyNumber, providerName, firstName, lastName,
            age, smokingStatus, height, weight
        );

        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.printf("Policyholder's Height: %.1f inches%n", policy.getHeight());
        System.out.printf("Policyholder's Weight: %.1f pounds%n", policy.getWeight());
        System.out.printf("Policyholder's BMI: %.2f%n", policy.getBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.getPolicyPrice());

        input.close();
    }
}
