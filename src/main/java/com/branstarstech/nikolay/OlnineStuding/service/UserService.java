package com.branstarstech.nikolay.OlnineStuding.service;

import com.branstarstech.nikolay.OlnineStuding.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> findByNameOrEmail(String name, String email);

    Optional<User> findByName(String name);


    User createUser(User user);

    User updateUser(User user);

    void deleteByID(long id);

    Optional<User> findById(long id);
}
