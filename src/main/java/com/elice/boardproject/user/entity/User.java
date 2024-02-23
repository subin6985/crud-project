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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

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
    @Column(nullable = false)
    private boolean status = true;

    public User(String id, String password, String nickname, String email, String profileImg) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;
    }
}
