public class DrivingLicenseSystem {
    static class InvalidAgeException extends Exception {
        InvalidAgeException(String message) {
            super(message);
        }
    }

    static void applyForLicense(String applicantName, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Applicant " + applicantName + " is only " + age + " years old.");
        }
        System.out.println(applicantName + " (age " + age + ") is eligible for a driving license.");
    }

    public static void main(String[] args) {
        System.out.println("Driving License System");
        System.out.println("----------------------");

        try {
            applyForLicense("Aaryan", 19);
        } catch (InvalidAgeException e) {
            System.out.println("Application rejected: " + e.getMessage());
        }

        try {
            applyForLicense("Kabir", 15);
        } catch (InvalidAgeException e) {
            System.out.println("Application rejected: " + e.getMessage());
        }
    }
}
