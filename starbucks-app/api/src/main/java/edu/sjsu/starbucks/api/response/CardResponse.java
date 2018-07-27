package edu.sjsu.starbucks.api.response;

import java.io.Serializable;

import edu.sjsu.starbucks.model.common.CardStatus;

public class CardResponse implements Serializable {

    private static final long serialVersionUID = -4654493234073518450L;
    private String cardNumber;
    private double balance;
    private CardStatus status;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

}
