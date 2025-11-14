import java.io.File;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws Exception {

        File file = new File("PolicyInformation.txt");
        Scanner input = new Scanner(file);

        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (input.hasNext()) {

            String policyNumber = input.next();
            String providerName = input.next();
            String firstName = input.next();
            String lastName = input.next();
            int age = input.nextInt();
            String smokingStatus = input.next();
            double height = input.nextDouble();
            double weight = input.nextDouble();

            PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);

            System.out.println(policy);
            System.out.println();

            if (smokingStatus.equalsIgnoreCase("smoker")) smokerCount++;
            else nonSmokerCount++;
        }

        input.close();

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
