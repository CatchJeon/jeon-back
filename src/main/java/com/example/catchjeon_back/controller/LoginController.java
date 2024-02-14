package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.dto.Login1Form;
import com.example.catchjeon_back.entity.Game;
import com.example.catchjeon_back.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {
    private LoginService loginService;
    @GetMapping("/api/login")
    public ResponseEntity<Game> login1(@RequestBody Login1Form dto1){
        Game login1entity = loginService.find1Login(dto1);
        return ResponseEntity.status(HttpStatus.OK).body(login1entity);
    }


}
