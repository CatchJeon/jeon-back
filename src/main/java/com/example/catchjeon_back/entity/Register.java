package com.example.catchjeon_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String mail;
    @Column
    private String passw;
    @Column
    private String nickname;

    public void patch(Register register) {
        if (register.mail != null)
            this.mail = register.mail;
        if (register.passw != null)
            this.passw = register.passw;
        if (register.nickname != null)
            this.nickname = register.nickname;
    }
}
