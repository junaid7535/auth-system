package com.example.demo.controller;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.security.JwtUtil;
import com.example.demo.dto.AuthRequest;

@RestController
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager manager, JwtUtil jwtUtil) {
        this.manager = manager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest req) {

        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(), req.getPassword()));

        return jwtUtil.generateToken(req.getUsername());
    }
}

