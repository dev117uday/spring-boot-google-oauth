package com.example.jwt.repository.userRepository;

import com.example.jwt.model.User;

public interface UserRepository {

    Boolean insertUser(User user, String userName);

}
