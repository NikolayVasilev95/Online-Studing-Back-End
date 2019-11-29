package com.branstarstech.nikolay.OlnineStuding.config;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.resorces.RoleDTO;
import com.branstarstech.nikolay.OlnineStuding.resorces.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MySimpleUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        User user = (User) authentication.getPrincipal();
        UserDTO userDTO = new UserDTO(user);
        response.getWriter().write(objectMapper.writeValueAsString(userDTO));
        clearAuthenticationAttributes(request);
    }

}
