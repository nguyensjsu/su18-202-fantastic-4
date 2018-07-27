package edu.sjsu.starbucks.api.request;

import java.io.Serializable;

public class AddCardRequest implements Serializable {

    private static final long serialVersionUID = 6401765435392998104L;
    private String cardNumber;
    private int cvv;
    private double balance;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
