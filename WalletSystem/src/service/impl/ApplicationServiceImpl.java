package service.impl;



import models.Account;
import models.WalletSystem;
import service.AccountService;
import service.ApplicationService;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService {

    Scanner scanner = new Scanner(System.in);
    WalletSystem walletSystem = new WalletSystem();  // Create an instance of WalletSystem
    AccountService accountService = new AccountServiceImpl();  // Create an instance of AccountServiceImpl

    @Override
    public void start() {
        displayWelcomeMessage();

        boolean exit = false;
        int wrongAttempts = 0;

        do {
            showMenu();
            int choose = getUserChoice(scanner);

            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you! Have a great day!");
                    exit = true;
                    break;
                default:
                    System.out.println("This option is incorrect, please enter a valid choice.");
                    wrongAttempts++;
                    if (wrongAttempts >= 3) {
                        System.out.println("You have exceeded the maximum number of wrong attempts. The program will now exit.");
                        exit = true;
                    }
                    break;
            }

        } while (!exit);
    }

    // Display the welcome message
    private void displayWelcomeMessage() {
        System.out.println("Welcome to your digital wallet!");
        System.out.println("We're here to help you manage your finances.");
        System.out.println("Start managing your financial world now!");
    }

    // Display the menu
    private void showMenu() {
        System.out.println("1- Login");
        System.out.println("2- Create Account");
        System.out.println("3- Exit");
        System.out.print("Please enter your choice: ");
    }

    // Get user choice input
    private int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();  // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Simulate login (for now)
    private void login() {
        System.out.println("Logging in...");
        // Add login functionality here
        scanner.nextLine();  // Consume the leftover newline character

        // Ask the user for login credentials
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if account exists
        Account account = walletSystem.getAccount(userName);

        if (account != null && account.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome " + userName);
            System.out.println("Your balance is: " + account.getBalance());
            // You can now add other functionality like performing transactions, etc.
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // Handle account creation
    private void createAccount() {
        scanner.nextLine();  // Consume the leftover newline character

        // Gather user input for creating account
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        if (walletSystem.accountExists(userName)) {
            System.out.println("Account with this username already exists!");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        // Password validation
        if (!isValidPassword(password)) {
            System.out.println("Password is too weak. Please ensure it contains at least:");
            System.out.println("- One uppercase letter");
            System.out.println("- One lowercase letter");
            System.out.println("- One number");
            System.out.println("- One special character");
            return;  // Exit the method if the password is invalid
        }

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        double balance = scanner.nextDouble();

        // Create the account using AccountService
        Account account = accountService.createAccount(userName, password, email, phoneNumber, balance);

        // Add the account to the wallet system
        if (walletSystem.addAccount(account)) {
            System.out.println("\nAccount Created Successfully!");

            // This will print using the overridden toString method
            System.out.println(account);
        }
        else {
            System.out.println("Failed to create account. Username might already exist.");
        }
    }

    // Password validation method
    private boolean isValidPassword(String password) {
        // Regex to check for at least one uppercase, one lowercase, one number, and one special character
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";


        // If the password matches the regex, it's valid
        return password.matches(passwordRegex);
    }
}
