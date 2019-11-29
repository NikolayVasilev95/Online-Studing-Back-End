package com.branstarstech.nikolay.OlnineStuding.repository;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameOrEmail(String name, String email);
    Optional<User> findByName(String name);
}
