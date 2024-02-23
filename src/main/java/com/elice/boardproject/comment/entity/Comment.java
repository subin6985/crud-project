package com.elice.boardproject.comment.entity;

import com.elice.boardproject.global.entity.BaseEntity;
import com.elice.boardproject.post.entity.Post;
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
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "post_id",
            nullable = false
    )
    private Post post;
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

    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public Post getPost() {
        return this.post;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreatedAt() { return this.createdAt; }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPost(final Post post) {
        this.post = post;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Comment() {
    }
}
