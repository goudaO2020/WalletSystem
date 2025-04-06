package models;

import java.util.HashMap;
import java.util.Map;

public class WalletSystem {
    private final String walletName = "WalletGo";  // The name of the wallet system
    private Map<String, Account> accounts;  // A map to hold user accounts by username

    // Constructor
    public WalletSystem() {
        accounts = new HashMap<>();
    }

    // Method to add a new account to the system
    public boolean addAccount(Account account) {
        if (accounts.containsKey(account.getUserName())) {
            // If account already exists with the same username, return false
            return false;
        } else {
            accounts.put(account.getUserName(), account);
            return true;  // Successfully added the account
        }
    }

    // Method to get an account by username
    public Account getAccount(String userName) {
        return accounts.get(userName);
    }

    // Method to check if an account exists
    public boolean accountExists(String userName) {
        return accounts.containsKey(userName);
    }

    // Method to remove an account from the system
    public boolean removeAccount(String userName) {
        if (accounts.containsKey(userName)) {
            accounts.remove(userName);
            return true;  // Successfully removed the account
        } else {
            return false;  // Account not found
        }
    }

    // Method to display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            accounts.values().forEach(account -> System.out.println(account));
        }
    }

    // Getter for the wallet name (if needed)
    public String getWalletName() {
        return walletName;
    }
}
