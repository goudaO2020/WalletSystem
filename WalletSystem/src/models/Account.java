package models;

public class Account {
    private String userName;
    private String password;
    private boolean active;
    private double balance;
    private String email;
    private String phoneNumber;

    // Constructor to initialize the account
    public Account(String userName, String password, String email, String phoneNumber, double balance) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.active = true;  // Setting the account to active by default
    }

    // Overriding toString to print account information neatly
    @Override
    public String toString() {
        return "Account Information: \n" +
                "Username: " + userName + "\n" +
                "Email: " + email + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Balance: " + balance + "\n" +
                "Active: " + active;
    }

    // Getters and setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

