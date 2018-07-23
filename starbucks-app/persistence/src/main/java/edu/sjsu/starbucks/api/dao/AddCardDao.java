package edu.sjsu.starbucks.api.dao;

import edu.sjsu.starbucks.model.Card;

public interface AddCardDao {
        public void AddCard(Card card);

        public Card GetCards(String userName);
}
