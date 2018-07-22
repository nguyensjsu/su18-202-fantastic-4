package edu.sjsu.starbucks.api.dao;

import edu.sjsu.starbucks.model.User;

public interface UserDao {

    public void createUser(User user);
    public User getUserByEmailId(String email);
}
