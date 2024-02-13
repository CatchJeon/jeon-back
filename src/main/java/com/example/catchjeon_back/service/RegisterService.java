package com.example.catchjeon_back.service;

import com.example.catchjeon_back.dto.RegisterForm;
import com.example.catchjeon_back.entity.Register;
import com.example.catchjeon_back.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public Register create(RegisterForm dto) {
        Register register = dto.toEntity();
        if(register.getId() != null){
            return null;
        }
        return registerRepository.save(register);
    }
}
