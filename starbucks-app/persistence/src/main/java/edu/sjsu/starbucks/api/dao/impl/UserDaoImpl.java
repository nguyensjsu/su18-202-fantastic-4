package edu.sjsu.starbucks.api.dao.impl;

import edu.sjsu.starbucks.api.dao.UserDao;
import edu.sjsu.starbucks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void createUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User getUserByEmailId(String email) {
        Criteria criteria = Criteria.where("userName").is(email);
        Query query = new Query(criteria);
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }
}
