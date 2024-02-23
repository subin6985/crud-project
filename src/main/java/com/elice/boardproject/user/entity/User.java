package com.elice.boardproject.user.entity;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

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

    public String getId() { return this.id; }

    public String getPassword() { return this.password; }

    public String getNickname() { return this.nickname; }

    public String getEmail() { return this.email; }

    public String getProfileImg() { return this.profileImg; }

    public boolean getStatus() { return this.status; }

    public void setId(String id) { this.id = id; }

    public void setPassword(String password) { this.password = password; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public void setEmail(String email) { this.email = email; }

    public void setProfileImg(String profileImg) { this.profileImg = profileImg; }

    public void setStatus(boolean status) { this.status = status; }

    public User() {}

    public User(String id, String password, String nickname, String email, String profileImg) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
    }

    public User(String id, String password, String nickname, String email, String profileImg, boolean status) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
        this.status = status;
    }
}
