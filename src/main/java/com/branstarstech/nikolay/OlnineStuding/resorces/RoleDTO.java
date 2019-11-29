package com.branstarstech.nikolay.OlnineStuding.resorces;

import com.branstarstech.nikolay.OlnineStuding.domain.Role;

public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(String name) {
        this.name = name;
    }

    public RoleDTO(Role role) {
        id = role.getId();
        name = role.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
