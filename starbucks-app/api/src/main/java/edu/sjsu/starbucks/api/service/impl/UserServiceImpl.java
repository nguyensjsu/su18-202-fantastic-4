package edu.sjsu.starbucks.api.service.impl;

import edu.sjsu.starbucks.api.dao.UserDao;
import edu.sjsu.starbucks.api.request.CreateUserRequest;
import edu.sjsu.starbucks.api.response.UserResponse;
import edu.sjsu.starbucks.api.service.IUserService;
import edu.sjsu.starbucks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());

        userDao.createUser(user);

        User dbUser = userDao.getUserByEmailId(request.getUserName());

        UserResponse response = new UserResponse();
        response.setId(dbUser.getId());
        response.setUserName(dbUser.getUserName());

        return response;
    }

    @Override
    public UserResponse getUserByEmail(String userName) {
        User dbUser = userDao.getUserByEmailId(userName);

        UserResponse response = new UserResponse();
        response.setId(dbUser.getId());
        response.setUserName(dbUser.getUserName());

        return response;
    }
}
