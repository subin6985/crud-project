package com.elice.boardproject.image.entity;

import com.elice.boardproject.post.entity.Post;
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            name="post_id",
            nullable = false
    )
    private Post post;
    @Column(nullable = false)
    private boolean thumbnail;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    public Image(Post post, boolean thumbnail, String imageUrl) {
        this.post = post;
        this.thumbnail = thumbnail;
        this.imageUrl = imageUrl;
    }
}
