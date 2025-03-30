package org.example;

public class User {
    private String login;
    private String password;
    private String cardNumber;
    private double balance;

//    public User(String login, String password, String cardNumber, double balance) {
//        this.login = login;
//        this.password = password;
//        this.cardNumber = cardNumber;
//        this.balance = balance; //конструктор
//    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public double getBalance() {
        return balance;
    }

    public void setLogin(String value) {
        login = value;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setCardNumber (String cardNumber){
        this.cardNumber = cardNumber;
    }
    public void setBalance (double balance){
        this.balance = balance;
    }

}
