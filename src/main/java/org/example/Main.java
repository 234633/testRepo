package org.example;

import java.util.Scanner;

import static org.example.AtmOptions.*;

public class Main {

    private static String LOGIN = "123";
    private static String PASSWORD = "123";
    private static double BALANCE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount;

        for (int i = 2; i >= 0; i--) {
            System.out.println("Enter your login and password:");
            String login = scanner.next();
            String password = scanner.next();
            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
                System.out.println("login successful.\nEnter your balance: ");
                break;
            } else System.out.println("login failed. Remaining attemts: " + i);
        }

        BALANCE = scanner.nextDouble();
        if (BALANCE < 0) {
            System.out.println("XD you are poor");
            return;
        }

        System.out.println("Report your intentions: Balance, Withdraw, Deposit or Transfer");
        String intention = scanner.next();

        switch (intention) {
            case AtmOptions.BALANCE:
                System.out.println("Balance: " + BALANCE);
                break;
            case WITHDRAW:
            case DEPOSIT:
                updateBalance(scanner, intention);
                break;
            case TRANSFER:
                System.out.println("How much to transfer?: ");
                amount = scanner.nextDouble();
                BALANCE -= amount;
                System.out.println("Transfered " + amount + " to another account\nCurrent balance: " + BALANCE);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static void updateBalance(Scanner value, String intention) {
        System.out.println("Set amount: ");
        if (intention.equals(WITHDRAW)) {
            BALANCE -= value.nextDouble();
        } else {
            BALANCE += value.nextDouble();
        }
        System.out.println("Current balance: " + BALANCE);
    }
}


// minus values on withdraw, deposit and transfer. add aditional users that have cards and transfer between them money. add exit. 