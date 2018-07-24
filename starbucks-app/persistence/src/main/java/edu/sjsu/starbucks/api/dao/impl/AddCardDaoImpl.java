package edu.sjsu.starbucks.api.dao.impl;

import edu.sjsu.starbucks.api.dao.AddCardDao;
import edu.sjsu.starbucks.model.Card;
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
    public void AddCard(Card card) {
        mongoTemplate.save(card);
    }

    @Override
    public Card GetCards(String userName) {
        //Criteria criteria = Criteria.where("").is(userName);
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        System.out.println("query - " + query.toString());
        Card card = mongoTemplate.findOne(query, Card.class);
        return card;
    }
}
