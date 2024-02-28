package com.elice.boardproject.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    private String id;
    @Column(
            nullable = false,
            length = 20
    )
    private String password;
    @Column(
            nullable = false,
            length = 5
    )
    private String nickname;
    @Column(
            nullable = false,
            length = 30
    )
    private String email;
    @Column(
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String profileImg;
    @Column(
            nullable = false
    )
    private boolean status = true;

    public User(String id, String password, String nickname, String email) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public User(String id, String password, String nickname, String email, String profileImg) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
    }
}
