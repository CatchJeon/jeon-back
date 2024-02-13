package com.example.catchjeon_back.dto;

import com.example.catchjeon_back.entity.Register;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RegisterForm {
    private Long id;
    private String mail;
    private String passw;
    private String nickname;
    public Register toEntity() {
        return new Register(id, mail, passw, nickname);
    }
}
