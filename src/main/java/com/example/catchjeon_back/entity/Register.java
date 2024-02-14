package com.example.catchjeon_back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String mail;
    @Column
    private String passw;
    @Column(unique = true)
    private String nickname;

    @Builder
    public Register(String mail, String passw, String nickname){
        this.mail=mail;
        this.passw=passw;
        this.nickname=nickname;
    }

    public void patch(Register register) {
        if (register.mail != null)
            this.mail = register.mail;
        if (register.passw != null)
            this.passw = register.passw;
        if (register.nickname != null)
            this.nickname = register.nickname;
    }
}
