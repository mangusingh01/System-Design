package Encapsulation.UserAccount;

public class UserAccount {
    private String email;
    private String password;
    private int failedAttempts = 0;
    private boolean lockAccount = false;

    public UserAccount(String email, String password) {
        setEmail(email);
        this.password = password;
    }

    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty() || !email.contains("@")) {
            System.out.println("Invalid email address");
            return;
        }
        this.email = email;
    }

    public String checkPassword(String password) {
        if(lockAccount) return "Cannot check if password is correct as Account is locked";
        if(!this.password.equals(password)) {
            failedAttempts++;
            if(failedAttempts >= 3) {lockAccount = true;}
            return "Invalid email or password";
        }
        failedAttempts = 0;
        return "password matches...";
    }

}
