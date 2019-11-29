package com.branstarstech.nikolay.OlnineStuding.repository;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.domain.UserRole;
import com.branstarstech.nikolay.OlnineStuding.domain.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

}
