package edu.sjsu.starbucks.api.dao;

import java.util.List;

import edu.sjsu.starbucks.model.Card;

public interface AddCardDao {

        public void addCard(Card card);

        public List<Card> getCards(String userName);

        public void saveAll(List<Card> updatedList);
}
