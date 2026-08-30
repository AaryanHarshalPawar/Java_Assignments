public class VotingSystem {
    static class UnderAgeException extends Exception {
        UnderAgeException(String message) {
            super(message);
        }
    }

    static void checkVotingEligibility(String voterName, int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException(voterName + " is " + age + " years old and cannot vote. Minimum age is 18.");
        }
        System.out.println(voterName + " is " + age + " years old and is eligible to vote.");
    }

    public static void main(String[] args) {
        System.out.println("Voting System");
        System.out.println("-------------");

        try {
            checkVotingEligibility("Aaryan", 20);
        } catch (UnderAgeException e) {
            System.out.println("Registration rejected: " + e.getMessage());
        }

        try {
            checkVotingEligibility("Riya", 16);
        } catch (UnderAgeException e) {
            System.out.println("Registration rejected: " + e.getMessage());
        }
    }
}
