package com.example.catchjeon_back.dto;

import com.example.catchjeon_back.entity.Register;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterForm {
    private Long id;

    @NotBlank(message="null, 빈 문자열, 공백을 허용하지 않습니다.")
    @Pattern(regexp="^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$", message="이메일 형식으로 써주세요.")
    private String mail;

    @NotBlank(message="null, 빈 문자열, 공백을 허용하지 않습니다.")
    private String passw;

    @NotBlank(message="null, 빈 문자열, 공백을 허용하지 않습니다.")
    @Size(max=10, message="닉네임 글자 수는 10자리를 넘을 수 없습니다.")
    private String nickname;
    public Register toEntity() {
        return new Register(id, mail, passw, nickname);
    }
}
