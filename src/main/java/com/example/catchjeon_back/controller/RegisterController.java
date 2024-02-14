package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.entity.Game;
import com.example.catchjeon_back.repository.GameRepository;
import com.example.catchjeon_back.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @PostMapping("/api/register")
    public ResponseEntity<Game> create_register(@RequestBody RegisterForm dto){
        Game registerCreated = registerService.create(dto);
        return (registerCreated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(registerCreated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
