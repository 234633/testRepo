package org.example;

public class Sample {

    import java.util.*;

    class User {
        private String login;
        private String password;
        private double balance;

        public User(String login, String password, double balance) {
            this.login = login;
            this.password = password;
            this.balance = balance;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public double getBalance() {
            return balance;
        }
    }

    public class LoginSystem {
        public static void main(String[] args) {
            // Storing users in a list
            List<User> users = new ArrayList<>();
            users.add(new User("1", "1", 1000));
            users.add(new User("2", "2", 1000));
            users.add(new User("3", "3", 1000));
            users.add(new User("4", "4", 1000));
            users.add(new User("5", "5", 1000));

            operations(users);
        }

        public static void operations(List<User> users) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 2; i >= 0; i--) {
                System.out.print("Enter your login: ");
                String login = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();

                // Check if login credentials match any user
                User loggedInUser = null;
                for (User user : users) {
                    if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                        loggedInUser = user;
                        break;
                    }
                }

                if (loggedInUser != null) {
                    System.out.println("Login successful. Welcome, " + loggedInUser.getLogin() + "!\n");
                    break;
                } else {
                    System.out.println("Login failed. Remaining attempts: " + i);
                }
            }
            scanner.close();
        }
    }

}
