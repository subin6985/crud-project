package com.elice.boardproject.post.entity;

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
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "board_id",
            nullable = false
    )
    private Board board;
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
    @Column(
            nullable = false
    )
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

    public Post(Board board, String title, String seat, int score, String content) {
        this.board = board;
        this.title = title;
        this.seat = seat;
        this.score = score;
        this.content = content;
    }

    public void setBoard(Board board) {
        this.board = board;
        if (!this.board.getPosts().contains(this)) {
            this.board.getPosts().add(this);
        }

    }

    public Long getId() {
        return this.id;
    }

    public Board getBoard() {
        return this.board;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSeat() { return this.seat; }

    public int getScore() { return this.score; }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreatedAt() { return this.createdAt; }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setSeat(final String seat) { this.seat = seat; }

    public void setScore(final int score) { this.score = score; }

    public void setContent(final String content) {
        this.content = content;
    }

    public Post() {
    }

    public Post(final Long id, final Board board, final String title, final String seat, final int score, final String content, LocalDateTime createdAt) {
        this.id = id;
        this.board = board;
        this.title = title;
        this.seat = seat;
        this.score = score;
        this.content = content;
        this.createdAt = createdAt;
    }
}
