package edu.sjsu.starbucks.api.request;

import java.io.Serializable;

public class ReloadCardRequest implements Serializable{
    private long cardNumber;
    private double balance;
    private String userName;
    private String cvv;

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
