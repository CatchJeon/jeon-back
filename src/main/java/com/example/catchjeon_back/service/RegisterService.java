package com.example.catchjeon_back.service;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.entity.Game;
import com.example.catchjeon_back.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RegisterService {
    @Autowired
    private GameRepository registerRepository;

    public Game create(RegisterForm dto) {
        Game register = dto.toEntity();
        if(register.getId() != null){
            return null;
        }
        return registerRepository.save(register);
    }

}
