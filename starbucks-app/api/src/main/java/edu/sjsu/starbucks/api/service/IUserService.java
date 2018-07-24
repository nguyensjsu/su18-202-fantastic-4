package edu.sjsu.starbucks.api.service;

import edu.sjsu.starbucks.api.request.CreateUserRequest;
import edu.sjsu.starbucks.api.response.UserResponse;

public interface IUserService {

    public UserResponse createUser(CreateUserRequest request);

    public UserResponse getUserByEmail(String userName);
}
