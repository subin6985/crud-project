package com.elice.boardproject.post.entity;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.global.entity.BaseEntity;
import com.elice.boardproject.user.entity.User;
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
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "board_id",
            nullable = false
    )
    private Board board;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    @Column(
            nullable = false,
            length = 30
    )
    private String title;
    @Column(
            nullable = false,
            length = 30
    )
    private String seat;
    @Column(nullable = false)
    private int score;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime createdAt;

    public Post(Board board, User user, String title, String seat, int score, String content) {
        this.board = board;
        this.user = user;
        this.title = title;
        this.seat = seat;
        this.score = score;
        this.content = content;
    }
}
