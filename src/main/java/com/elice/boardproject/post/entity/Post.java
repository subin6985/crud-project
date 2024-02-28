package com.elice.boardproject.post.entity;

import com.elice.boardproject.board.entity.Board;
import com.elice.boardproject.global.entity.BaseEntity;
import com.elice.boardproject.user.entity.User;
import com.elice.boardproject.image.entity.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "post")
    private List<Image> images = new ArrayList<>();
    @Column(
            nullable = false,
            length = 30
    )
    private String title;
    @Column(
            nullable = false,
            length = 30
    )
    private String hall;
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

    public Post(Board board, String title, String hall, String seat, int score, String content) {
        this.board = board;
        this.title = title;
        this.hall = hall;
        this.seat = seat;
        this.score = score;
        this.content = content;
    }

    public Post(Board board, User user, String title, String hall, String seat, int score, String content) {
        this.board = board;
        this.user = user;
        this.title = title;
        this.hall = hall;
        this.seat = seat;
        this.score = score;
        this.content = content;
    }
}
