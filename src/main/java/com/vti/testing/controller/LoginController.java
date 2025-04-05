package com.vti.testing.controller;

import com.vti.testing.dto.LoginResponse;
import com.vti.testing.form.LoginForm;
import com.vti.testing.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginForm form) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtils.generateJwt(authentication);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        return ResponseEntity.ok(loginResponse);
    }
}
