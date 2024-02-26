package com.elice.boardproject.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PostPostDto {
    private Long id;
    private String title;
    private String seat;
    private int score;
    private String content;
}