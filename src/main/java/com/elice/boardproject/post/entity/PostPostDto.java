package com.elice.boardproject.post.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostPostDto {
    private String title;
    private String seat;
    private int score;
    private String content;
}