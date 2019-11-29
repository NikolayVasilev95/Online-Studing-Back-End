package com.branstarstech.nikolay.OlnineStuding.web.rest.controller.admin;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.domain.UserRole;
import com.branstarstech.nikolay.OlnineStuding.repository.RoleRepository;
import com.branstarstech.nikolay.OlnineStuding.repository.UserRepository;
import com.branstarstech.nikolay.OlnineStuding.repository.UserRoleRepository;
import com.branstarstech.nikolay.OlnineStuding.resorces.UserDTO;
import com.branstarstech.nikolay.OlnineStuding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserManagement {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/api/admin/user-management")
    public List<UserDTO> userManagementViewAllUsers(){
        return userService.getAllUsers().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping(value = "/api/admin/user-management/delete")
    public ResponseEntity<?> userManagementDeleteUser(@RequestParam @Positive long id){
        userService.deleteByID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/api/admin/user-management/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userManagementSaveUserRole(@RequestBody Object object){
        System.out.println(object);
//        @Positive long userId;
//        @NotBlank String roleName;
//        Optional<User> userFound = userService.findById(userId);
//        if (userFound.isPresent()){
//            userFound.get().getRoles().clear();
//            userFound.get().getRoles().add(new UserRole(userFound.get(), roleRepository.findByName(roleName).get()));
//            userRepository.save(userFound.get());
//        }
//        return ResponseEntity.ok("Success");
        return null;
    }
}
