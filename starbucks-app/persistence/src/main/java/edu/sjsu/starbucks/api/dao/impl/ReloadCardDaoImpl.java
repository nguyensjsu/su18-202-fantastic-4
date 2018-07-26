package edu.sjsu.starbucks.api.dao.impl;

import edu.sjsu.starbucks.api.dao.ReloadCardDao;
import edu.sjsu.starbucks.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReloadCardDaoImpl implements ReloadCardDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void ReloadCard(Card card) {
        mongoTemplate.save(card);
    }
}
