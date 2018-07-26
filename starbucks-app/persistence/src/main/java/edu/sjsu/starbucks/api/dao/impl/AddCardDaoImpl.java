package edu.sjsu.starbucks.api.dao.impl;

import edu.sjsu.starbucks.api.dao.AddCardDao;
import edu.sjsu.starbucks.model.Card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AddCardDaoImpl implements AddCardDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addCard(Card card) {
        mongoTemplate.save(card);
    }

    @Override
    public List<Card> getCards(String userName) {
        // Criteria criteria = Criteria.where("").is(userName);
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        System.out.println("query - " + query.toString());
        List<Card> card = mongoTemplate.find(query, Card.class);
        return card;
    }

    @Override
    public void saveAll(List<Card> updatedList) {
        for(Card card : updatedList) {
            mongoTemplate.save(card);
        }
    }
}
