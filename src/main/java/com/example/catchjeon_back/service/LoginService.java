package com.example.catchjeon_back.service;

import com.example.catchjeon_back.dto.Login1Form;
import com.example.catchjeon_back.entity.Game;
import com.example.catchjeon_back.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final GameRepository gameRepository;

    public Game find1Login(Login1Form dto1) {
        // 사용자가 입력한 이메일과 비밀번호를 가져옴
        String mail = dto1.getMail();
        String passw = dto1.getPassw();

        // 데이터베이스에서 해당 이메일로 사용자를 찾음
        // 예시로 게임 엔티티를 찾는 것으로 가정
        Game game = gameRepository.findByMail(mail);

        // 사용자를 찾지 못하거나 비밀번호가 일치하지 않으면 null 반환
        if (game == null || !game.getPassw().equals(passw)) {
            return null;
        }

        // 사용자를 찾고 비밀번호도 일치하면 해당 게임 엔티티 반환
        return game;
    }
}
