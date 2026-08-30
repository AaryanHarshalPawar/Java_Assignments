public class Login {
    static void authenticate(String username, String enteredPassword) throws Exception {
        String storedPassword = "java@2026";
        try {
            System.out.println("Verifying credentials for user: " + username);
            if (!storedPassword.equals(enteredPassword)) {
                throw new Exception("Invalid password for user " + username);
            }
            System.out.println("Login successful. Welcome, " + username + "!");
        } finally {
            System.out.println("Session log closed for user: " + username);
        }
    }

    public static void main(String[] args) {
        System.out.println("Login System");
        System.out.println("------------");

        try {
            authenticate("aaryan", "java@2026");
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }

        System.out.println();

        try {
            authenticate("aaryan", "hello123");
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
