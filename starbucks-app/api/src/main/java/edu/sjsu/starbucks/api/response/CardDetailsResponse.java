package edu.sjsu.starbucks.api.response;

import java.io.Serializable;
import java.util.List;

public class CardDetailsResponse implements Serializable {

    private static final long serialVersionUID = 7771908766675379676L;
    private String userName;
    List<CardResponse> cards;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<CardResponse> getCards() {
        return cards;
    }
    public void setCards(List<CardResponse> cards) {
        this.cards = cards;
    }
}
