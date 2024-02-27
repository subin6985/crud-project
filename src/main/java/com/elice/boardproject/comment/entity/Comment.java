package com.elice.boardproject.comment.entity;

import com.elice.boardproject.global.entity.BaseEntity;
import com.elice.boardproject.post.entity.Post;
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

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "post_id",
            nullable = false
    )
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;

    public Comment(Post post, String content) {
        this.post = post;
        this.content = content;
    }

    public Comment(Post post, User user, String content) {
        this.post = post;
        this.user = user;
        this.content = content;
    }
}
