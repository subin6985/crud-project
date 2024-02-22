package com.elice.boardproject.board.entity;

import com.elice.boardproject.post.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners({AuditingEntityListener.class})
@Entity
public class Board {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true,
            length = 20
    )
    private String name;
    @Column(
            length = 200
    )
    private String description;
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime createdAt;
    @OneToMany(
            mappedBy = "board"
    )
    private final List<Post> posts = new ArrayList();

    public Board(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static BoardBuilder builder() {
        return new BoardBuilder();
    }

    public BoardBuilder toBuilder() {
        return (new BoardBuilder()).id(this.id).name(this.name).description(this.description).createdAt(this.createdAt);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public Board() {
    }

    public Board(final Long id, final String name, final String description, final LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static class BoardBuilder {
        private Long id;
        private String name;
        private String description;
        private LocalDateTime createdAt;

        BoardBuilder() {
        }

        public BoardBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public BoardBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public BoardBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public BoardBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Board build() {
            return new Board(this.id, this.name, this.description, this.createdAt);
        }

        public String toString() {
            return "Board.BoardBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", createdAt=" + this.createdAt + ")";
        }
    }
}