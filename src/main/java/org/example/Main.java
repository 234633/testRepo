package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.example.AtmOptions.*;
public class Main {

    public static void main(String[] arg) {

        User user1 = new User();
        user1.setLogin("1");
        user1.setPassword("1");
        user1.setBalance(1000);

        User user2 = new User();
        user2.setLogin("2");
        user2.setPassword("2");
        user2.setBalance(1000);

        User user3 = new User();
        user3.setLogin("3");
        user3.setPassword("3");
        user3.setBalance(1000);

        User user4 = new User();
        user4.setLogin("4");
        user4.setPassword("4");
        user4.setBalance(1000);

        User user5 = new User();
        user5.setLogin("5");
        user5.setPassword("5");
        user5.setBalance(1000);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        operations(users);

//        User user3 = new User();
//
//        String aaa = user1.getPassword();
//        System.err.println(aaa);
//        System.err.println(user1.getPassword());
//        System.err.println("123");
    }
    public static void operations(List<User> users) {
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;
        String finalTouch;

        for (int i = 3; i >= 0; i--) {
            System.out.print("Enter your login: ");
            String login = scanner.next();
            System.out.print("Enter your password: ");
            String password = scanner.next();

            for (User user : users) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    loggedInUser = user;
                    break;
                }
            }

            if (loggedInUser != null) {
                System.out.println("Login successful. Welcome, User " + loggedInUser.getLogin() + " !\n");
                break;
            } else if (i > 0) System.out.println("Login failed. Remaining attempts: " + i);
                else { System.err.println("Too many attempts, your account is closed. Please contact: 8 800 555 35 ");
                System.exit(0);
                }
        }


        if (loggedInUser.getBalance() < 0) {
            System.out.println("XD you are poor\n");
            return;
        } else System.out.println("Gosh, you are rich with: " + loggedInUser.getBalance() + "$\n");

        while (true) {
            System.out.println("Report your intentions: Balance (1), Withdraw (2), Deposit (3), Transfer (4), Sign out from the account (5) or Exit (6)");
            String intention = scanner.next();

            switch (intention) {
                case AtmOptions.BALANCE:
                    System.out.println("Balance: " + loggedInUser.getBalance() + "\n");
                    break;
                case WITHDRAW:
                case DEPOSIT:
                    updateBalance(scanner, intention, loggedInUser);
                    break;
                case TRANSFER:
                    transfers(loggedInUser, scanner, users);
                    break;
                case SIGNOUT:
                    System.err.println("Do you want to sign out from your account? Y / N");
                    finalTouch = scanner.next();
                    if (finalTouch.equals("Y")) {
                        operations(users);
                    }
                    else break;
                case EXIT:
                    System.err.println("Do you want to exit? Y/N");
                    finalTouch = scanner.next();
                    if (finalTouch.equals("Y")) {
                        System.exit(0);
                        System.out.println("Thank you for using our services! Goodbye :D ");
                    }
                    else break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void updateBalance(Scanner value, String intention, User loggedInUser) {

        double withdraw;
        System.out.println("Set amount: ");
        withdraw = value.nextDouble();

        if (withdraw <= loggedInUser.getBalance()) {
            if (intention.equals(WITHDRAW)) {

                loggedInUser.setBalance(loggedInUser.getBalance() - withdraw);
            } else {
                loggedInUser.setBalance(loggedInUser.getBalance() + withdraw);
            }
        } else System.err.println("Impossible to Withdraw due to account state");

        System.out.println("Current balance: " + loggedInUser.getBalance() + "\n");
    }

    private static void transfers (User loggedInUser, Scanner scanner, List<User> users){

        double amount, userNumber;

        System.out.println("How much to transfer?: ");
        amount = scanner.nextDouble();
        if (amount < 0) {
            System.err.println("You can not send negative values of transfer");
        }
        System.out.println("To which account does the transfer is implementing? (User1-5)");
        userNumber = scanner.nextDouble();
//        users.forEach(user -> {
//
//        });
        for (User user : users) {
            if (user.getLogin().equals(String.valueOf(userNumber).replace(".0",""))) {
                loggedInUser.setBalance(loggedInUser.getBalance() - amount);
                user.setBalance(user.getBalance() + amount);
                System.err.println("user");
                System.out.println("Transfered " + amount + " to another account\nCurrent balance: " + user.getBalance() + "\nTransfered successfuly\n");

                break;
            }
        }
    }
}

// Card number .