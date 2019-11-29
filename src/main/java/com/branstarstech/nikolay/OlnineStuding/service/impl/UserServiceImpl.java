package com.branstarstech.nikolay.OlnineStuding.service.impl;

import com.branstarstech.nikolay.OlnineStuding.domain.Role;
import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.domain.UserRole;
import com.branstarstech.nikolay.OlnineStuding.repository.RoleRepository;
import com.branstarstech.nikolay.OlnineStuding.repository.UserRepository;
import com.branstarstech.nikolay.OlnineStuding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByNameOrEmail(String name, String email) {
        return userRepository.findByNameOrEmail(name, email);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User createUser(User user) {
        user.getRoles().add(new UserRole(user, roleRepository.findByName("USER").orElseGet(() -> new Role("USER"))));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteByID(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
}
