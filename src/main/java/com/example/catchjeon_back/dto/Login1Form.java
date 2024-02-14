package com.example.catchjeon_back.dto;

import com.example.catchjeon_back.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter

public class Login1Form {
    private Long id;
    private String mail;
    private String passw;
    private String nickname;
    public Game toEntity() {
        return new Game(id, mail, passw, nickname);
    }

}
