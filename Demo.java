import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    private static String readNextNonEmpty(Scanner in) {
        String line = "";
        while (in.hasNextLine()) {
            line = in.nextLine().trim();
            if (!line.isEmpty()) return line;
        }
        return line;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        ArrayList<Policy> policies = new ArrayList<>();

        try (Scanner in = new Scanner(new File("PolicyInformation.txt"))) {
            while (in.hasNextLine()) {
                String s = readNextNonEmpty(in);
                if (s.isEmpty()) break;

                int policyNumber = Integer.parseInt(s);
                String providerName = readNextNonEmpty(in);
                String firstName = readNextNonEmpty(in);
                String lastName = readNextNonEmpty(in);
                int age = Integer.parseInt(readNextNonEmpty(in));
                String smokingStatus = readNextNonEmpty(in);
                double heightInches = Double.parseDouble(readNextNonEmpty(in));
                double weightPounds = Double.parseDouble(readNextNonEmpty(in));

                PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, heightInches, weightPounds);
                policies.add(new Policy(policyNumber, providerName, holder));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: PolicyInformation.txt not found.");
            return;
        }

        DecimalFormat oneDec  = new DecimalFormat("0.0");      // Height/Weight
        DecimalFormat twoDec  = new DecimalFormat("0.00");     // BMI
        DecimalFormat money   = new DecimalFormat("$#,##0.00");// Price

        int smokerCount = 0, nonSmokerCount = 0;

        for (Policy p : policies) {
            PolicyHolder h = p.getPolicyHolder();

            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println();

            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println();

            System.out.println("Policyholder's First Name: " + h.getFirstName());
            System.out.println();

            System.out.println("Policyholder's Last Name: " + h.getLastName());
            System.out.println();

            System.out.println("Policyholder's Age: " + h.getAge());
            System.out.println();

            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + h.getSmokingStatus());
            System.out.println();

            System.out.println("Policyholder's Height: " + oneDec.format(h.getHeightInches()) + " inches");
            System.out.println();

            System.out.println("Policyholder's Weight: " + oneDec.format(h.getWeightPounds()) + " pounds");
            System.out.println();

            System.out.println("Policyholder's BMI: " + twoDec.format(h.getBMI()));
            System.out.println();

            System.out.println("Policy Price: " + money.format(p.getPolicyPrice()));
            System.out.println();
            System.out.println();

            if (h.getSmokingStatus().equalsIgnoreCase("smoker")) smokerCount++;
            else nonSmokerCount++;
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
