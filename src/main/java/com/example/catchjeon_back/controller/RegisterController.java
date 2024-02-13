package com.example.catchjeon_back.controller;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.entity.Register;
import com.example.catchjeon_back.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/register")
    public ResponseEntity<Register> create_register(@RequestBody RegisterForm dto){
        Register created = registerService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
