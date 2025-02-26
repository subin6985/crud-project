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
    private String title;
    private String hall;
    private String seat;
    private String score;
    private String content;
}