package com.branstarstech.nikolay.OlnineStuding.repository;

import com.branstarstech.nikolay.OlnineStuding.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
