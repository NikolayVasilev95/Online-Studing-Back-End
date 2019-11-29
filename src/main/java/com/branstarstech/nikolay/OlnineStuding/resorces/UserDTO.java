package com.branstarstech.nikolay.OlnineStuding.resorces;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.domain.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<RoleDTO> roles;

    public UserDTO(){}

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        password = user.getPassword();
        roles = user.getRoles().stream().map(UserRole::getRole).map(RoleDTO::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Long getId(){
        return this.id;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
