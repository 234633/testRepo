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
    public static void operations(List<User> users){
        Scanner scanner = new Scanner(System.in);
        double amount;
        String finalTouch;
        User logInUser = null;

        while (true) {
            for (int i = 2; i >= 0; i--) {
                System.out.println("Enter your login: ");
                String login = scanner.next();
                System.out.println("Enter your password: ");
                String password = scanner.next();
                for (User user : users){
                    if (user.getLogin().equals(login) && user.getPassword().equals(password))
                        logInUser = user;}

                if (logInUser != null) {
                    System.out.println("Login successful.\n");
                    break;}
                    else System.out.println("Login failed. Remaining attemts: " + i);
            }
        }

//        if (user.getBalance() < 0) {
//            System.out.println("XD you are poor\n");
//            return;
//        } else System.out.println("Gosh, you are rich with: " + user.getBalance() + "$\n");
//
//        while (true) {
//            System.out.println("Report your intentions: Balance (1), Withdraw (2), Deposit (3), Transfer (4) or Sign out from the account (5)");
//            String intention = scanner.next();
//
//            switch (intention) {
//                case AtmOptions.BALANCE:
//                    System.out.println("Balance: " + user.getBalance() + "\n");
//                    break;
//                case WITHDRAW:
//                case DEPOSIT:
//                    updateBalance(scanner, intention, user);
//                    break;
//                case TRANSFER:
//                    System.out.println("How much to transfer?: ");
//                    amount = scanner.nextDouble();
//                    user.setBalance(user.getBalance() - amount);
//
//                    user.setBalance(user.getBalance() + amount);
//                    System.out.println("Transfered " + amount + " to another account\nCurrent balance: " + user.getBalance() + "\nTransfered successfuly\n");
//                    break;
//                case EXIT:
//                    System.err.println("Do you want to sign out from your account? Y / N");
//                    finalTouch = scanner.next();
//                    if (finalTouch.equals("Y")) {
//                        System.exit(0);
//                        System.out.println("Thank you for using our servises!\n Goodbye :D ");
//                    }
//                    else break;
//                default:
//                    System.out.println("Invalid option");
//                    break;
//            }
//        }
    }

//    private static void updateBalance(Scanner value, String intention, User user) {
//
//
//        System.out.println("Set amount: ");
//        if (intention.equals(WITHDRAW)) {
//            user.setBalance(user.getBalance() - value.nextDouble());
//        } else {
//            user.setBalance(user.getBalance() + value.nextDouble());
//        }
//        System.out.println("Current balance: " + user.getBalance() + "\n");
//    }
}


// Let the account work
// with - balance
// card number for each user .